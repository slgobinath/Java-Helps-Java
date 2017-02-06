#!/usr/bin/env python

import sys
sys.path.append('gen-py')
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from thrift.server import TServer
from ServerHandler import ServerHandler
from ThriftEventTransmissionService import ThriftEventTransmissionService

SERVER_ADDRESS = 'localhost'
SERVER_PORT = 8888

handler = ServerHandler()
processor = ThriftEventTransmissionService.Processor(handler)
transport = TSocket.TServerSocket(SERVER_ADDRESS, SERVER_PORT)
tfactory = TTransport.TBufferedTransportFactory()
pfactory = TBinaryProtocol.TBinaryProtocolFactory()

server = TServer.TSimpleServer(processor, transport, tfactory, pfactory)

print 'Starting TCP Server at ' + SERVER_ADDRESS + ':' + str(SERVER_PORT)

server.serve()
