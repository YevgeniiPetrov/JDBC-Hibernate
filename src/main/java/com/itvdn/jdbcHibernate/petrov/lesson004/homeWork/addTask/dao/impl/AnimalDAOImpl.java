package com.itvdn.jdbcHibernate.petrov.lesson004.homeWork.addTask.dao.impl;

import com.itvdn.jdbcHibernate.petrov.lesson004.homeWork.addTask.configuration.database.DataBase;
import com.itvdn.jdbcHibernate.petrov.lesson004.homeWork.addTask.entity.MyAnimal;
import com.itvdn.jdbcHibernate.petrov.lesson004.homeWork.addTask.dao.AnimalDAO;

import java.util.List;

public class AnimalDAOImpl implements AnimalDAO {
    @Override
    public MyAnimal add(MyAnimal object) {
        return DataBase.add(object);
    }

    @Override
    public MyAnimal get(int id) {
        return DataBase.get(id, MyAnimal.class);
    }

    @Override
    public MyAnimal update(MyAnimal object) {
        return DataBase.update(object);
    }

    @Override
    public boolean delete(MyAnimal object) {
        DataBase.delete(object);
        return get(object.getId()) == null;
    }

    @Override
    public List<MyAnimal> getAll() {
        return DataBase.getAll(MyAnimal.class);
    }
}
