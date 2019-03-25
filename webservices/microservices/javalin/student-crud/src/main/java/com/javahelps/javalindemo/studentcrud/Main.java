package com.javahelps.javalindemo.studentcrud;

import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.crud;

public class Main {

    public static void main(String[] args) {

        Javalin app = Javalin.create()
                .enableCorsForAllOrigins()
                .start(8080);

        app.routes(() -> crud("/students/:student-id", new StudentController()));
    }
}
