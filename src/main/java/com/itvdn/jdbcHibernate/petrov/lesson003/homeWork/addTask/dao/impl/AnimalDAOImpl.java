package com.itvdn.jdbcHibernate.petrov.lesson003.homeWork.addTask.dao.impl;

import com.itvdn.jdbcHibernate.petrov.lesson003.homeWork.addTask.configuration.database.DataBase;
import com.itvdn.jdbcHibernate.petrov.lesson003.homeWork.addTask.dao.AnimalDAO;
import com.itvdn.jdbcHibernate.petrov.lesson003.homeWork.addTask.entity.Animal;

import java.util.List;

public class AnimalDAOImpl implements AnimalDAO {
    @Override
    public Animal add(Animal object) {
        return DataBase.add(object);
    }

    @Override
    public Animal get(int id) {
        return DataBase.get(id, Animal.class);
    }

    @Override
    public Animal update(Animal object) {
        return DataBase.update(object);
    }

    @Override
    public boolean delete(Animal object) {
        DataBase.delete(object);
        return get(object.getId()) == null;
    }

    @Override
    public List<Animal> getAll() {
        return DataBase.getAll(Animal.class);
    }
}
