package com.itvdn.jdbcHibernate.petrov.lesson004.homeWork.addTask.configuration.database;

import javax.persistence.*;
import java.util.List;

public class DataBase {
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        }
        return entityManagerFactory;
    }

    public static <T> T add(T object) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        entityManager.close();
        return object;
    }

    public static <T> T get(int id, Class<T> type) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        T object = entityManager.find(type, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return object;
    }

    public static <T> T update(T object) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(object);
        entityManager.getTransaction().commit();
        entityManager.close();
        return object;
    }

    public static <T> void delete(T object) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(object);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static <T> List<T> getAll(Class<T> type) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from " + type.toString());
        List<T> list = query.getResultList();
        entityManager.getTransaction().commit();
        return list;
    }
}
