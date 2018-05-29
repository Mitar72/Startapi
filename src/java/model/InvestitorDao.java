/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controler.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class InvestitorDao {

    public static List<Integer> prtraziPoKorisnickomImenu(String korisnickoIme) {
        Transaction tx = null;
        Session session = HibernateUtil.createSessionFactory().openSession();
        List<Integer> investitori = new ArrayList();
        try {
            tx = session.beginTransaction();
            //Criteria c =  session.createCriteria(Investitor.class).add(Restrictions.eq("korisnickoIme", korisnickoIme));     

            String hql = "select o.id from Korisnik o where o.korisnickoIme = :korisnickoIme";

            Query query = session.createQuery(hql);
            query.setParameter("korisnickoIme", korisnickoIme);
            List<Integer> results = query.list();
            if (results != null) {
                investitori = results;
            }

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException ignored) {
                    System.out.println("Couldn't close Session " + ignored);
                }
            }
        }
        if (investitori != null) {
            return investitori;
        } else {
            return null;
        }

    }

    public static Investitor dohvatiInvestitoraPoIdu(int id) {
        Transaction tx = null;
        Session session = HibernateUtil.createSessionFactory().openSession();
        Investitor investitor = new Investitor();
        try {
            tx = session.beginTransaction();
            Criteria c = session.createCriteria(Investitor.class).add(Restrictions.eq("id", id));
            investitor = (Investitor) c.uniqueResult();
            System.out.println("startappppp id " + investitor.getId());
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException ignored) {
                    System.out.println("Couldn't close Session " + ignored);
                }
            }
        }
        return investitor;

    }

}
