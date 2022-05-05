package org.example;

import org.example.bo.exemple2.Address;
import org.example.bo.exemple2.Student;
import org.example.bo.exemple3.Etudiant;
import org.example.bo.exemple3.Prof;
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

        //************ strategie pir le Mappings de l heritage ************

        HibernateGenericDaoImpl<Etudiant> EtudiantDao = new HibernateGenericDaoImpl<>(Etudiant.class);
        HibernateGenericDaoImpl<Prof> ProfDao = new HibernateGenericDaoImpl<>(Prof.class);

        // create etudiant
        Etudiant etd1 = new Etudiant();
        etd1.setFirstName("walid");
        etd1.setLastName("antara");
        etd1.setCIN("123");
        etd1.setCne("lol");

        // create prof
        Prof prof1 = new Prof();
        prof1.setFirstName("bora");
        prof1.setLastName("bora");
        prof1.setCIN("12345");
        prof1.setNUmProf("test");

        ProfDao.save(prof1);
        EtudiantDao.save(etd1);


    }
}
