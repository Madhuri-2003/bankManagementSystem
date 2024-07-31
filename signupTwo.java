package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class signupTwo extends JFrame implements ActionListener{
    JLabel additionalDetails,religion,category,income,qualification,occupation,pan,aadhar,seniorCitizen,existingAccount;
    JButton next;
    JTextField panTextField,aadharTextField;
    JRadioButton syes,sno,eyes,eno;
    JComboBox<String> religionList,categoryList,incomeList,qualificationList,occupationList;
    String formno;
    signupTwo(String formno)
    {
        this.formno = formno;
        setLayout(null);
        setTitle("create account-page2");

        additionalDetails = new JLabel("Page2:Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(240,80,400,30);
        add(additionalDetails);

        religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100,140,400,30);
        add(religion);

        String valReligion[] = {"Hindu","Muslim","Christian","Sikh","Jain","Other"};
        religionList = new JComboBox<>(valReligion);
        religionList.setBounds(300, 140, 400, 30);
        religionList.setBackground(Color.WHITE);
        add(religionList);

        category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100,190,400,30);
        add(category);

        String valCategory[] = {"OC","BC","SC","ST","Other"};
        categoryList = new JComboBox<>(valCategory);
        categoryList.setBounds(300, 190, 400, 30);
        categoryList.setBackground(Color.WHITE);
        add(categoryList);

        income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100,240,400,30);
        add(income);

        String valIncome[] = {"<=2Lakhs","2-8Lakhs","Above 8Lakhs"};
        incomeList = new JComboBox<>(valIncome);
        incomeList.setBounds(300, 240, 400, 30);
        incomeList.setBackground(Color.WHITE);
        add(incomeList);


        qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100,290,400,30);
        add(qualification);

        String valQualification[] = {"10th","12th","Graduate","Postgraduate"};
        qualificationList = new JComboBox<>(valQualification);
        qualificationList.setBounds(300, 290, 400, 30);
        qualificationList.setBackground(Color.WHITE);
        add(qualificationList);

        occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100,340,400,30);
        add(occupation);

        String valOccupation[] = {"Salaried","Self-Employed","Business","Student","Other"};
        occupationList = new JComboBox<>(valOccupation);
        occupationList.setBounds(300, 340, 400, 30);
        occupationList.setBackground(Color.WHITE);
        add(occupationList);


        pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100,390,400,30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,20));
        panTextField.setBounds(300,390,400,30);
        add(panTextField);


        aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100,440,400,30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,20));
        aadharTextField.setBounds(300, 440, 400, 30);
        add(aadharTextField);

        seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100,490,400,30);
        add(seniorCitizen);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 490, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 490, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);

        existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100,540,400,30);
        add(existingAccount);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 550, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 550, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(eyes);
        existingGroup.add(eno);

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
        String sreligion = (String)religionList.getSelectedItem();
        String scategory = (String)categoryList.getSelectedItem();
        String sincome = (String)incomeList.getSelectedItem();
        String squalification = (String)qualificationList.getSelectedItem();
        String soccupation = (String)occupationList.getSelectedItem();
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();
        String ssenior = null;
        if(syes.isSelected())
        ssenior = "Yes";
        else if(sno.isSelected())
        ssenior = "No";
        String stexisting = null;
        if(eyes.isSelected())
        stexisting = "Yes";
        else if(eno.isSelected())
        stexisting = "No";
        try{
                conn c = new conn();
                String query2 = "INSERT INTO signup2(formno, religion, category, income, qualification, occupation, pan, aadhar, is_senior, existing) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = c.prepareStatement(query2);
                pstmt.setString(1, formno);
                pstmt.setString(2, sreligion);
                pstmt.setString(3, scategory);
                pstmt.setString(4, sincome);
                pstmt.setString(5, squalification);
                pstmt.setString(6, soccupation);
                pstmt.setString(7, span);
                pstmt.setString(8, saadhar);
                pstmt.setString(9, ssenior);
                pstmt.setString(10, stexisting);
                pstmt.executeUpdate();
                pstmt.close();

                JOptionPane.showMessageDialog(null, "Data Saved");
                setVisible(false);
                new signupThree(formno).setVisible(true);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String[] args)
    {
        new signupTwo("");
    }
    
}
