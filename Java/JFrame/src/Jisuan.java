import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Jisuan extends JFrame implements ActionListener {

    JButton jb1,jb2,jb3,jb4;
    JTextField jf1,jf2,jf3;
    public Jisuan()
    {
        init();
        setTitle("计算");
        setSize(800,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public void init()
    {
        setLayout(null);
        jb1=new JButton("+");
        jb1.setBounds(200,250,80,30);
        jb1.addActionListener(this);
        this.add(jb1);

        jb2=new JButton("-");
        jb2.setBounds(300,250,80,30);
        jb2.addActionListener(this);
        this.add(jb2);

        jb3=new JButton("*");
        jb3.setBounds(400,250,80,30);
        jb3.addActionListener(this);
        this.add(jb3);

        jb4=new JButton("/");
        jb4.setBounds(500,250,80,30);
        jb4.addActionListener(this);
        this.add(jb4);

        jf1=new JTextField();
        jf1.setBounds(240,150,80,40);
        this.add(jf1);

        jf2=new JTextField();
        jf2.setBounds(340,150,80,40);
        this.add(jf2);

        jf3=new JTextField();
        jf3.setBounds(440,150,80,40);
        this.add(jf3);
    }
    public void actionPerformed(ActionEvent e) {
           if(e.getSource()==jb1)
           {
               if(isNum(jf1.getText())&&isNum(jf2.getText()))
               {
                   int num1=Integer.parseInt(jf1.getText());
                   int num2=Integer.parseInt(jf2.getText());
                   int result=num1+num2;
                   jf3.setText(String.valueOf(result));
               }
               else
                   jf3.setText("出错!");

           }
           else if(e.getSource()==jb2)
           {
               if(isNum(jf1.getText())&&isNum(jf2.getText()))
               {
                   int num1=Integer.parseInt(jf1.getText());
                   int num2=Integer.parseInt(jf2.getText());
                   int result=num1-num2;
                   jf3.setText(String.valueOf(result));
               }
               else
                   jf3.setText("出错!");
           }
           else if(e.getSource()==jb3)
           {
               if(isNum(jf1.getText())&&isNum(jf2.getText()))
               {
                   int num1=Integer.parseInt(jf1.getText());
                   int num2=Integer.parseInt(jf2.getText());
                   int result=num1*num2;
                   jf3.setText(String.valueOf(result));
               }
               else
                   jf3.setText("出错!");
           }
           else if(e.getSource()==jb4)
           {
               try
               {
                   if(isNum(jf1.getText())&&isNum(jf2.getText()))
                   {
                       int num1=Integer.parseInt(jf1.getText());
                       int num2=Integer.parseInt(jf2.getText());
                       int result=num1/num2;
                       jf3.setText(String.valueOf(result));
                   }
                   else
                       jf3.setText("出错!");
               }
               catch (ArithmeticException a)
               {
                   a.printStackTrace();
                   JOptionPane.showMessageDialog(null,"除数不能为0!");
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
        new Jisuan();
    }
}
