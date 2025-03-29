package org.example.Cliente;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Cliente cliente = session.get(Cliente.class, "123.456.789-00");
        System.out.println("Cliente: " + cliente.getNome());

        session.close();
        factory.close();
    }
}