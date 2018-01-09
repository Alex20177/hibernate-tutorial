package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Student;

public class UpdateStudentObject {

	public static void main(String[] args) {
		
		//Create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//Create a session
		Session session = factory.getCurrentSession();
		
		int studentId = 1;
		try {
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\n\n\nGetting student with id "+studentId);
			Student student = session.get(Student.class, studentId);
			System.out.println("Get completed : \n"+student);
			
			System.out.println("Updating student object using hibernate");
			student.setLastName("Scooby");
			
			session.getTransaction().commit();
			
			System.out.println("\n\n\nUpdating all the mails");
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='wrongEmail@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done !!");
			
			
		}//Close try. 
		
		finally {
			factory.close();
		}//Close finally. 
		
	}//Close main method.
	
}//Close ReadStudendObject
