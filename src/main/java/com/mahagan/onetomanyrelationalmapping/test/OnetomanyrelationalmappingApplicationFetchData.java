package com.mahagan.onetomanyrelationalmapping.test;

import com.mahagan.onetomanyrelationalmapping.domain.Answers;
import com.mahagan.onetomanyrelationalmapping.domain.Question;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Iterator;
import java.util.List;

public class OnetomanyrelationalmappingApplicationFetchData {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata= new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory= metadata.getSessionFactoryBuilder().build();
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        TypedQuery typedQuery= session.createQuery("from Question question ");
        List<Question> list=typedQuery.getResultList();
        Iterator<Question> iterator=list.listIterator();

        while (iterator.hasNext()){
            Question question=iterator.next();
            System.out.println(question.getQueName());

            //For printing the answer here

            List<Answers> list1 =question.getAnswers();
            Iterator<Answers> iterator1=list1.iterator();
            while (iterator1.hasNext()) {
                Answers answers = iterator1.next();
                System.out.println(answers.getAnsName() + "  " + answers.getPostedBy() + "  " + answers.getCreatedBy());
            }
            }
            session.close();
        System.out.println(" Data has been successfully fetched in DB ************** ");



    }
}
