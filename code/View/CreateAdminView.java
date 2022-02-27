package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.User;

/*  
  Entire class written by: 
  - Lee Wei Chuen

  Purpose of the class: 
  - To display the create admin account page for admin to create another admin account
*/

public class CreateAdminView implements FocusListener {

    private JPanel createAdminPanel;
    private JLabel title = new JLabel("Create Admin Account");                //"Awesome Rental Service" title
    private JTextField nicknameField;                                               //Nickname field
    private JTextField usernameField = new JTextField("Username");                  //username field
    private JPasswordField passwordField = new JPasswordField("Password");        //password field
    private JButton registerButton = new JButton("Register");                   //register button
    private JButton backButton = new JButton("Back");

    private User info;

    // to get register button
    public JButton getRegisterButton() {
        return registerButton;
    }

    //to get back button
    public JButton getBackButton() {
        return backButton;
    }

    //to set the text in nicknameField to Nickname
    public void setNicknameField() {
        this.nicknameField.setText("Nickname");
    }

    //to set the text in usernameField to Username
    public void setUsernameField() {
        this.usernameField.setText("Username");
    }

    //to set the text in passwordField to Password
    public void setPasswordField() {
        this.passwordField.setText("Password");
    }

    public CreateAdminView() {

        createAdminPanel = new JPanel();
        createAdminPanel.setBackground(new Color(0x2a6b96));
        //createAdminPanel.setBounds(0, 0, 1000, 700);
        createAdminPanel.setPreferredSize(new Dimension(1000, 700));
        createAdminPanel.setLayout(null);
        
        //the position and customization for title
        title.setBounds(355, 160, 550, 30);
        title.setForeground(new Color(0xffffff));
        title.setFont(new Font("MV Boli",Font.PLAIN,25));

        nicknameField = new JTextField("Nickname");
        nicknameField.setBounds(390, 250, 200, 25);
        nicknameField.setHorizontalAlignment(JLabel.CENTER);
        //nicknameField.setText("Nickname");
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

        //The position for username field
        usernameField.setBounds(390, 290, 200, 25);
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

        passwordField = new JPasswordField("Password");
        passwordField.setBounds(390, 330, 200, 25);
        passwordField.setHorizontalAlignment(JLabel.CENTER);
        passwordField.setEchoChar((char) 0);
        passwordField.addFocusListener(this);


        //back to admin main menu
        backButton.setBounds(390, 390, 90, 25);
        backButton.setFocusable(false);


        // registerButton.addActionListener(frame.frame);
        registerButton = new JButton("Register");
        registerButton.setBounds(500, 390, 90, 25);
        registerButton.setHorizontalAlignment(JLabel.CENTER);
        registerButton.setFocusable(false);

        //adds to the JFrame
        createAdminPanel.add(title);
        createAdminPanel.add(nicknameField);
        createAdminPanel.add(usernameField);
        createAdminPanel.add(passwordField);
        createAdminPanel.add(registerButton);
        createAdminPanel.add(backButton);
    }

    //to clear the text in the textfield depending on the user action
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

	// to add an action listener for back button and register button
    public void addCreateAdminListener(ActionListener loginListener) {
        backButton.addActionListener(loginListener);
        registerButton.addActionListener(loginListener);
    }

    //to add an action listener for register button
    public void addRegisterListener(ActionListener listenForRegisterButton){
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

    //to get the typed username and password
    public User getInfo() {
        info = new User("Admin", nicknameField.getText(), usernameField.getText(),String.valueOf(passwordField.getPassword()));
        return info;
    }

    //to show message dialog
    void displayMessage (String Message) {
        JOptionPane.showMessageDialog(createAdminPanel, Message);
    }

    //to get create admin panel
    public JPanel getCreateAdminPanel() {
       return createAdminPanel;
    }

}