package com.javahelps.ogmhelloworld;

import java.util.Collections;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

import com.javahelps.ogmhelloworld.entities.Course;
import com.javahelps.ogmhelloworld.entities.Student;

public class Main {

	public static final String NEO4J_URL = "http://localhost:7474";
	public static final String USERNAME = "neo4j";
	public static final String PASSWORD = "admin";

	public static void main(String[] args) {
		// Create SessionFactory. Pass the package name of the entity classes as
		// the argument.
		SessionFactory sessionFactory = new SessionFactory("com.javahelps.ogmhelloworld.entities");

		// Create the session
		Session session = sessionFactory.openSession(NEO4J_URL, USERNAME, PASSWORD);

		// Create few courses
		Course oop = new Course();
		oop.setName("Object Oriented Programming");
		oop.setCredits(2.0f);

		Course algo = new Course();
		algo.setName("Advanced Algorithm");
		algo.setCredits(3.0f);

		Course db = new Course();
		db.setName("Database Internals");
		db.setCredits(3.0f);

		// Create few students
		Student alice = new Student();
		alice.setName("Alice");

		Student bob = new Student();
		bob.setName("Bob");

		Student carol = new Student();
		carol.setName("Carol");

		// Add the courses
		alice.getCourses().add(oop);
		alice.getCourses().add(algo);
		alice.getCourses().add(db);

		bob.getCourses().add(oop);
		bob.getCourses().add(algo);

		carol.getCourses().add(algo);
		carol.getCourses().add(db);

		// Persist the objects. Persisting students persists courses as well.
		session.save(alice);
		session.save(bob);
		session.save(carol);

		// Retrieve Students who enrolled for Advanced Algorithm
		Iterable<Student> students = session.query(Student.class,
				"MATCH (c:Course)<-[:ENROLLED]-(student) WHERE c.name = 'Advanced Algorithm' RETURN student",
				Collections.<String, Object> emptyMap());

		// Print all the Students
		for (Student stu : students) {
			System.out.println(stu.getName());
		}
	}

}
