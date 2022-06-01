package cn.jbit.epet.test;
import javax.swing.*;

import cn.jbit.epet.dao.impl.MasterDaoSqlServerImpl;
import cn.jbit.epet.entity.Master;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pettest extends JFrame implements ActionListener {
    Master master;
    MasterDaoSqlServerImpl masterDaoSqlServerImpl;
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4,i5;
    public Pettest(){
        //master=new Master();
        //masterDaoSqlServerImpl=new MasterDaoSqlServerImpl();
        init();
        setTitle("登陆");
        setSize(800,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public void init()
    {
        setLayout(null);
        mb=new JMenuBar();
        m1= new JMenu("宠物管理");
        m2= new JMenu("宠物查询");
        i1=new JMenuItem("购买宠物");
        i2=new JMenuItem("删除宠物");
        i3=new JMenuItem("更改宠物");
        i4=new JMenuItem("按ID查询");
        i5=new JMenuItem("按昵称查询");
        m1.add(i1);
        m1.add(i2);
        m1.add(i3);
        m2.add(i4);
        m2.add(i5);
        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);
        mb.add(m1);
        mb.add(m2);
        this.setJMenuBar(mb);
    }

  
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
    public static void main(String[] args) {
        new Pettest();
    }
}
