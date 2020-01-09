package com.joydeep.hibernate.client;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.joydeep.hibernate.model.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        Criteria cr=session.createCriteria(UserDetails.class).setProjection(Projections.property("userName"));

        
        
        List<UserDetails> users=cr.list();
        
        session.getTransaction().commit();
        session.close();
      System.out.println(users);
      
	}

}
