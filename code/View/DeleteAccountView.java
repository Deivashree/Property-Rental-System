package View;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import Model.DeleteAccountModel;
import Model.User;

/*  
  Entire class written by: 
  - Lee Wei Chuen

  Purpose of the class: 
  - To display the list of users in the system for the admin to choose to delete account
*/

public class DeleteAccountView {

    private JPanel deleteAccountPanel;
    private JLabel deleteAccountTitle = new JLabel("Delete Account for Admin");
    private JScrollPane scrollPane;
    private JButton deleteButton = new JButton("Delete");
    private JButton backButton = new JButton("Back");
    private Box box;
    private ArrayList<JCheckBox> checkboxes;

    //to get the back button
    public JButton getBackButton() {
        return backButton;
    }

    //to get the delete button
    public JButton getDeleteButton() {
        return deleteButton;
    }

    //to get the box
    public Box getBox() {
        return box;
    }

    //to get the checkboxes arraylist
    public ArrayList<JCheckBox> getCheckboxesArrayList() {
        return checkboxes;
    }

    public DeleteAccountView() {

        deleteAccountPanel = new JPanel();
        deleteAccountPanel.setBackground(new Color(0x2a6b96));
        deleteAccountPanel.setPreferredSize(new Dimension(1000, 700));
        deleteAccountPanel.setLayout(null);

        deleteAccountTitle.setBounds(330, 50, 400, 20);
        deleteAccountTitle.setForeground(new Color(0xffffff));
        deleteAccountTitle.setFont(new Font("MV Boli",Font.PLAIN,25));

        deleteButton.setBounds(660, 610, 90, 25);
        deleteButton.setFocusable(false);

        backButton.setBounds(250, 610, 90, 25);
        backButton.setFocusable(false);

    }

    //to display the accounts in the system
    public void displayDeleteAccountView(ArrayList<User> getUserDetails) {

        deleteAccountPanel.removeAll();
            
        box = Box.createVerticalBox();
        checkboxes = new ArrayList<>();
        for(int i = 0; i<getUserDetails.size(); i++) {
            JCheckBox tempCheckBox = new JCheckBox(getUserDetails.get(i).getUser());
            box.add(tempCheckBox);
            checkboxes.add(tempCheckBox);
        }

        scrollPane = new JScrollPane(box);
        scrollPane.setBounds(250, 100, 500, 450);
        scrollPane.setPreferredSize(new Dimension(500, 450));
        //scrollPane.
        scrollPane.createHorizontalScrollBar();
        
        deleteAccountPanel.add(deleteAccountTitle);
        deleteAccountPanel.add(scrollPane);
        deleteAccountPanel.add(deleteButton);
        deleteAccountPanel.add(backButton);
    }

    //to add an action listener for delete button and back button
    public void addDeleteAdminListener(ActionListener deleteAccountListener) {
        deleteButton.addActionListener(deleteAccountListener);
        backButton.addActionListener(deleteAccountListener);
    }

    //to get the delete account  panel
    public JPanel getDeleteAccountPanel() {
        return deleteAccountPanel;
      }
}
