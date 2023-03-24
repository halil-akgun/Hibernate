package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        /*
             db'den bilgi almak
                1- get()
                2- SQL
                3- HQL
         */

        //  1. yol get() ******************************
//        Student01 student1 = session.get(Student01.class, 1001);
//        Student01 student2 = session.get(Student01.class, 1002);
//        System.out.println(student1);
//        System.out.println(student2);


        //  2. yol SQL ******************************
//        String sqlQuery = "SELECT * FROM t_student01";
//        List<Object[]> resultList = session.createSQLQuery(sqlQuery).getResultList();
//        for (Object[] obj : resultList) {
//            System.out.println(Arrays.toString(obj));
//        }


        //  3. yol HQL ******************************
        //  hql'de FROM'dan sonra sinif ismi kullanilir
//        String hqlQuery = "FROM Student01";
//        List<Student01> resultList2 = session.createQuery(hqlQuery, Student01.class).getResultList();
//        for (Student01 w : resultList2) {
//            System.out.println(w);
//        }


        /*
                oncelik
            1- get() - hazir method - hata riski cok az
            2- HQL                  - mysql'e gecilirse otomatik kod donusturulur = hqlQuery'ler calismaya devam eder
            3- SQL                  - mysql'e gecilirse sqlQuery'leri teker teker degistirmek gerekebilir
         */


        // SQL
//        String sqlQuery2 = "SELECT * FROM t_student01 WHERE student_name='Gul'";
//        Object[] reslt = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
//        System.out.println(Arrays.toString(reslt));


        // HQL
//        String hqlQuery2 = "FROM Student01 WHERE name='Gul'";
//        Student01 std = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
//        System.out.println(std);


        // !!! YUKARDAKI sorguyu HQL alias kullanarak yapalim
        String hqlQuery3 = "FROM Student01 std WHERE std.name='Gul'";
        Student01 std2 = session.createQuery(hqlQuery3, Student01.class).uniqueResult();
        System.out.println(std2);


        // !!! HQL ile grade degeri 90 olan ogrenciyi getirelim
        String hqlQuery4 = "FROM Student01 std WHERE std.grade=90";
        List<Student01> list = session.createQuery(hqlQuery4, Student01.class).getResultList();
        System.out.println(list);

        // 2. yol
//        String hqlQuery4 = "SELECT s.id, s.name FROM Student01 s WHERE s.grade=90";
//        List<Object[]> resultList4 = session.createQuery(hqlQuery4).getResultList();
//        for (Object[] object: resultList4) {
//            System.out.println(Arrays.toString(object));
//        }


        tx.commit();
        session.close();
        sf.close();

    }
}
