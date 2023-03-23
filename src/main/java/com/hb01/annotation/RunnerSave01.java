package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

    public static void main(String[] args) {

        Student01 student1 = new Student01();
        student1.setId(1001);
        student1.setName("Gul");
        student1.setGrade(100);

        Student01 student2 = new Student01();
        student2.setId(1002);
        student2.setName("halil");
        student2.setGrade(90);

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        // yukardaki satirda, Hibernate 'e konfigurasyon dosyami ve Entity classimi bildirdim

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);

        tx.commit();

        session.close();
        sf.close();

    }
}