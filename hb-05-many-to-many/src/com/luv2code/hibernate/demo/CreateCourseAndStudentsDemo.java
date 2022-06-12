package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
						 		 .configure("hibernate.cfg.xml")
						 		 .addAnnotatedClass(Instructor.class)
						 		 .addAnnotatedClass(InstructorDetail.class)
						 		 .addAnnotatedClass(Course.class)
						 		 .addAnnotatedClass(Review.class)
						 		 .addAnnotatedClass(Student.class)
						 		 .buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("Pacman - How To Score One Million Points");
			
			// save the course
			System.out.println("\nSaving the course ... ");
			session.save(tempCourse);
			System.out.println("Saved the course: " + tempCourse);
			
			// create the students
			Student tempSteudent1 = new Student("John", "Doe", "john@luv2code.com");
			Student tempSteudent2 = new Student("Mary", "Public", "mary@luv2code.com");
			
			// add the students to the course
			tempCourse.addStudent(tempSteudent1);
			tempCourse.addStudent(tempSteudent2);
			
			// save the students
			System.out.println("\nSaving students ... ");
			session.save(tempSteudent1);
			session.save(tempSteudent2);
			System.out.println("Saved students: " + tempCourse.getStudents());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			// add clean up code
			session.close();
			
			factory.close();
		}
		
	}

}
