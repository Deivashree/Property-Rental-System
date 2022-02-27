package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;

import Model.User;

import javax.swing.*;

/*  
  Entire class written by: 
  - Lee Wei Chuen

  Purpose of the class: 
  - To display the first page that contain log in and register 
*/

public class FirstPageView implements FocusListener {

    private JPanel firstPagePanel;
    private JComboBox roleBox;
    private JLabel title = new JLabel("Cyberjaya Rental Online Service"); // "Awesome Rental Service" title
    private JLabel subTitle = new JLabel("Welcome!");
    private JTextField nicknameField; // "Login" title
    private JTextField usernameField = new JTextField("Username"); // username field
    private JPasswordField passwordField = new JPasswordField("Password"); // password field
    private JButton registerButton = new JButton("Register"); // register button
    private JButton loginButton = new JButton("Login"); // login button

    private User info;

    // to get the login button
    public JButton getLoginButton() {
        return loginButton;
    }

    // to get the register button
    public JButton getRegisterButton() {
        return registerButton;
    }

    // to set the text in nickname field
    public void setNicknameField() {
        this.nicknameField.setText("Nickname");
    }

    // to set the text in username field
    public void setUsernameField() {
        this.usernameField.setText("Username");
    }

    // to set the text in password field
    public void setPasswordField() {
        this.passwordField.setText("Password");
    }

    FirstPageView() {

        firstPagePanel = new JPanel();
        firstPagePanel.setBackground(new Color(0x2a6b96));
        firstPagePanel.setPreferredSize(new Dimension(1000, 700));
        firstPagePanel.setLayout(null);

        // the position and customization for title
        title.setBounds(320, 55, 550, 30);
        title.setForeground(new Color(0xffffff));
        title.setFont(new Font("MV Boli", Font.PLAIN, 25));

        // the position and customization for "Log In"
        subTitle.setBounds(450, 200, 300, 23);
        subTitle.setForeground(new Color(0xffffff));
        subTitle.setFont(new Font("Arial", Font.BOLD, 20));

        String[] actors = { "Tenant", "Owner", "Agent", "Admin" };
        roleBox = new JComboBox<>(actors);
        roleBox.setBounds(425, 250, 150, 30);

        nicknameField = new JTextField("Nickname");
        nicknameField.setBounds(400, 290, 200, 25);
        nicknameField.setHorizontalAlignment(JLabel.CENTER);
        nicknameField.setText("Nickname");
        nicknameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event) {
                if (nicknameField.getText().equals("Nickname")) {
                    nicknameField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event) {
                if (nicknameField.getText().equals("")) {
                    nicknameField.setText("Nickname");
                }
            }
        });

        // The position for username field
        usernameField.setBounds(400, 320, 200, 25);
        usernameField.setHorizontalAlignment(JLabel.CENTER);
        usernameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event) {
                if (usernameField.getText().equals("Username")) {
                    usernameField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event) {
                if (usernameField.getText().equals("")) {
                    usernameField.setText("Username");
                }
            }
        });

        // The position for username field
        passwordField = new JPasswordField("Password");
        passwordField.setBounds(400, 350, 200, 25);
        passwordField.setHorizontalAlignment(JLabel.CENTER);
        passwordField.setEchoChar((char) 0);
        passwordField.addFocusListener(this);

        registerButton = new JButton("Register");
        registerButton.setBounds(515, 390, 90, 25);
        registerButton.setHorizontalAlignment(JLabel.CENTER);
        registerButton.setFocusable(false);
        // registerButton.addActionListener(frame.frame);

        loginButton.setBounds(400, 390, 90, 25);
        loginButton.setFocusable(false);

        // add to the panel

        firstPagePanel.add(title);
        firstPagePanel.add(subTitle);
        firstPagePanel.add(roleBox);
        firstPagePanel.add(nicknameField);
        firstPagePanel.add(usernameField);
        firstPagePanel.add(passwordField);
        firstPagePanel.add(registerButton);
        firstPagePanel.add(loginButton);
    }

    // to clear the text in the textfield depending on the user action
    public void textFieldChanger() {
        nicknameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event) {
                if (nicknameField.getText().equals("Nickname")) {
                    nicknameField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event) {
                if (nicknameField.getText().equals("")) {
                    nicknameField.setText("Nickname");
                }
            }
        });

        usernameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event) {
                if (usernameField.getText().equals("Username")) {
                    usernameField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event) {
                if (usernameField.getText().equals("")) {
                    usernameField.setText("Username");
                }
            }
        });

        passwordField.addFocusListener(new FocusListener() {
            boolean flag = true;

            @Override
            public void focusGained(FocusEvent e) {
                if (flag == true) {
                    passwordField.setEchoChar('*'); // makes the characters in password field into '*'
                    passwordField.setText(""); // when field is clicked it resets the field
                    flag = false;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // nothing happens
            }
        });
    }

    // to add an action listener for login button and register button
    public void addFirstPageListener(ActionListener loginListener) {
        loginButton.addActionListener(loginListener);
        registerButton.addActionListener(loginListener);
    }

    // to add an action listener for register button
    public void addRegisterListener(ActionListener listenForRegisterButton) {
        registerButton.addActionListener(listenForRegisterButton);
    }

    boolean flag = true;

    @Override
    public void focusGained(FocusEvent e) {
        if (flag == true) {
            passwordField.setEchoChar('*'); // makes the characters in password field into '*'

            passwordField.setText(""); // when field is clicked it resets the field
            flag = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        // nothing happens
    }

    // gets the typed username and password
    public User getInfo() {
        info = new User(roleBox.getSelectedItem().toString(), nicknameField.getText(), usernameField.getText(),
                String.valueOf(passwordField.getPassword()));
        return info;
    }

    // to show message dialog
    public void displayMessage(String Message) {
        JOptionPane.showMessageDialog(firstPagePanel, Message);
    }

    //to get the first page panel
    public JPanel getFirstPagePanel() {
        return firstPagePanel;
    }

}