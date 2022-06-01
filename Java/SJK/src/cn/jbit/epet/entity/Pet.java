package cn.jbit.epet.entity;

import java.util.Date;

public class Pet {
    private Integer id;
    private String master;
    private String name;
    private String health;
    private String love;
    private Date adoptTime;

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public Date getAdoptTime() {
        return adoptTime;
    }

    public void setAdoptTime(Date adoptTime) {
        this.adoptTime = adoptTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pet(Integer id, String master, String name, String health, String love, Date adoptTime) {
        this.id = id;
        this.master = master;
        this.name = name;
        this.health = health;
        this.love = love;
        this.adoptTime = adoptTime;
    }
}
