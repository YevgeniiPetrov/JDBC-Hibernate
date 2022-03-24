package com.itvdn.jdbcHibernate.petrov.lesson004.homeWork.addTask.dao;

import java.util.List;

public interface GenericDAO<T> {
    T add(T object);
    T get(int id);
    T update(T object);
    boolean delete(T object);
    List<T> getAll();
}
