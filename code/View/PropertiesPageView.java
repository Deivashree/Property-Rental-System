package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Model.Property;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*  
  Entire class written by: 
  - Nurul Izzah Binti Shahrin

  Purpose of the class: 
  - To display the properties according to owner/agent at the proprty page
*/
public class PropertiesPageView {

  private JLabel[] propertyName;
  private JLabel[] propertyRentalPrice;
  private JLabel[] propertyAddress;
  private JLabel[] propertySize; 
  private JLabel[] propertyType;
  private JLabel[] numOfRooms;
  private JLabel[] numOfBathrooms;
  private JLabel[] contactNum;
  private JLabel[] facilities;
  private JLabel[] propertyStatus; 

  private JButton[] editButton;
  private JButton[] deleteButton;
  private JPanel propertiesPagePanel;
  private JButton addProperty;
  private JButton backButton;
  private JLabel title;
  private JPanel page;

  private JPanel[] propertyPanel;
  private JPanel[] propertyPanelLeft;
  private JPanel[] propertyPanelRight;

  private JScrollPane scroll;
  private int editButtonPosition;

  // to initialize all the view components in the property page
  public PropertiesPageView() {

    propertiesPagePanel = new JPanel();
    propertiesPagePanel.setBackground(new Color(0x2a6b96));
    propertiesPagePanel.setPreferredSize(new Dimension(1000, 700));
    propertiesPagePanel.setLayout(null);

    page = new JPanel();
    page.setBackground(new Color(0x2786c2));
    page.setBounds(50, 120, 880, 600);
    page.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    page.setLayout(new BoxLayout(page, BoxLayout.Y_AXIS));

    title = new JLabel();
    title.setText("Property Page");
    title.setBounds(400, 10, 300, 30);
    title.setForeground(Color.white);
    title.setFont(new Font("Comic Sans MS", Font.PLAIN,23));

    addProperty = new JButton();
    addProperty.setText("Add Property");
    addProperty.setFocusable(false);
    addProperty.setBounds(820, 10, 150, 30);

    backButton = new JButton();
    backButton.setText("Back");
    backButton.setFocusable(false);
    backButton.setBounds(10, 10, 70, 30);
  }

  // to add an action listener to the add property button
  public void addAddPropListener(ActionListener listenForAddPropertyButton){
		
		addProperty.addActionListener(listenForAddPropertyButton);
		
	}

  // to add an action listener to the back button
  public void addBackListener(ActionListener listenForBackButton){
		
		backButton.addActionListener(listenForBackButton);
		
	}

  // to display the properties according to owner/agent
  public void printPropertyDetails(ArrayList<Property> getAllPropertyDetails, String username) { 
    
    propertiesPagePanel.removeAll();
    page.removeAll();

    propertiesPagePanel.add(page);

    scroll = new JScrollPane(page);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setBounds(50, 50, 880, 600);

    propertiesPagePanel.add(addProperty);	
    propertiesPagePanel.add(backButton);
    propertiesPagePanel.add(title);

    ArrayList<Integer> userProperty = new ArrayList<>();

    for (int i = 0; i < getAllPropertyDetails.size(); i++) {

      if (username.equals(getAllPropertyDetails.get(i).getUsername())) {

        userProperty.add(i);
      }
    }

    propertyPanel = new JPanel[userProperty.size()];
    
    propertyPanelLeft = new JPanel[userProperty.size()];
    propertyName = new JLabel[userProperty.size()];
    propertyRentalPrice = new JLabel[userProperty.size()];
    propertyAddress = new JLabel[userProperty.size()];
    propertySize = new JLabel[userProperty.size()];
    propertyType = new JLabel[userProperty.size()];
    numOfRooms = new JLabel[userProperty.size()];
    numOfBathrooms = new JLabel[userProperty.size()];
    facilities = new JLabel[userProperty.size()];
    contactNum = new JLabel[userProperty.size()];
    propertyStatus = new JLabel[userProperty.size()];

    propertyPanelRight = new JPanel[userProperty.size()];
    editButton = new JButton[userProperty.size()];
    deleteButton = new JButton[userProperty.size()];

    for(int i = 0; i < userProperty.size(); i++) {

      propertyPanel[i] = new JPanel();
      propertyPanel[i].setBackground(new Color(0x4ba4e3));
      propertyPanel[i].setPreferredSize(new Dimension(800, 200));
      propertyPanel[i].setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0x566169)));  
      
      propertyPanelLeft[i] = new JPanel();
      propertyPanelLeft[i].setLayout(null);
      propertyPanelLeft[i].setBackground(new Color(0x4ba4e3));
      propertyPanelLeft[i].setPreferredSize(new Dimension(650, 180));

      propertyName[i] = new JLabel();
      propertyName[i].setBounds(0, 0, 500, 25);
      propertyName[i].setText(getAllPropertyDetails.get(userProperty.get(i)).getPropertyName());
      propertyName[i].setForeground(Color.white);
      propertyName[i].setFont(new Font("Comic Sans MS", Font.PLAIN,20));

      String propRentalPrice = String.format("RM%.2f", getAllPropertyDetails.get(userProperty.get(i)).getPropertyRentalPrice());
      propertyRentalPrice[i] = new JLabel();
      propertyRentalPrice[i].setBounds(0, 30, 150, 20);
      propertyRentalPrice[i].setText(propRentalPrice);
      propertyRentalPrice[i].setForeground(Color.white);
      propertyRentalPrice[i].setFont(new Font("Comic Sans MS", Font.BOLD,20));

      propertyAddress[i] = new JLabel();
      propertyAddress[i].setBounds(0, 60, 800, 25);
      propertyAddress[i].setText(getAllPropertyDetails.get(userProperty.get(i)).getPropertyAddress());
      propertyAddress[i].setForeground(Color.white);
      propertyAddress[i].setFont(new Font("Comic Sans MS", Font.PLAIN,18));

      propertyType[i] = new JLabel();
      propertyType[i].setBounds(0, 95, 150, 20);
      propertyType[i].setText(getAllPropertyDetails.get(userProperty.get(i)).getPropertyType());
      propertyType[i].setForeground(Color.white);
      propertyType[i].setFont(new Font("Comic Sans MS", Font.PLAIN,15));

      propertySize[i] = new JLabel();
      propertySize[i].setBounds(105, 95, 150, 20);
      propertySize[i].setText("| " + getAllPropertyDetails.get(userProperty.get(i)).getPropertySize() + " sqft");
      propertySize[i].setForeground(Color.white);
      propertySize[i].setFont(new Font("Comic Sans MS", Font.PLAIN,15));

      numOfRooms[i] = new JLabel();
      numOfRooms[i].setBounds(0, 120, 110, 20);
      numOfRooms[i].setText("Rooms: " + getAllPropertyDetails.get(userProperty.get(i)).getNumOfRooms());
      numOfRooms[i].setForeground(Color.white);
      numOfRooms[i].setFont(new Font("Comic Sans MS", Font.PLAIN,15));

      numOfBathrooms[i] = new JLabel();
      numOfBathrooms[i].setBounds(70, 120, 150, 20);
      numOfBathrooms[i].setText("| Bathrooms: " + getAllPropertyDetails.get(userProperty.get(i)).getNumOfBathrooms());
      numOfBathrooms[i].setForeground(Color.white);
      numOfBathrooms[i].setFont(new Font("Comic Sans MS", Font.PLAIN,15));

      for (int k = 0; k < getAllPropertyDetails.get(userProperty.get(i)).getFacilities().size(); k++) {
        facilities[i] = new JLabel();
        facilities[i].setBounds(180, 120, 400, 20);
        facilities[i].setText("| " + getAllPropertyDetails.get(userProperty.get(i)).getFacilities().get(k));
        facilities[i].setForeground(Color.WHITE);
        facilities[i].setFont(new Font("Comic Sans MS", Font.PLAIN,15));
      }
      
      contactNum[i] = new JLabel();
      contactNum[i].setBounds(60, 160, 500, 20);
      contactNum[i].setText(" | " + "Owner Name: " + username + " | Contact Number: " + getAllPropertyDetails.get(userProperty.get(i)).getContactNum());
      contactNum[i].setForeground(Color.white);
      contactNum[i].setFont(new Font("Comic Sans MS", Font.PLAIN,15));

      propertyStatus[i] = new JLabel();
      propertyStatus[i].setBounds(0, 160, 200, 20);
      propertyStatus[i].setText(getAllPropertyDetails.get(userProperty.get(i)).getPropertyStatus());
      propertyStatus[i].setForeground(new Color(0x7cfca0));
      propertyStatus[i].setFont(new Font("Comic Sans MS", Font.BOLD,15));

      propertyPanelRight[i] = new JPanel();
      propertyPanelRight[i].setLayout(null);
      propertyPanelRight[i].setBackground(new Color(0x4ba4e3));
      propertyPanelRight[i].setPreferredSize(new Dimension(150, 180));

      editButton[i] = new JButton("Edit Property");
      editButton[i].setBounds(0, 60, 150, 30);
      editButton[i].setActionCommand(Integer.toString(i));

      deleteButton[i] = new JButton("Delete Property");
      deleteButton[i].setBounds(0, 100, 150, 30);
      deleteButton[i].setActionCommand(Integer.toString(i));

      propertyPanelLeft[i].add(propertyName[i]);
      propertyPanelLeft[i].add(propertyAddress[i]);
      propertyPanelLeft[i].add(propertyRentalPrice[i]);
      propertyPanelLeft[i].add(propertySize[i]);
      propertyPanelLeft[i].add(propertyType[i]);
      propertyPanelLeft[i].add(numOfRooms[i]);
      propertyPanelLeft[i].add(numOfBathrooms[i]);
      propertyPanelLeft[i].add(facilities[i]);
      propertyPanelLeft[i].add(contactNum[i]);
      propertyPanelLeft[i].add(propertyStatus[i]);
 
      propertyPanelRight[i].add(editButton[i], BorderLayout.CENTER);
      propertyPanelRight[i].add(deleteButton[i], BorderLayout.CENTER);

      propertyPanel[i].add(propertyPanelLeft[i]);
      propertyPanel[i].add(propertyPanelRight[i]);

      page.add(Box.createRigidArea(new Dimension(0, 20)));
      page.add(propertyPanel[i]);
    }
    
    propertiesPagePanel.add(scroll);
  }

  // to add an action listener to all of the edit property button
  public void addAllEditPropListener(ActionListener listenForEditPropertyButton) { 

    for(int i = 0; i < editButton.length; i++) {
      editButton[i].addActionListener(listenForEditPropertyButton);
    }

	}

  // to add an action listener to all of the delete property button
  public void addAllDeletePropListener(ActionListener listenForDeletePropertyButton) { 

    for(int i = 0; i < deleteButton.length; i++) {
      deleteButton[i].addActionListener(listenForDeletePropertyButton);
    }

	}

  // to set the position of the edit button which is selected by owner/agent
  public void setEditButtonPosition(int pos) {
    editButtonPosition = pos;
  }

  // to get the position of the edit button which is selected by owner/agent
  public int getEditButtonPosition() {
    return editButtonPosition;
  }

  // to get the selected edit button
  public JButton[] getEditButton() {
    return editButton;
  }

  // to get the selected deleted button
  public JButton[] getDeleteButton() {
    return deleteButton;
  }

  //to get the scroll
  public JScrollPane getScroll() {
    return scroll;
  }

  // to get the properties panel
  public JPanel getPropertiesPanel() {
    return propertiesPagePanel;
  }
}
