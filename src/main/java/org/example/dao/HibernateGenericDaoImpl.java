package org.example.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateGenericDaoImpl<T> {
    private SessionFactory sf = null;


    // we add the attribute boClass because we use it for the method get
    private Class<T> boClass;


    // constructor

    public HibernateGenericDaoImpl(Class<T> boClass)
    {
        // we have a unique sessionFactory
        sf = SessionFactoryBuilder.getSessionFactory();

        this.boClass = boClass;
    }

    // we try out the CRUD operation starting with create/ save

    // save or create
    public void save(T obj)
    {
        Session session = null;
        Transaction tx = null;

        try{
            // getting the session
            session = sf.getCurrentSession();

            // starting a transaction
            tx = session.beginTransaction();

            // saving the alien using session object
            session.save(obj);

            tx.commit();
        }catch (HibernateException ex)
        {
            if(tx != null)
            {
                // here we check if tx is null to avoid using rollback methode on null
                tx.rollback();

                // displaying the exception

            }
            throw ex;
        }finally {
            if(session != null && session.isOpen())
            {
                session.close();
            }
        }

    }

    // update methode
    public void update(T obj)
    {
        Session session = null;
        Transaction transaction = null;
        try{
            // we get the session
            session = sf.getCurrentSession();

            // we start a transaction
            transaction = session.beginTransaction();

            session.update(obj);

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

            T obj = (T) session.get(boClass,id);
            // we get the object with the id to delete it from db
            session.delete(obj);

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

    public T findById(Long id)
    {
        Session session = null;
        Transaction transaction = null;
        T obj = null;
        try{
            session = sf.getCurrentSession();
            transaction = session.beginTransaction();
            obj = session.get(boClass,id);
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
        return obj;
    }

    // find all


}
