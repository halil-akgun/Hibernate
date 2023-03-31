package com.hb09.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // !!! get ile student getirelim
        Student09 student1 = session.get(Student09.class, 1001);
//        System.out.println(student1);
//        System.out.println(student1.getBookList());

//        Book09 book1 = session.get(Book09.class, 101);

//        for (Book09 book : student1.getBookList()) {
//            System.out.println(book);
//        }


        tx.commit();
        session.close();

        for (Book09 book : student1.getBookList()) {
            System.out.println(book);
        } // eager kullanilmasaydi exception atardi
        // eager olunca ilk sorguda tum datalar geldigi icin  (session kapndiktan sonra) for icinde book bilgileri
        // icin tekrar db'ye gitmesi gerekmiyor, hepsi ilk sorguda geldi


        sf.close();
    }
}
