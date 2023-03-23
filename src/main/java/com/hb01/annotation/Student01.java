package com.hb01.annotation;

import javax.persistence.*;

@Entity // @Entity ile bu sinifi db'de bir tabloya karsilik gelmesini sagliyoruz -- default table Name: student01
@Table(name = "t_student01") // db'de tablo isminin t_student01 olarak degismesini sagladim (zorunlu degil)
//Java kodu içinde bu class'a ulaşırken Student01 ile, SQL ile ulaşirken t_student01 ile yazmam lazım
public class Student01 {

    @Id // primary key yapar altindaki degiskeni
//    @Column(name = "std_id")
    private int id;

    @Column(name = "student_name", length = 100, nullable = false, unique = false) // unique default false zaten, yazilmasa da olur
    private String name;

    //    @Transient // db'deki tabloda grade adinda sutun olusmasini engeller
    private int grade;

//    @Lob // LARGE OBJECT : buyuk boyutlu datalar tutulabiliyor
//    private byte[] image;


    // getter - setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    // toString

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
