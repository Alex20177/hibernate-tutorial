package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Student;

public class DeleteStudentObject {

	public static void main(String[] args) {
		
		//Create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		int studentId = 8;
		
		try {
			
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\n\n\nGetting student with id "+studentId);
			Student student = session.get(Student.class, studentId);
			System.out.println("Get completed : \n"+student);
			
			System.out.println("Deleting student with id = "+studentId);
			session.delete(student);
			/*
			 * With this option you do not need retrieve the object previously.
			 session.createQuery("delete from Student where id=2").executeUpdate();
			 */
			session.getTransaction().commit();
			
		}//Close try. 
		
		finally {
			factory.close();
		}//Close finally. 
		
	}//Close main method.
	
}//Close ReadStudendObject
