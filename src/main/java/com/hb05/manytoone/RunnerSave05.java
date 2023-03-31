package com.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {
    public static void main(String[] args) {

        Student05 student1 = new Student05();
        student1.setId(1001);
        student1.setName("GUL");
        student1.setGrade(100);

        Student05 student2 = new Student05();
        student2.setId(1002);
        student2.setName("hll");
        student2.setGrade(100);

        Student05 student3 = new Student05();
        student3.setId(1003);
        student3.setName("Erkan");
        student3.setGrade(100);

        University university = new University();
        university.setId(1);
        university.setName("TPE University");

        student1.setUniversity(university);
        student2.setUniversity(university);
        student3.setUniversity(university);

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(university);
        session.save(student1);
        session.save(student2);
        session.save(student3);

        tx.commit();
        session.close();
        sf.close();
    }
}