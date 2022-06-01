package cn.jbit.epet.dao.impl;

import java.util.Date;

import cn.jbit.epet.dao.JDBCUtil;
import cn.jbit.epet.dao.petDao;
import cn.jbit.epet.entity.Pet;

public class PetDaoSqlServerImpl extends Pet implements petDao {

    public PetDaoSqlServerImpl(Integer id, String master, String name, String health, String love, Date adoptTime) {
        super(id, master, name, health, love, adoptTime);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int del(Pet pet) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public java.util.List<Pet> finByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pet getByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(Pet pet) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updatre(Pet pet) {
        // TODO Auto-generated method stub
        return 0;
    }

}
