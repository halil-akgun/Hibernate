package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch11 {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student11.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        Student11 student = session.get(Student11.class, 1);
//        student.setName("updated " + student.getName());
//        session.update(student);

//        int old = 30;
//        int new1 = 80;
//
//        String hql = "UPDATE Student11 s SET s.mathGrade=:new WHERE s.mathGrade<:old";
//        Query query = session.createQuery(hql);
//
//        query.setParameter("old", old); // stringdeki ":" sayesinde setParameter kullanilabiliyor
//        query.setParameter("new", new1);
//
//        int numberOfUpdated = query.executeUpdate();
//        System.out.println("updated: " + numberOfUpdated);

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student11> criteriaQuery = cb.createQuery(Student11.class);
        Root<Student11> root = criteriaQuery.from(Student11.class);

//        //!!! 1.Örnek: butun Student11 objelerini ekrana basalim:
//        criteriaQuery.select(root); // SELECT * FROM Student11
//        Query<Student11> query1 = session.createQuery(criteriaQuery);
//        List<Student11> resultList = query1.getResultList();
//        resultList.forEach(System.out::println);

        //!!! 2.Örnek , Student ismi "Student Name 6" olan öğrenci bilgilerini getirelim\
        criteriaQuery.select(root). // SELECT * FROM Student11
                where(cb.equal(root.get("name"), "student name 6"));
        Query<Student11> query2 = session.createQuery(criteriaQuery);
        List<Student11> resultList2 = query2.getResultList();
        resultList2.forEach(System.out::println);


        tx.commit();
        session.close();
        sf.close();
    }
}