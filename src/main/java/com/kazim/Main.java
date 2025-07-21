package com.kazim;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Product p = new Product();
        p.setName("Wired Key board");
        p.setDescription("logiTech without RGB");
        p.setPrice(699.00);
        p.setCategoryId(3);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Product.class);
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(p);

        transaction.commit();
        System.out.println(p);
    }
}