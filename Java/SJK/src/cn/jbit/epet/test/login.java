package cn.jbit.epet.test;
import javax.swing.*;

import cn.jbit.epet.dao.impl.MasterDaoSqlServerImpl;
import cn.jbit.epet.entity.Master;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame implements ActionListener {
    Master master;
    MasterDaoSqlServerImpl masterDaoSqlServerImpl;
    JButton submit;
    JLabel name1,name2;
    JTextField id,password;
    public login(){
        master=new Master();
        masterDaoSqlServerImpl=new MasterDaoSqlServerImpl();
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
        name1=new JLabel("账号:");
        name1.setBounds(250,150,80,30);
        this.add(name1);

        name2=new JLabel("密码:");
        name2.setBounds(250,200,80,30);
        this.add(name2);

        id=new JTextField();
        id.setBounds(350,150,120,30);
        this.add(id);

        password=new JTextField();
        password.setBounds(350,200,120,30);
        this.add(password);

        submit=new JButton("确定");
        submit.setBounds(300,300,80,30);
        submit.addActionListener(this);
        this.add(submit);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit)
        {
            if(isNum(id.getText())&&isNum(password.getText()))
            {
                master.setLoginid(id.getText());
                master.setPassword(password.getText());
                if(masterDaoSqlServerImpl.findMaster(master))
                {
                    JOptionPane.showMessageDialog(null,"登陆成功！");
                    new Pettest();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"登陆失败!");
                }
            }
        }
    }
    public boolean isNum(String s)
    {
        for(int i=0;i<s.length();i++)
        {
            if (!Character.isDigit(s.charAt(i)))
                return false;

        }
        return true;
    }
    public static void main(String[] args) {
        new login();
    }
}
