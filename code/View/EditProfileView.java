package View;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*  
  Entire class written by: 
  - Lee Wei Chuen

  Purpose of the class: 
  - To display edit profile page for the user to edit their nickname
*/

public class EditProfileView {
    private JLabel title = new JLabel("Edit Profile");
    JTextField nickname = new JTextField(30);
    private JPanel editProfilePanel;
    private JButton editUsernameButton = new JButton("Edit Nickname");
    private JButton backButton = new JButton("Done");

    // to set the text in nickname
    public void setUsername() {
        nickname.setText("Nickname");
    }

    // to get the back button
    public JButton getBackButton() {
        return backButton;
    }

    EditProfileView() {
        editProfilePanel = new JPanel();
        editProfilePanel.setBackground(new Color(0x2a6b96));
        editProfilePanel.setPreferredSize(new Dimension(1000, 700));
        editProfilePanel.setLayout(null);

        title.setBounds(390, 160, 380, 40);
        title.setForeground(new Color(0xffffff));
        title.setFont(new Font("MV Boli", Font.PLAIN, 35));

        nickname = new JTextField();
        nickname.setBounds(310, 320, 200, 25);
        nickname.setHorizontalAlignment(JLabel.CENTER);
        nickname.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event) {
                if (nickname.getText().equals("Nickname")) {
                    nickname.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event) {
                if (nickname.getText().equals("")) {
                    nickname.setText("Nickname");
                }
            }
        });

        editUsernameButton.setBounds(515, 320, 140, 25);
        editUsernameButton.setHorizontalAlignment(JLabel.CENTER);
        editUsernameButton.setFocusable(false);

        backButton.setBounds(515, 380, 140, 25);
        backButton.setHorizontalAlignment(JLabel.CENTER);
        backButton.setFocusable(false);

        editProfilePanel.add(title);
        editProfilePanel.add(nickname);
        editProfilePanel.add(editUsernameButton);
        editProfilePanel.add(backButton);
    }

    // to clear the text in the textfield depending on the user action
    public void textFieldChanger() {
        nickname.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event) {
                if (nickname.getText().equals("Nickname")) {
                    nickname.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event) {
                if (nickname.getText().equals("")) {
                    nickname.setText("Nickname");
                }
            }
        });

    }

    // to get the nickname of the user
    public String getUsername() {
        return nickname.getText();
    }

    // to add an action listener for edit username button
    public void editUserNameListener(ActionListener listenForEditUserNameButton) {
        editUsernameButton.addActionListener(listenForEditUserNameButton);
    }

    // to add an action listener for back button
    public void backButtonListener(ActionListener listenForBackButton) {
        backButton.addActionListener(listenForBackButton);
    }

    // to show message dialog
    void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(editProfilePanel, errorMessage);
    }

    //to get the edit profile panel
    public JPanel getEditProfilePanel() {
        return editProfilePanel;
    }

}
