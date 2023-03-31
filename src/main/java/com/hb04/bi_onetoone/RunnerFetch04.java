package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {

        // configure("hibernate.cfg.xml") : zaten xml ismi default, o yuzden yazilmasa da olur
        // cfg dosyasi farkli bir isimde olusturulursa o zaman belirtmek gerekir
        Configuration conf = new Configuration().configure().addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student04 student = session.get(Student04.class, 1001);


        Diary04 diary = session.get(Diary04.class, 102);
        System.out.println(student);
        System.out.println("************************************************************");
        System.out.println(diary);
        System.out.println("************************************************************");
        System.out.println(diary.getStudent());
        System.out.println("************************************************************");
        System.out.println(student.getDiary());


        // !!! Task : Kesisim kumesini bana getirin ( INNER JOIN )
        System.out.println("************************************************************");
        String hqlQuery = "SELECT s.name, d.name FROM Student04 s INNER JOIN FETCH Diary04 d ON s.id = d.student";
        // d.student.id olmali aslinda ama id eklemesek de hibernate objenin icine bakip id'yi buluyor..
        List<Object[]> resultList = session.createQuery(hqlQuery).getResultList();
//        for (Object[] w : resultList) {
//            System.out.println(Arrays.toString(w));
//        }
        resultList.forEach(t -> System.out.println(Arrays.toString(t)));

        System.out.println("************************************************************");
        String hqlQuery2 = "SELECT s.name, d.name FROM Student04 s LEFT JOIN FETCH Diary04 d ON s.id = d.student";
        // left join: student'larla birlikte studentlara ait diary bilgileri de geliyor
        List<Object[]> resultList2 = session.createQuery(hqlQuery2).getResultList();
        resultList2.forEach(t -> System.out.println(Arrays.toString(t)));

        System.out.println("************************************************************");
        // !!! HQL Right Join
        // Task 3 : Butun gunlukler ve varsa gunlugu olan ogrenciler gelsin
        String hqlQuery3 = "SELECT s.name, d.name FROM Student04 s RIGHT JOIN FETCH Diary04 d ON s.id = d.student";
        List<Object[]> resultList3 = session.createQuery(hqlQuery3).getResultList();
        resultList3.forEach(t -> System.out.println(Arrays.toString(t)));

        System.out.println("************************************************************");
        // !!! HQL Full Join ************************************************************
        // Kisaca : butun student ve diary bilgilerini getirelim
        String hqlQuery4 = "SELECT s.name, d.name FROM Student04 s FULL JOIN FETCH Diary04 d ON s.id = d.student.id";
        List<Object[]> resultList4 = session.createQuery(hqlQuery4).getResultList();


        tx.commit();
        session.close();
        sf.close();
    }
}