package com.javahelps.jerseydemo.app;

import org.glassfish.jersey.server.ResourceConfig;

public class HelloWorldApplication extends ResourceConfig {
    public HelloWorldApplication() {
        // Define the package which contains the service classes.
        packages("com.javahelps.jerseydemo.services");
    }
}
