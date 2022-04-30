package org.example;

import org.example.bo.exemple2.Address;
import org.example.bo.exemple2.Student;
import org.example.dao.HibernateGenericDaoImpl;
import org.example.dao.SessionFactoryBuilder;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        HibernateGenericDaoImpl<Student> studentDao = new HibernateGenericDaoImpl<>(Student.class);
        HibernateGenericDaoImpl<Address> addressDao = new HibernateGenericDaoImpl<>(Address.class);

        Student std1 = new Student();
        std1.setFirstName("walid");
        std1.setLastName("antara");
        std1.setCIN("123");

        Student std2 = new Student();
        std2.setFirstName("bora");
        std2.setLastName("bora");
        std2.setCIN("12w3");

        Address adrs1 = new Address();
        adrs1.setCity("casablanca");

        Address adrs2 = new Address();
        adrs2.setCity("fes");

        std1.setsAdress(adrs1);
        std2.setsAdress(adrs2);

        //System.out.println(std2);
        studentDao.save(std2);

    }
}
