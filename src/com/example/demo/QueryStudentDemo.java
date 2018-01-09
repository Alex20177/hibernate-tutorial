package com.example.demo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.example.entity.Student;


public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory =  new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			List<Student> students = session.createQuery("from Student").getResultList();
			
			printStudents(students);
			
			students = session.createQuery("from Student s where s.lastName='Alejandro'").getResultList();
			
			System.out.println("\n\n\n\n*****print student where lastName is equals to Alejandro*****");
			printStudents(students);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}//Close try
		
		finally {
			
			factory.close();
			
		}//Close finally.
		
		
	}//Close main method.

	private static void printStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}//Close for.
	}//Close printStudents
	
}//QueryStudenDemo
