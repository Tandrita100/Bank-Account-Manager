package com.projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

public class PasswordGeneratorGUI extends JFrame{

    private JTextField lengthField;
    private JCheckBox uppercaseCheckbox;
    private JCheckBox lowercaseCheckbox;
    private JCheckBox numbersCheckbox;
    private JCheckBox specialCharsCheckbox;
    private JLabel passwordLabel;

    public PasswordGeneratorGUI(){

        super("PASSWORD GENERATOR");      //title bar name

        //GUI components
        lengthField = new JTextField(5);
        uppercaseCheckbox = new JCheckBox("Uppercase");
        lowercaseCheckbox = new JCheckBox("Lowercase");
        numbersCheckbox = new JCheckBox("Numbers");
        specialCharsCheckbox = new JCheckBox("Special Characters");
        JButton generateButton = new JButton("Generate Password");
        passwordLabel = new JLabel("Generate Password");

        //adding panels
        JPanel inputPanel = new JPanel(new GridLayout(5,1));   //panel window
        inputPanel.add(new JLabel("Password Length:"));
        inputPanel.add(lengthField);
        inputPanel.add(uppercaseCheckbox);
        inputPanel.add(lowercaseCheckbox);
        inputPanel.add(numbersCheckbox);
        inputPanel.add(specialCharsCheckbox);

        //setting the layout of the frame
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(generateButton, BorderLayout.CENTER);
        add(passwordLabel, BorderLayout.SOUTH);

        //generate button
        generateButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e){
                 generatePassword();
             }
        });

        setPreferredSize(new Dimension(450, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    //method to generate password
    public void generatePassword(){

        int length = Integer.parseInt(lengthField.getText());
        boolean includeUppercase = uppercaseCheckbox.isSelected();
        boolean includeLowercase = lowercaseCheckbox.isSelected();
        boolean includeNumbers = numbersCheckbox.isSelected();
        boolean includeSpecialChars = specialCharsCheckbox.isSelected();

        String Password = generateRandomPassword(length, includeUppercase, includeLowercase,includeNumbers, includeSpecialChars);
        passwordLabel.setText("Generated Password:  " + Password);

    }

    //method to generate random password
    public String generateRandomPassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialchars){

        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();

        String UppercaseChars = "ABCDEFGHIJKLMNOPQRSTWXYZ";
        String LowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String NumbersChars = "1234567890";
        String specialChars = "~!@#$%^&*()_+-={}|[]:;,./<>?";

        String allChars = "";
        if(includeUppercase) allChars += UppercaseChars;
        if(includeLowercase) allChars += LowercaseChars;
        if(includeNumbers) allChars += NumbersChars;
        if(includeSpecialchars) allChars += specialChars;

        for(int i=0; i<length; i++){
            int randomIndex = random.nextInt(allChars.length());     //the contents of all chars will be stored in randomIndex
            password.append(allChars.charAt(randomIndex));           //the contents of random index will be added in password
        }

        return password.toString();

    }

    //main method
    public static void main(String [] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PasswordGeneratorGUI();
            }
        });
    }

}
