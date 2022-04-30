package org.example.dao;

import org.example.bo.exemple1.Alien;
import org.example.bo.exemple2.Address;
import org.example.bo.exemple2.Student;
import org.hibernate.SessionFactory;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;

public class SessionFactoryBuilder {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory()
    {
        if(sessionFactory == null)
        {
            // we can use another format of configuration for hibernate using xml
            Map<String, String> settings = new HashMap<>();
            settings.put("connection.driver_class","org.mariadb.jdbc.Driver");
            settings.put("dialect","org.hibernate.dialect.MariaDB103Dialect");
            settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernatetest");
            settings.put("hibernate.connection.username", "root");
            settings.put("hibernate.hbm2ddl.auto", "create");
            settings.put("hibernate.connection.password", "");
            settings.put("hibernate.current_session_context_class", "thread");
            settings.put("hibernate.show_sql", "true");
            settings.put("hibernate.format_sql", "true");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();

            MetadataSources metadataSources = new MetadataSources(serviceRegistry);
            metadataSources.addAnnotatedClass(Student.class);
            metadataSources.addAnnotatedClass(Address.class);
            Metadata metadata = metadataSources.buildMetadata();

            sessionFactory = metadata.getSessionFactoryBuilder().build();
        }
        return sessionFactory;
    }
}
