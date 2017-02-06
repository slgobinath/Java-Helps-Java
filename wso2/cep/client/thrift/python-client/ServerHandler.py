#!/usr/bin/env python


class ServerHandler(object):
    """
        ServerHandler contains the functions to serve the requests from WSO2 CEP.
    """
    def __init__(self):
        pass

    """
        Receive the username and password, verify it and return a unique session id.
    """
    def connect(self, uname, password):
        print 'Connect ' + uname + ':' + password
        return '123456'  # A random session id

    """
        Destroy the session.
    """
    def disconnect(self, sessionId):
        print 'Disconnect the session ' + str(sessionId)

    def defineStream(self, sessionId, streamDefinition):
        return ''

    def findStreamId(self, sessionId, streamName, streamVersion):
        return ''

    """
        Receive the event and process it.
    """
    def publish(self, eventBundle):
        print 'Received a new event: ' + str(eventBundle) + '\n'

    def deleteStreamById(self, sessionId, streamId):
        pass

    def deleteStreamByNameVersion(self, sessionId, streamName, streamVersion):
        pass
