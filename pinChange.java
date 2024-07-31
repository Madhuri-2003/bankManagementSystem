package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;

public class pinChange extends JFrame implements ActionListener{

    JLabel text,pintext,repintext;
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    pinChange(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);

        pintext = new JLabel("New PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("System",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);

        repintext = new JLabel("Re-Enter new PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("System",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == change)
        {
            try
            {
                String npin = pin.getText();
                String rpin = repin.getText();

                if(npin.equals("") || rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Enter required details");
                    return;
                }
                else if(!npin.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }

                conn c = new conn();
                String query1 = "update bank set pin = ? where PIN = ?";
                PreparedStatement pstmt = c.prepareStatement(query1);
                pstmt.setString(1, npin);
                pstmt.setString(2, pinnumber);
                pstmt.executeUpdate();
                pstmt.close();

                String query2 = "update signup3 set pin = ? where PIN = ?";
                PreparedStatement pstmtt = c.prepareStatement(query2);
                pstmtt.setString(1, npin);
                pstmtt.setString(2, pinnumber);
                pstmtt.executeUpdate();
                pstmtt.close();

                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new transactions(rpin).setVisible(true);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
        {
            setVisible(false);
            new transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        new pinChange("").setVisible(true);
    }
}