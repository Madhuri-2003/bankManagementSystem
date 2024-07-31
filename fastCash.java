package BankManagementSystem;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class fastCash extends JFrame implements ActionListener{
    JButton deposit,withdrawl,fastCash,minStatement,pinChange,balEnq,exit; 
    String pinnumber;
    fastCash(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select withdrawl amount");
        text.setBounds(230,330,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 18));
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(355,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(170,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastCash = new JButton("Rs 1000");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        minStatement = new JButton("Rs 2000");
        minStatement.setBounds(355,450,150,30);
        minStatement.addActionListener(this);
        image.add(minStatement);

        pinChange = new JButton("Rs 5000");
        pinChange.setBounds(170,485,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balEnq = new JButton("Rs 10000");
        balEnq.setBounds(355,485,150,30);
        balEnq.addActionListener(this);
        image.add(balEnq);

        exit = new JButton("Back");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == exit)
        {
            setVisible(false);
            new transactions(pinnumber).setVisible(true);
        }
        else
        {
            String amountString = ((JButton)ae.getSource()).getText().substring(3);
            int amount = Integer.parseInt(amountString);
            conn c = new conn();
            try{
                //ResultSet rs = c.s.executeQuery("select * from bank where PIN = pinnumber)";
                //PreparedStatement ps = ((conn) c.s).prepareStatement("select * from bank where PIN = ?");
                PreparedStatement ps = c.prepareStatement("SELECT * FROM bank WHERE PIN = ?");
                ps.setString(1, pinnumber);
                ResultSet rs = ps.executeQuery();
                int balance = 0;
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
                if (balance < amount)
                {
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank(PIN,date,type,amount) values (?,?,?,?)";
                PreparedStatement pstmt = c.prepareStatement(query);
                pstmt.setString(1, pinnumber);
                //pstmt.setDate(2, (java.sql.Date) date);
                pstmt.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
                pstmt.setString(3, "withdrawl");
                pstmt.setString(4, amountString);
                pstmt.executeUpdate();
                pstmt.close();

                JOptionPane.showMessageDialog(null, "Rs:"+amountString+" debited successfully");
                setVisible(false);
                new transactions(pinnumber).setVisible(true);

                rs.close();
                ps.close();
                pstmt.close();
                c.c.close();



            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args)
    {
        new fastCash("");
    }
}

