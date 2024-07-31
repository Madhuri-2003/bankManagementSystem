package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class balanceEnquiry extends JFrame implements ActionListener
{
    String pinnumber;
    JButton back;
    int balance;
    balanceEnquiry(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        conn c = new conn();
            try{
                //ResultSet rs = c.s.executeQuery("select * from bank where PIN = pinnumber)";
                //PreparedStatement ps = ((conn) c.s).prepareStatement("select * from bank where PIN = ?");
                PreparedStatement ps = c.prepareStatement("SELECT * FROM bank WHERE PIN = ?");
                ps.setString(1, pinnumber);
                ResultSet rs = ps.executeQuery();
                balance = 0;
                while(rs.next())
                {
                    if ("Deposit".equals(rs.getString("type")))
                    {
                        balance += rs.getInt("amount");
                    }
                    else
                    {
                        balance -= rs.getInt("amount");
                    }
                }
            } 
            catch(Exception e)
            {
                System.out.println(e);
            }

        JLabel text = new JLabel("Your current account balance is: " +balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        image.add(text);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public static void main(String[] args)
    {
        new balanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        setVisible(false);
        new transactions(pinnumber).setVisible(true);   
    }
}
