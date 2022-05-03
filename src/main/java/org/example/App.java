package org.example;

import org.example.bo.exemple2.Address;
import org.example.bo.exemple2.Student;
import org.example.dao.HibernateGenericDaoImpl;
import org.example.dao.SessionFactoryBuilder;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        HibernateGenericDaoImpl<Student> studentDao = new HibernateGenericDaoImpl<>(Student.class);
        HibernateGenericDaoImpl<Address> addressDao = new HibernateGenericDaoImpl<>(Address.class);


        // creating the students
        Student std1 = new Student();
        std1.setFirstName("walid");
        std1.setLastName("antara");
        std1.setCIN("123");

        Student std2 = new Student();
        std2.setFirstName("bora");
        std2.setLastName("bora");
        std2.setCIN("122223");


        // creating the addresses
        Address adrs1 = new Address();
        adrs1.setCity("casablanca");

        Address adrs2 = new Address();
        adrs2.setCity("fes");


//**************************************************
        // adding the addresses to the student
       // std1.addAdresse(adrs1);
      //  std1.addAdresse(adrs2);
        // saving
       // studentDao.save(std1);

//************************************************

        // adding students to address
//        adrs1.addStudent(std1);
//        adrs1.addStudent(std2);
        //saving
//        addressDao.save(adrs1);

//***************************************
        // adding adrs 1 and 2 to std 1
         std1.addAdresse(adrs1);
          std1.addAdresse(adrs2);
         //saving
         studentDao.save(std1);

         // adding std 2 to address 2
        adrs2.addStudent(std2);
        //saving
        addressDao.save(adrs2);
    }
}
