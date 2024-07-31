package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.util.*;

public class signupThree extends JFrame implements ActionListener{
    JLabel l1,type,card,number,pin,pnumber,cardDetail,pinDetail,servicesRequired;
    JRadioButton r1,r2,r3,r4;
    ButtonGroup groupAccount;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    Random rand;
    String formno;

    signupThree(String formno)
    {
        this.formno = formno;
        setLayout(null);

        l1 = new JLabel("Page 3:Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100, 180, 165, 20);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350, 180, 200, 20);
        r2.setBackground(Color.WHITE);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100, 220, 165, 20);
        r3.setBackground(Color.WHITE);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350, 220, 250, 20);
        r4.setBackground(Color.WHITE);
        add(r4);

        card = new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);

        number = new JLabel("xxxx-xxxx-xxxx-5678");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);

        cardDetail = new JLabel("Your 16 digit card number");
        cardDetail.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetail.setBounds(100,330,300,20);
        add(cardDetail);

        pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);

        pnumber = new JLabel("xxxx");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,370,300,30);
        add(pnumber);

        pinDetail = new JLabel("Your 4 digit pin number");
        pinDetail.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetail.setBounds(100,400,300,20);
        add(pinDetail);

        servicesRequired = new JLabel("Services Required");
        servicesRequired.setFont(new Font("Raleway",Font.BOLD,22));
        servicesRequired.setBounds(100,450,200,30);
        add(servicesRequired);

        groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);

        c1 = new JCheckBox("ATM card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100, 680, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250, 720, 100, 30);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420, 720, 100, 30);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == submit)
        {
            String stype = null;
            if(r1.isSelected())
            {
                stype = "Savings Account";
            }
            else if(r2.isSelected())
            {
                stype = "Fixed Deposit Account";
            }
            else if(r3.isSelected())
            {
                stype = "Current Account";
            }
            else if(r4.isSelected())
            {
                stype = "Recurring Deposit Account";
            }
            rand = new Random();
            String cardnumber = " " + Math.abs((rand.nextLong() % 90000000L) + 5040936000000000L);
            String pinnumber = " " + Math.abs((rand.nextLong() % 9000L) + 1000L);

            String facility = "";
            if(c1.isSelected())
            facility = facility + "ATM card";
            else if(c2.isSelected())
            facility = facility + "Internet Banking";
            else if(c3.isSelected())
            facility = facility + "Mobile Banking";
            else if(c4.isSelected())
            facility = facility + "Email & SMS Alerts";
            else if(c5.isSelected())
            facility = facility + "Cheque book";
            else if(c6.isSelected())
            facility = facility + "E-Statement";

            try{
                if(stype.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Account type is required");
                }
                else
                {
                    conn c = new conn();
                    String query3 = "insert into signup3(formno,Type,CardNumber,PIN,Facility) values (?,?,?,?,?)";
                    PreparedStatement pstmt = c.prepareStatement(query3);
                    pstmt.setString(1, formno);
                    pstmt.setString(2, stype);
                    pstmt.setString(3, cardnumber);
                    pstmt.setString(4, pinnumber);
                    pstmt.setString(5, facility);
                    pstmt.executeUpdate();
                    pstmt.close();

                JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber+"PIN:"+pinnumber);
                    // String query4 = "insert into login(formno,CardNumber,PIN) values (?,?,?)";
                    // PreparedStatement pst = c.prepareStatement(query4);
                    // pst.setString(1,formno);
                    // pst.setString(2, cardnumber);
                    // pst.setString(3, pinnumber);

                    setVisible(false);
                    new deposit(pinnumber).setVisible(true);
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new signupThree("");
    }
}
