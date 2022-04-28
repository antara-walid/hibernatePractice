package org.example.dao;

import org.example.bo.Alien;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.AbstractList;
import java.util.List;

public class HibernateAlienDaoImpl {
    private SessionFactory sf = null;

    // constructor

    public HibernateAlienDaoImpl()
    {
        // we have a unique sessionFactory
        sf = SessionFactoryBuilder.getSessionFactory();
    }

    // we try out the CRUD operation starting with create/ save

    // save or create
    public void save(Alien alien)
    {
        Session session = null;
        Transaction tx = null;

        try{
            // getting the session
            session = sf.getCurrentSession();

            // starting a transaction
            tx = session.beginTransaction();

            // saving the alien using session object
            session.save(alien);

            tx.commit();
        }catch (HibernateException ex)
        {
            if(tx != null)
            {
                // here we check if tx is null to avoid using rollback methode on null
                tx.rollback();

                // displaying the exception
                throw ex;
            }
        }finally {
            if(session != null && session.isOpen())
            {
                session.close();
            }
        }

    }

    // update methode
    public void update(Alien alien)
    {
        Session session = null;
        Transaction transaction = null;
        try{
            // we get the session
            session = sf.getCurrentSession();

            // we start a transaction
            transaction = session.beginTransaction();

            session.update(alien);

            // validating the transaction
            transaction.commit();

        }catch (HibernateException ex){
            if(transaction != null)
            {
                transaction.rollback();
            }
            throw ex;
        }finally{
            if(session != null && session.isOpen())
            {
                session.close();
            }
        }
    }

    // delete methode
    public void delete(Long id)
    {
        Session session = null;
        Transaction transaction = null;

        try{
            session = sf.getCurrentSession();;
            transaction = session.beginTransaction();

            Alien al = (Alien) session.get(Alien.class,id);
            session.delete(al);

            transaction.commit();
        }catch (HibernateException ex)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            throw ex;
        }finally{
            if(session != null && session.isOpen())
            {
                session.close();
            }
        }
    }

    // read methodes

    public Alien findById(Long id)
    {
        Session session = null;
        Transaction transaction = null;
        Alien alien = null;
        try{
            session = sf.getCurrentSession();
            transaction = session.beginTransaction();
            alien = session.get(Alien.class,id);
            transaction.commit();
        }catch (HibernateException ex){
            if(transaction != null)
            {
                transaction.rollback();
            }
            throw ex;
        }finally {
            if(session != null && session.isOpen())
            {
                session.close();
            }
        }
        return alien;
    }

    // find all

    public List<Alien> findAll(){
        Session session = null;
        Transaction transaction = null;
        List<Alien> list = null;

        return null;
    }

}
