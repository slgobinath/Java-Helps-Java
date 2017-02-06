#!/usr/bin/env python

from Publisher import Publisher

CEP_SERVER_ADDRESS = '192.168.122.1'	# IP address of the server. You can find it at the end of the CEP console
SSL_PORT = 7711		# Thrift SSL port of the server
TCP_PORT = 7611     # Thrift TCP port of the server
USERNAME = 'admin'	# Username
PASSWORD = 'admin' 	# Passowrd

publisher = Publisher(CEP_SERVER_ADDRESS, SSL_PORT, TCP_PORT)

# Connect to server with username and password
publisher.connect(USERNAME, PASSWORD)

# Publish an event to the Temperature stream
publisher.publish('com.javahelps.stream.Temperature:1.0.0', 'Kitchen', 56)

# Disconnect
publisher.disconnect()
