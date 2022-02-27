package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/*  
  Entire class written by: 
  - Lee Wei Chuen

  Purpose of the class: 
  - To display the features that can be access by the admin.
*/

public class AdminMenuView {

    private JPanel adminMenuPanel;
    private JButton createAccountButton = new JButton("Create Admin Account");
    private JButton mainPageButton = new JButton("Main Page");
    private JButton deleteAccountButton = new JButton("Delete Account");
    private JLabel adminMenuTitle = new JLabel("Admin Menu");
    
    //to get create account button
    public JButton getCreateAccountButton() {
        return createAccountButton;
    }

    //to get main page button
    public JButton getMainPageButton() {
        return mainPageButton;
    }

    //to get delete button
    public JButton getDeleteAccountButton() {
        return deleteAccountButton;
    }

    public AdminMenuView() {
        
        adminMenuPanel = new JPanel();
        adminMenuPanel.setBackground(new Color(0x2a6b96));
        adminMenuPanel.setPreferredSize(new Dimension(1000, 700));
        adminMenuPanel.setLayout(null);

        adminMenuTitle.setBounds(400, 100, 200, 20);
        adminMenuTitle.setForeground(new Color(0xffffff));
        adminMenuTitle.setFont(new Font("MV Boli",Font.PLAIN,25));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(100, 100, 800, 500);
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(new Color(0x2a6b96));
        createAccountButton.setBounds(120,80,250,100);
        mainPageButton.setBounds(380,80,250,100);
        deleteAccountButton.setBounds(250,200,250,100);
        buttonPanel.add(createAccountButton);
        buttonPanel.add(mainPageButton);
        buttonPanel.add(deleteAccountButton);

        adminMenuPanel.add(adminMenuTitle);
        adminMenuPanel.add(buttonPanel);
    }

    //to add listener for create account button, main page button and delete account button
    public void addCreateAdminListener(ActionListener loginListener) {
        createAccountButton.addActionListener(loginListener);
        mainPageButton.addActionListener(loginListener);
        deleteAccountButton.addActionListener(loginListener);
    }

    // to get the admin menu penel
    public JPanel getAdminMenuPanel() {
        return adminMenuPanel;
      }

}
