package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.*;

public class signupOne extends JFrame implements ActionListener{
    Long random;
    JLabel formno,personalDetails,name,fname,dob,gender,email,marital,address,city,state,pinCode;
    JButton next;
    JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JRadioButton male,female,otherr,married,single,other;
    signupOne()
    {
        setLayout(null);

        Random ran = new Random();
        random = Math.abs(ran.nextLong()%9000L) + 1000L;

        formno = new JLabel("Application number: "+random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        add(formno);

        personalDetails = new JLabel("Page1:Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(240,80,400,30);
        add(personalDetails);

        name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,400,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        fname = new JLabel("Father's name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,400,30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        dob = new JLabel("DOB:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,400,30);
        add(dob);

        dobTextField = new JTextField("dd/mm/yyyy");
        dobTextField.setFont(new Font("Raleway",Font.PLAIN,20));
        dobTextField.setBounds(300, 240, 400, 30);
        add(dobTextField);


        gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,400,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 80, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 290, 80, 30);
        female.setBackground(Color.WHITE);
        add(female);

        otherr = new JRadioButton("Other");
        otherr.setBounds(500, 290, 80, 30);
        otherr.setBackground(Color.WHITE);
        add(otherr);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(otherr);

        email = new JLabel("EMail Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,340,400,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,20));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);


        marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,400,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 80, 30);
        married.setBackground(Color.WHITE);
        add(married);

        single = new JRadioButton("Single");
        single.setBounds(400, 390, 80, 30);
        single.setBackground(Color.WHITE);
        add(single);

        other = new JRadioButton("Other");
        other.setBounds(500, 390, 80, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(married);
        statusGroup.add(single);
        statusGroup.add(other);

        address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,400,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,20));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,400,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,20));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,400,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,20));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        pinCode = new JLabel("Pin:");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        pinCode.setBounds(100,590,400,30);
        add(pinCode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,20));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String formno = ""+random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = dobTextField.getText();
        String gender = null;
        if(male.isSelected())
        gender = "Male";
        else if(female.isSelected())
        gender = "Female";
        else if(otherr.isSelected())
        gender = "Other";
        String email = emailTextField.getText();
        String marital = null;
        if(single.isSelected())
        marital = "Single";
        else if(married.isSelected())
        marital = "Married";
        else if(other.isSelected())
        marital = "Other";
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pinCode = pinTextField.getText();
        
        try{
            if(name.equals("") || fname.equals("")||dob.equals("")||email.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Required Field");
            }
            else
            {
                conn c = new conn();
                String query = "INSERT INTO signup(formno, name, father_name, dob, gender, email, marital_status, address, city, pincode, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = c.prepareStatement(query);
                pstmt.setString(1, formno);
                pstmt.setString(2, name);
                pstmt.setString(3, fname);
                pstmt.setString(4, dob);
                pstmt.setString(5, gender);
                pstmt.setString(6, email);
                pstmt.setString(7, marital);
                pstmt.setString(8, address);
                pstmt.setString(9, city);
                pstmt.setString(10, pinCode);
                pstmt.setString(11, state);
                pstmt.executeUpdate();
                pstmt.close();

                JOptionPane.showMessageDialog(null, "Signup Successful");
                setVisible(false);
                new signupTwo(formno).setVisible(true);
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String[] args)
    {
        new signupOne();
    }
    
}
