import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawWith extends JFrame implements ActionListener {
    BankCard bankCard;
    JButton drawwithbutton,retrunbutton;
    public DrawWith (BankCard bankCard)
    {
        this.bankCard=bankCard;
        init();
        this.setVisible(true);
        this.setTitle("取款页面");
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.pink);
    }
    private void init() {
        setLayout(null);
        drawwithbutton=new JButton("1000");
        drawwithbutton.setBounds(600,100,80,30);
        drawwithbutton.addActionListener(this);
        add(drawwithbutton);
        retrunbutton=new JButton("返回");
        retrunbutton.setBounds(20,400,80,30);
        retrunbutton.addActionListener(this);
        add(retrunbutton);
    }
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==drawwithbutton)
        {
            bankCard.setBanlance(bankCard.getBanlance()-1000);
            JOptionPane.showMessageDialog(null,"取款成功！");
        }
        if(a.getSource()==retrunbutton)
        {
            this.dispose();
        }
    }
}
