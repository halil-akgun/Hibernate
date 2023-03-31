package com.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch05 {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student05 student1 = session.get(Student05.class, 1001);
        System.out.println(student1);
        System.out.println(student1.getUniversity());

        System.out.println("************************************");
        String hqlQuery = "FROM Student05 WHERE university.id=1";
        List<Student05> list = session.createQuery(hqlQuery).getResultList();
        list.forEach(System.out::println);

        tx.commit();
        session.close();
        sf.close();

    }
}
