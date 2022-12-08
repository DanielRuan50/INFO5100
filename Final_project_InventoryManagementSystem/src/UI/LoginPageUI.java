package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class LoginPageUI implements ActionListener{

    JFrame frame = new JFrame();            //create object frame and panel of JFrame and JPanel class
    JPanel panel = new JPanel();

    JButton loginButton, resetButton;           //create variables
    JTextField userIDField;
    JPasswordField userPasswordField;
    JLabel userIDLabel, userPasswordLabel, messageLabel;
    HashMap<String,String> logininfo;

    public LoginPageUI(HashMap<String,String> loginInfoOriginal){

        panel.setBounds(0,0,420,320);           //Position of each button and input field
        panel.setLayout(null);

        logininfo = loginInfoOriginal;

        userIDLabel = new JLabel("UserID:");
        userIDLabel.setBounds(50,50,75,25);

        userPasswordLabel = new JLabel("Password:");
        userPasswordLabel.setBounds(50,100,75,25);

        messageLabel = new JLabel();
        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIDField = new JTextField();
        userIDField.setBounds(125,50,225,25);

        userPasswordField = new JPasswordField();
        userPasswordField.setBounds(125,100,225,25);

        loginButton = new JButton("Login");
        loginButton.setBounds(125,150,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton = new JButton("Reset");
        resetButton.setBounds(250,150,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.setTitle("Login Page");                               //Set up the contents of title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //stop running when click close
        frame.setResizable(false);                                  //Avoid user changes to the layout
        frame.setLayout(null);
        frame.setSize(420,320);                         //Set size
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(panel);


        panel.add(userIDLabel);                                      //add things into panel
        panel.add(userPasswordLabel);
        panel.add(messageLabel);
        panel.add(userIDField);
        panel.add(userPasswordField);
        panel.add(loginButton);
        panel.add(resetButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==resetButton) {            //if press resetButton clear all text
            userIDField.setText("");
            userPasswordField.setText("");
        }

        if(e.getSource()==loginButton) {            //if press loginButton

            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if(logininfo.containsKey(userID)) {             //if account and password are correct
                if(logininfo.get(userID).equals(password)) {
                    frame.dispose();
                    MainUI mainUI = new MainUI();           //call MainUI class
                }
                else {
                    try {
                        throw new MyException("Wrong password");            //if wrong password
                    } catch (MyException ex) {
                        JOptionPane.showMessageDialog(null,
                                ex.getMessage(),
                                "FAILED!",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
            else {
                try {
                    throw new MyException("Username not found");            //if wrong account
                } catch (MyException ex) {
                    JOptionPane.showMessageDialog(null,
                            ex.getMessage(),
                            "FAILED!",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
    }
}
