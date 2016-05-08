package com.javahelps.samplecarbon.ui;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;

import com.javahelps.samplecarbon.stub.SampleServiceStub;

public class SampleServiceClient {
    private final SampleServiceStub stub;

    public SampleServiceClient(ConfigurationContext configCtx, String backendServerURL, String cookie)
            throws AxisFault {
        String serviceURL = backendServerURL + "SampleService";
        stub = new SampleServiceStub(configCtx, serviceURL);
        ServiceClient client = stub._getServiceClient();
        Options options = client.getOptions();
        options.setManageSession(true);
        options.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING, cookie);
    }

    public String[] getLanguages() throws RemoteException {
        return stub.getLanguages();
    }
}
