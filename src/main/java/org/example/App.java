package org.example;

import org.example.bo.Alien;
import org.example.bo.AlienName;
import org.example.dao.HibernateAlienDaoImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HibernateAlienDaoImpl dao = new HibernateAlienDaoImpl();

        Alien al  = new Alien();
        AlienName alName = new AlienName();
        alName.setFirstName("zakaria");
        alName.setLastName("bora");

        al.setaName(alName);
       // al.setaName("");
       al.setColor("blue");

        // saving the alien in the database
       dao.save(al);
        //dao.update(al);
        //dao.delete(2L);
        //al = dao.findById(1L);
        //System.out.println(al);
    }
}
