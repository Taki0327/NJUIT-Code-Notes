package cn.jbit.epet.dao;
import cn.jbit.epet.entity.Master;
public interface masterDao {
    public int insert(Master master);
    public int del(Master master);
    public int updatre(Master master);
    public boolean findMaster(Master master);
}
