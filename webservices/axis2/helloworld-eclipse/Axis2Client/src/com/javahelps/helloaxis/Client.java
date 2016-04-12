package com.javahelps.helloaxis;

public class Client {
    public static void main(String[] args) throws Exception {
        // Create the stub object
        HelloServiceStub stub = new HelloServiceStub();

        // Create the request
        HelloServiceStub.SayHello request = new HelloServiceStub.SayHello();

        // Set the parameters
        request.setName("Gobinath");

        // Invoke the service
        HelloServiceStub.SayHelloResponse response = stub.sayHello(request);
        String res = response.get_return(); // Hello Gobinath
        System.out.println("Response : " + res);
    }
}
