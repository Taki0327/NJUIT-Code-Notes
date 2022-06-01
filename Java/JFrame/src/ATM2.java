import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM2 extends JFrame implements ActionListener
{
    BankCard bankCard;
    JButton QueryButton;
    JButton drawwithButton;
    JButton exitButton;
    BankCard b1;
    JLabel infolabel;
    public ATM2 (BankCard bankCard)
    {
        this.bankCard=bankCard;
        init();
        this.setVisible(true);
        this.setTitle("中国银行");
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.pink);
    }
    private void init()
    {
        this.setLayout(null);
        QueryButton=new JButton("查询");
        QueryButton.setBounds(600,100,80,30);
        this.add(QueryButton);
        QueryButton.addActionListener(this);
        drawwithButton=new JButton("取款");
        drawwithButton.setBounds(600,200,80,30);
        drawwithButton.addActionListener(this);
        this.add(drawwithButton);

        exitButton=new JButton("退卡");
        exitButton.setBounds(20,400,80,30);
        exitButton.addActionListener(this);
        this.add(exitButton);

        infolabel=new JLabel("欢迎使用ATM机");
        infolabel.setBounds(150,150,400,60);
        this.add(infolabel);
        Font kai =new Font("苹方 特粗",Font.BOLD,50);
        infolabel.setFont(kai);
    }
    public static void main(String args[])
    {
        BankCard myCard=new BankCard("1","123456",200000 );
        new ATM2(myCard);
    }
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==QueryButton)
        {
            JOptionPane.showMessageDialog(null,bankCard.getBanlance());

        }
        if(a.getSource()==drawwithButton)
        {
            new DrawWith(bankCard);
        }
        if(a.getSource()==exitButton)
        {
            JOptionPane.showMessageDialog(null,"成功退出！");
            this.dispose();
        }
    }
}
