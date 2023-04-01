package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave11 {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student11.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Random random = new Random();

        for (int i = 1; i <= 20; i++) {
            Student11 student = new Student11();
            student.setName("student name " + i);
            student.setMathGrade(random.nextInt(101)); // 101 dahil degil
            session.save(student);
        }

        tx.commit();
        session.close();
        sf.close();
    }
}
