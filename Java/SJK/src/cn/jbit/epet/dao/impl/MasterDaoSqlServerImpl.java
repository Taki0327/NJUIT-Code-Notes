package cn.jbit.epet.dao.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.jbit.epet.dao.JDBCUtil;
import cn.jbit.epet.dao.masterDao;
import cn.jbit.epet.entity.Master;

public class MasterDaoSqlServerImpl extends JDBCUtil implements masterDao {
    @Override
    public int del(Master master) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean findMaster(Master master) {
        List<HashMap> list=new ArrayList<>();
        String sqlString="select * from master where loginid=? and password=?";
        Object [] params={master.getLoginid(),master.getPassword()};
        list=this.executeQuery(sqlString, params);
        if(list.size()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public int insert(Master master) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updatre(Master master) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
