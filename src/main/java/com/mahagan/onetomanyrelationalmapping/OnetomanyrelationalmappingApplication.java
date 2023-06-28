package com.mahagan.onetomanyrelationalmapping;


import com.mahagan.onetomanyrelationalmapping.domain.Answers;
import com.mahagan.onetomanyrelationalmapping.domain.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class OnetomanyrelationalmappingApplication {

	public static void main(String[] args) {

		StandardServiceRegistry standardServiceRegistry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata= new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory= metadata.getSessionFactoryBuilder().build();
		Session session= sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();

		Answers answers=new Answers();
		answers.setAnsName("WE are learning hibernate with JPA");
		answers.setCreatedBy("Mahagan");
		answers.setPostedBy("Mahagan-Soft");

		Answers answers1=new Answers();
		answers1.setAnsName("WE are learning Springboot with JPA");
		answers1.setCreatedBy("Mahagan");
		answers1.setPostedBy("Deepali Sakhare");

		Answers answers2=new Answers();
		answers2.setAnsName("WE are learning REST-API with JPA");
		answers2.setCreatedBy("Mahagan");
		answers2.setPostedBy("Krishna Shinde");

		Answers answers3=new Answers();
		answers3.setAnsName("WE are learning Spring-MVC with JPA");
		answers3.setCreatedBy("Mahagan");
		answers3.setPostedBy("Vijaykumar");


		List<Answers>answersList=new ArrayList<>();

		answersList.add(answers);
		answersList.add(answers1);
		answersList.add(answers2);
		answersList.add(answers3);

		Question question=new Question();
		question.setQueName("What Is Java?");
		question.setAnswers(answersList);

		session.persist(question);

		transaction.commit();
		session.close();

		System.out.println(" Data has been successfully inserted in DB ************** ");

	}



	}
