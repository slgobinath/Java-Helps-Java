package com.javahelps.javalindemo.contactus;

import io.javalin.Javalin;

public class Main {

    public static void main(String[] args) {
        Javalin app = Javalin.create()
                .port(8080)
                .enableStaticFiles("web")
                .start();

        app.post("/contact-us", ctx -> {
            String fullName = ctx.formParam("firstName") + " " + ctx.formParam("lastName");
            String subject = ctx.formParam("subject");
            String message = ctx.formParam("message");
            System.out.println("Message received from " + fullName);
            System.out.println("Subject: " + subject);
            System.out.println(message);
            ctx.redirect("/success.html");
        });
    }
}
