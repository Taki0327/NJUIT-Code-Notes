package cn.jbit.epet.dao;

import java.util.List;

import cn.jbit.epet.entity.Pet;
public interface petDao {
    public int insert(Pet pet);
    public int del(Pet pet);
    public int updatre(Pet pet);
    /***
     * 按照宠物昵称来查询宠物
     * @param name
     * @return 返回一个宠物
     */
    public Pet getByName(String name);
    /**
     * 
     * @param name
     * @return 返回一个宠物列表
     */
    public List<Pet> finByName(String name);
}
