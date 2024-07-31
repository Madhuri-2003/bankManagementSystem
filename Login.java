package BankManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("ATM");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM!!");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Enter Card Number:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120, 150, 400, 40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(400,155,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin = new JLabel("Enter your PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120, 220, 400, 40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(400,225,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login = new JButton("sign in");
        login.setBounds(320, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("reset");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        JLabel p = new JLabel("new user?");
        p.setFont(new Font("Osward",Font.BOLD,14));
        p.setBounds(220, 330, 400, 40);
        add(p);

        signup = new JButton("signup");
        signup.setBounds(320, 340, 210, 30);
        signup.setBackground(Color.GREEN);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(800,400);
        setVisible(true);
        setLocation(350,200);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == login)
        {
            conn c = new conn();  // Assuming 'conn' is your custom class for database connection
            String cardnumber = cardTextField.getText();
            String pinnumber = new String(pinTextField.getPassword()).trim();
            String query = "select count(*) as count from signup3 where CardNumber = ? and PIN = ?";
            try
            {
                //PreparedStatement pstmt = c.s.prepareStatement(query);
                PreparedStatement pstmt = c.c.prepareStatement(query);
                pstmt.setString(1, cardnumber);
                pstmt.setString(2, pinnumber);
                ResultSet rs = pstmt.executeQuery();
                int count = 0;
                // if(rs.next()) 
                // {
                //     count++;  // Increment count for each matching record
                // }
                // System.out.println(rs.next());
                if(rs.next())
                {
                    // setVisible(false);
                    // new transactions(pinnumber).setVisible(true);
                    //int count = rs.getInt("count");
                    // System.out.println("Count: " + count);
                    // if (count > 0) {
                        setVisible(false);
                        new transactions(pinnumber).setVisible(true);
                    // } 
                    // else 
                    // {
                    //     JOptionPane.showMessageDialog(null, "Incorrect card number or PIN");
                    // }
                }
                else
                {
                   JOptionPane.showMessageDialog(null, "Incorrect card number or PIN");
                }
            }
            catch(Exception e)
            {
                   System.out.println(e);
            }
        }

        else if(ae.getSource() == signup)
        {
            setVisible(false);
            new signupOne().setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        new Login();
    }
}