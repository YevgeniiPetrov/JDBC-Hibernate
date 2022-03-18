package com.itvdn.jdbcHibernate.petrov.lesson003.homeWork.addTask.configuration.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DataBase {
    private static SessionFactory sessionFactory;

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration()
                    .configure()
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    public static <T> T add(T object) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
        return object;
    }

    public static <T> T get(int id, Class<T> type) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        T object = session.get(type, id);
        transaction.commit();
        session.close();
        return object;
    }

    public static <T> T update(T object) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
        return object;
    }

    public static <T> void delete(T object) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        session.close();
    }

    public static <T> List<T> getAll(Class<T> type) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(type);
        Root<T> rootEntry = criteriaQuery.from(type);
        CriteriaQuery<T> all = criteriaQuery.select(rootEntry);
        TypedQuery<T> allQuery = session.createQuery(all);
        List<T> list = allQuery.getResultList();
        transaction.commit();
        session.close();
        return list;
    }
}
