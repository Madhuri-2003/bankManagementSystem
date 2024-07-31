package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
//import java.util.*;
//import java.sql.*;

public class deposit extends JFrame implements ActionListener{

    JLabel text;
    JButton deposit,back;
    JTextField amount;
    String pinnumber;
    deposit(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        image.setBounds(0,0,900,900);

        text = new JLabel("Enter amount you want to deposit:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(170,350,320,22);
        amount.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == deposit)
        {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enetr valid amount");
            }
            else
            {
                try
                {
                    conn c = new conn();
                    String query = "insert into bank(PIN,date,type,amount)values(?,?,?,?)";
                    PreparedStatement pstmt = c.prepareStatement(query);
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    pstmt.setString(1, pinnumber);
                    pstmt.setDate(2, sqlDate);
                    pstmt.setString(3, "Deposit");
                    pstmt.setString(4, number);
                    pstmt.executeUpdate();
                    pstmt.close();

                    JOptionPane.showMessageDialog(null, "Rs: "+number+" Amount deposited Successfully");
                    setVisible(false);
                    new transactions(pinnumber).setVisible(true);

                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource() == back)
        {
            setVisible(true);
            new transactions(pinnumber).setVisible(true);
        }
    }
    
}
