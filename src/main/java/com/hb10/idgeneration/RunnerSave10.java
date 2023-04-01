package com.hb10.idgeneration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {
    public static void main(String[] args) {

        Student10 student = new Student10();
        student.setName("GUL");
        student.setGrade(100);

        Student10 student2 = new Student10();
        student2.setName("hll");
        student2.setGrade(100);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student10.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        session.save(student);
        session.save(student2);
        // ilk 10 id cache'de hazir
        // oturum kapanip acilirsa daha once cache'e alinmis id'ler cop olur
        // (cache 1010'da kaldiysa 1011den devam eder)


        tx.commit();

        session.close();
        sf.close();
    }
}
