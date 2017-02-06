#!/usr/bin/env python

import sys
import time
sys.path.append('gen-py')

from ThriftSecureEventTransmissionService import ThriftSecureEventTransmissionService
from ThriftEventTransmissionService import ThriftEventTransmissionService
from ThriftEventTransmissionService.ttypes import *

from thrift import Thrift
from thrift.transport import TSSLSocket
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol


class Publisher:

    """
        Create SSL and TCP sockets along with buffer and binary protocol.
    """
    def __init__(self, ip, ssl_port, tcp_port):
        # Make SSL socket
        self.ssl_socket = TSSLSocket.TSSLSocket(ip, ssl_port, False)
        self.ssl_transport = TTransport.TBufferedTransport(self.ssl_socket)
        self.ssl_protocol = TBinaryProtocol.TBinaryProtocol(self.ssl_transport)

        # Make TCP socket
        self.tcp_socket = TSocket.TSocket(ip, tcp_port)
        self.tcp_transport = TTransport.TBufferedTransport(self.tcp_socket)
        self.tcp_protocol = TBinaryProtocol.TBinaryProtocol(self.tcp_transport)

    def connect(self, username, password):
        # Create a client to use the protocol encoder
        self.ssl_client = ThriftSecureEventTransmissionService.Client(self.ssl_protocol)
        self.tcp_client = ThriftEventTransmissionService.Client(self.tcp_protocol)

        # Make connection
        self.ssl_socket.open()
        # self.transport.open()
        self.sessionId = self.ssl_client.connect(username, password)

        self.tcp_socket.open()

    def defineStream(self, streamDef):
        # Create Stream Definition
        return self.tcp_client.defineStream(self.sessionId, streamDef)

    def publish(self, streamId, *attributes):
        # Build thrift event bundle
        event = EventBundle()
        event.setSessionId(self.sessionId)
        event.setEventNum(1)
        event.addLongAttribute(time.time() * 1000)
        event.addStringAttribute(streamId)
        for attr in attributes:
            if isinstance(attr, int):
                event.addIntAttribute(attr)
            elif isinstance(attr, basestring):
                event.addStringAttribute(attr)
            elif isinstance(attr, long):
                event.addLongAttribute(attr)
            elif isinstance(attr, float):
                event.addDoubleAttribute(attr)
            elif isinstance(attr, bool):
                event.addBoolAttribute(attr)
            else:
                event.setArbitraryDataMapMap(attr)

        # Publish
        self.tcp_client.publish(event.getEventBundle())

    def disconnect(self):
        # Disconnect
        self.ssl_client.disconnect(self.sessionId)
        self.ssl_transport.close()
        self.ssl_socket.close()

        self.tcp_transport.close()
        self.tcp_socket.close()


class EventBundle:
    __sessionId = ""
    __eventNum = 0
    __intAttributeList = []
    __longAttributeList = []
    __doubleAttributeList = []
    __boolAttributeList = []
    __stringAttributeList = []
    __arbitraryDataMapMap = None

    def setSessionId(self, sessionId):
        self.__sessionId = sessionId

    def setEventNum(self, num):
        self.__eventNum = num

    def addIntAttribute(self, attr):
        self.__intAttributeList.append(attr)

    def addLongAttribute(self, attr):
        self.__longAttributeList.append(attr)

    def addDoubleAttribute(self, attr):
        self.__doubleAttributeList.append(attr)

    def addBoolAttribute(self, attr):
        self.__boolAttributeList.append(attr)

    def addStringAttribute(self, attr):
        self.__stringAttributeList.append(attr)

    def setArbitraryDataMapMap(self, attr):
        self.__arbitraryDataMapMap = attr

    def getEventBundle(self):
        return Data.ttypes.ThriftEventBundle(self.__sessionId, self.__eventNum, self.__intAttributeList, self.__longAttributeList, self.__doubleAttributeList, self.__boolAttributeList, self.__stringAttributeList, self.__arbitraryDataMapMap)
