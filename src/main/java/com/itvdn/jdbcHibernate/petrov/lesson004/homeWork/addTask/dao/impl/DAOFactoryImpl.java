package com.itvdn.jdbcHibernate.petrov.lesson004.homeWork.addTask.dao.impl;

import com.itvdn.jdbcHibernate.petrov.lesson004.homeWork.addTask.dao.AnimalDAO;
import com.itvdn.jdbcHibernate.petrov.lesson004.homeWork.addTask.dao.DAOFactory;

public class DAOFactoryImpl implements DAOFactory {
    @Override
    public AnimalDAO getAnimalDAO() {
        return new AnimalDAOImpl();
    }
}
