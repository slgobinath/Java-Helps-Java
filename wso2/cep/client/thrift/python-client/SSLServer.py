#!/usr/bin/env python

import sys
import os
sys.path.append('gen-py')
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from thrift.server import TServer
from thrift.transport import TSSLSocket
from ServerHandler import ServerHandler
from ThriftSecureEventTransmissionService import ThriftSecureEventTransmissionService


SERVER_ADDRESS = 'localhost'
SERVER_PORT = 8988
CERTIFICATE_FILE = os.path.join(os.path.dirname(os.path.realpath(__file__)), 'server.pem')

handler = ServerHandler()
processor = ThriftSecureEventTransmissionService.Processor(handler)
transport = TSSLSocket.TSSLServerSocket(SERVER_ADDRESS, SERVER_PORT, certfile=CERTIFICATE_FILE)
tfactory = TTransport.TBufferedTransportFactory()
pfactory = TBinaryProtocol.TBinaryProtocolFactory()

server = TServer.TSimpleServer(processor, transport, tfactory, pfactory)

print 'Starting SSL Server at ' + SERVER_ADDRESS + ':' + str(SERVER_PORT)

server.serve()
