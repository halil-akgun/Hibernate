package com.hb10.idgeneration;

import javax.persistence.*;

@Entity
public class Student10 {
    /*
        Oracle DB - PostgreSQL  --->  Sequence ( kontrolü developera bırakır, Id üretilirken başlangıç değeri
                                      veya kaç tane id cachelenecek bu gibi bilgileri developer setliyebilir)

        MySQL - Microsoft SQL   --->  IDENTITY ( kontrol DB de , kendi yapısına göre ıd oluşturur,
                                      içlerindeki en basitidir)

        GenerationType.AUTO     --->  Hibernate otomatik olarak kullanilan DB ye gore stratejiyi belirler
        GenerationType.TABLE    --->  En yavaşı , o yüzden çok kullanılmıyor, çünkü id
                                      üretmek için ekstra tablo oluşturuyor
     */
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "sequence", // @GeneratedValue(generator = "sequence" - ayni isim olmali
            sequenceName = "std_seq", // db'de olusacak isim
            initialValue = 1800, // id 1800'den baslasin
            allocationSize = 10 // siradaki ilk 10 id cache'de hazir bekletiliyor
                                // session kapatilip acilirsa 11-20 arasini cache'e alir ve kullanir (ilk 10 bitmese de)
    )
    @Id
    private int id;
    @Column(name = "student_name", nullable = false)
    private String name;
    private int grade;

    // !!! gETTER-sETTER
    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

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

    // !!! ToString()
    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}