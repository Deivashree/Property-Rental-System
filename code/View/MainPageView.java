package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Model.Property;

/*  
  Entire class written by: 
  -Ali Imran Bin Shahrin

  Purpose of the class: 
  - To display the main page for the properties to be viewed by the user
*/

public class MainPageView {

  //Initialization of the property info/main page swing elements
  private String[] propertyRentalPriceList = {"100.0","200.0","300.0","400.0","600.0","800.0","1000.0","1500.0","2000.0","3000.0","4000.0","5000.0"};
  private String[] propertySizeList = {"100.0","200.0","300.0","500.0","800.0","1500.0","2000.0","3000.0"};
  private String[] propertyTypeList = {"Double Storey","Condominium","Apartment"};
  private String[] numOfRoomsList = {"1","2","3","4","5","6","7","8","9","10"};
  private String[] numOfBathroomsList = {"1","2","3","4","5","6","7","8","9","10"};
  private String[] propertyStatusList = {"Active", "Inactive"};

  private JLabel propertyRentalPriceLabel = new JLabel("Rental Price");
  private JLabel propertySizeLabel = new JLabel("Property Size");
  private JLabel propertyTypeLabel = new JLabel("Property Type");
  private JLabel numOfRoomsLabel = new JLabel("Num. Of Rooms");
  private JLabel numOfBedRoomsLabel = new JLabel("Num. Of Bedrooms");
  private JLabel propertyStatusLabel = new JLabel("Property Status");




  private JLabel[] propertyName;
  private JLabel[] propertyRentalPrice; 
  private JLabel[] propertyAddress;
  private JLabel[] propertySize; 
  private JLabel[] propertyType;
  private JLabel[] numOfRooms;
  private JLabel[] numOfBathrooms;
  private JLabel[] facilities; 
  private JLabel[] contactNum;
  private JLabel[] propertyStatus; 
  private JLabel[] username; // foreign key
  private JLabel title = new JLabel("Main Page");

  private JPanel propertiesPagePanel;

  private JPanel page;

  private JPanel[] propertyPanel;
  private JButton editProfileButton = new JButton("Edit Profile");
  private JButton propertiesPageButton = new JButton("Properties Page");
  private JButton logoutButton = new JButton("Log out");
  private JButton filterButton = new JButton("Filter");
  private JButton resetButton = new JButton("Reset");
  private JButton adminBackButton = new JButton("Admin Back");

  private JPanel navigationPanel = new JPanel();
  private JPanel filterPanel = new JPanel();
  private JPanel titlePanel = new JPanel();

  private JComboBox propertyRentalPriceCombo = new JComboBox<>(propertyRentalPriceList);
  private JComboBox propertySizeCombo = new JComboBox<>(propertySizeList);
  private JComboBox propertyTypeCombo = new JComboBox<>(propertyTypeList);
  private JComboBox numOfRoomsCombo = new JComboBox<>(numOfRoomsList);
  private JComboBox numOfBathroomsCombo = new JComboBox<>(numOfBathroomsList);
  private JCheckBox wifiCheckBox = new JCheckBox("Wi-Fi");
  private JCheckBox swimmingpoolCheckBox = new JCheckBox("Swimming Pool");
  private JCheckBox aircondCheckBox = new JCheckBox("Air-Conditioned");
  private JComboBox propertyStatusCombo = new JComboBox<>(propertyStatusList);

  
 
  private JScrollPane scroll;

  public MainPageView() {

    //alignments, fonts, backgrounds, layout of the page
    navigationPanel.setBounds(25,100,100,500);
    filterPanel.setBounds(800,30,700,700);
    filterPanel.setLayout(null);
    titlePanel.setBounds(0,0,900,50);
    titlePanel.setLayout(null);



    propertiesPagePanel = new JPanel();
    propertiesPagePanel.setBackground(new Color(0x2a6b93));
    //propertiesPagePanel.setBounds(0, 0, 1000, 700);
    propertiesPagePanel.setPreferredSize(new Dimension(1000, 700));
    propertiesPagePanel.setLayout(null);

    page = new JPanel();
    page.setBackground(new Color(0x2786c2));
    page.setBounds(50, 120, 880, 600);
    //page.setBorder(new EmptyBorder(new Insets(50, 80, 50, 80)));  
    page.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    page.setLayout(new BoxLayout(page, BoxLayout.Y_AXIS));

  
   
    propertyRentalPriceCombo.setBounds(20,25,130,30);
    propertySizeCombo.setBounds(20,75,130,30);
    propertyTypeCombo.setBounds(20,125, 130, 30);
    numOfRoomsCombo.setBounds(20,175,130,30);
    numOfBathroomsCombo.setBounds(20,225,130,30);
    wifiCheckBox.setBounds(20,275,130,30);
    aircondCheckBox.setBounds(20,325,130,30);
    swimmingpoolCheckBox.setBounds(20,375,130,30);
    propertyStatusCombo.setBounds(20,425,130,30);
    filterButton.setBounds(20,475,130,30);
    resetButton.setBounds(20,525,130,50);
    adminBackButton.setBounds(20,18,120,35);

    propertyRentalPriceLabel.setBounds(20,0,100,30);
    propertySizeLabel.setBounds(20,50,100,30);
    propertyTypeLabel.setBounds(20,100,100,30);
    numOfRoomsLabel.setBounds(20,150,100,30);
    numOfBedRoomsLabel.setBounds(20,200,120,30);
    propertyStatusLabel.setBounds(20,400,100,30);
    
    title.setBounds(450,0,150,50);
    title.setForeground(Color.white);
    title.setFont(new Font("Comic Sans MS", Font.PLAIN,23));
    titlePanel.add(title);
  

  }

 
  //method to print out the properties detail if its called in another class
  public void printPropertyDetails(ArrayList<Property> getAllPropertyDetails) { 
    
    propertiesPagePanel.removeAll();
    page.removeAll();

    navigationPanel.add(editProfileButton);
    navigationPanel.add(propertiesPageButton);
    navigationPanel.add(logoutButton);
    navigationPanel.setBackground(new Color(0x2a6b93));

    filterPanel.setBackground(new Color(0x2a6b93));
    filterPanel.add(propertyRentalPriceCombo);
    filterPanel.add(propertySizeCombo);
    filterPanel.add(propertyTypeCombo);
    filterPanel.add(numOfRoomsCombo);
    filterPanel.add(numOfBathroomsCombo);
    filterPanel.add(wifiCheckBox);
    filterPanel.add(swimmingpoolCheckBox);
    filterPanel.add(aircondCheckBox);
    filterPanel.add(propertyStatusCombo);
    filterPanel.add(filterButton);

    filterPanel.add(propertyRentalPriceLabel);
    filterPanel.add(propertySizeLabel);
    filterPanel.add(propertyTypeLabel);
    filterPanel.add(numOfRoomsLabel);
    filterPanel.add(numOfBedRoomsLabel);
    filterPanel.add(propertyStatusLabel);
    filterPanel.add(resetButton);
   
    titlePanel.setBackground(new Color(0x2a6b93));
    titlePanel.add(adminBackButton);

   


    propertiesPagePanel.add(filterPanel);
    propertiesPagePanel.add(navigationPanel);
    propertiesPagePanel.add(page);
    propertiesPagePanel.add(titlePanel);

    scroll = new JScrollPane(page);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setBounds(150, 50, 650, 600);

   
  
    propertyPanel = new JPanel[getAllPropertyDetails.size()];
    propertyName = new JLabel[getAllPropertyDetails.size()];
    propertyRentalPrice = new JLabel[getAllPropertyDetails.size()];
    propertyAddress = new JLabel[getAllPropertyDetails.size()];
    propertySize = new JLabel[getAllPropertyDetails.size()];
    propertyType = new JLabel[getAllPropertyDetails.size()];
    numOfRooms = new JLabel[getAllPropertyDetails.size()];
    numOfBathrooms = new JLabel[getAllPropertyDetails.size()];
    facilities = new JLabel[getAllPropertyDetails.size()];
    contactNum = new JLabel[getAllPropertyDetails.size()];
    propertyStatus = new JLabel[getAllPropertyDetails.size()];
    username = new JLabel[getAllPropertyDetails.size()];
    
    //amount of property for loop
    for(int i = 0; i < propertyName.length; i++) {

      propertyPanel[i] = new JPanel();
      propertyPanel[i].setLayout(null);
      propertyPanel[i].setBackground(new Color(0x4ba4e3));
      propertyPanel[i].setPreferredSize(new Dimension(550, 200)); 
      propertyPanel[i].setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0x566169)));
      propertyPanel[i].add(Box.createRigidArea(new Dimension(0, 5)));
      
      propertyName[i] = new JLabel();
      propertyName[i].setBounds(10, 10, 400, 25);
      propertyName[i].setText(getAllPropertyDetails.get(i).getPropertyName());
      propertyName[i].setForeground(Color.white);
      propertyName[i].setFont(new Font("Comic Sans MS", Font.PLAIN,20));

      propertyAddress[i] = new JLabel();
      propertyAddress[i].setBounds(10, 70, 800, 30);
      propertyAddress[i].setText(getAllPropertyDetails.get(i).getPropertyAddress());
      propertyAddress[i].setForeground(Color.white);
      propertyAddress[i].setFont(new Font("Comic Sans MS", Font.PLAIN,18));
      
      String propRentalPrice = String.format("RM%.2f", getAllPropertyDetails.get(i).getPropertyRentalPrice());
      propertyRentalPrice[i] = new JLabel();
      propertyRentalPrice[i].setBounds(10, 40, 150, 20);
      propertyRentalPrice[i].setText(propRentalPrice);
      propertyRentalPrice[i].setForeground(Color.white);
      propertyRentalPrice[i].setFont(new Font("Comic Sans MS", Font.BOLD,20));

      propertyType[i] = new JLabel();
      propertyType[i].setBounds(10, 105, 150, 20);
      propertyType[i].setText(getAllPropertyDetails.get(i).getPropertyType());
      propertyType[i].setForeground(Color.white);
      propertyType[i].setFont(new Font("Comic Sans MS", Font.PLAIN,15));

      propertySize[i] = new JLabel();
      propertySize[i].setBounds(120, 105, 150, 20);
      propertySize[i].setText("| " + getAllPropertyDetails.get(i).getPropertySize() + " sqft");
      propertySize[i].setForeground(Color.white);
      propertySize[i].setFont(new Font("Comic Sans MS", Font.PLAIN,15));

      numOfRooms[i] = new JLabel();
      numOfRooms[i].setBounds(10, 130, 110, 20);
      numOfRooms[i].setText("Rooms: " + getAllPropertyDetails.get(i).getNumOfRooms());
      numOfRooms[i].setForeground(Color.white);
      numOfRooms[i].setFont(new Font("Comic Sans MS", Font.PLAIN,15));

      numOfBathrooms[i] = new JLabel();
      numOfBathrooms[i].setBounds(83, 130, 150, 20);
      numOfBathrooms[i].setText("| Bathrooms: " + getAllPropertyDetails.get(i).getNumOfBathrooms());
      numOfBathrooms[i].setForeground(Color.white);
      numOfBathrooms[i].setFont(new Font("Comic Sans MS", Font.PLAIN,15));

      for (int j = 0; j < getAllPropertyDetails.get(i).getFacilities().size(); j++) {
        facilities[i] = new JLabel();
        facilities[i].setBounds(200, 130, 400, 20);
        facilities[i].setText("| "+ getAllPropertyDetails.get(i).getFacilities().get(j));
        facilities[i].setForeground(Color.WHITE);
        facilities[i].setFont(new Font("Comic Sans MS", Font.PLAIN,15));
      }
      
      contactNum[i] = new JLabel();
      contactNum[i].setBounds(70, 160, 500, 15);
      contactNum[i].setText(" | " + "Owner Name: " + getAllPropertyDetails.get(i).getUsername()+ " | Contact Number: " + getAllPropertyDetails.get(i).getContactNum());
      contactNum[i].setForeground(Color.white);
      contactNum[i].setFont(new Font("Comic Sans MS", Font.PLAIN,15));
      
      propertyStatus[i] = new JLabel();
      propertyStatus[i].setBounds(10, 160, 200, 15);
      propertyStatus[i].setText(getAllPropertyDetails.get(i).getPropertyStatus());
      propertyStatus[i].setForeground(new Color(0x7cfca0));
      propertyStatus[i].setFont(new Font("Comic Sans MS", Font.BOLD,15));
    
      propertyPanel[i].add(propertyName[i]);
      propertyPanel[i].add(propertyAddress[i]);
      propertyPanel[i].add(propertyRentalPrice[i]);
      propertyPanel[i].add(propertyType[i]);
      propertyPanel[i].add(propertySize[i]);
      propertyPanel[i].add(numOfRooms[i]);
      propertyPanel[i].add(numOfBathrooms[i]);
      propertyPanel[i].add(facilities[i]);
      propertyPanel[i].add(contactNum[i]);
      propertyPanel[i].add(propertyStatus[i]);
    
     

     
      page.add(propertyPanel[i]);
    }

 
    propertiesPagePanel.add(scroll);


  }
  
 

  public String getPropertyRentalPriceCombo(){
    return propertyRentalPriceCombo.getSelectedItem().toString();
  }

  public String getPropertySizeCombo(){
    return propertySizeCombo.getSelectedItem().toString();
  }

  public String getPropertyTypeCombo(){
    return propertyTypeCombo.getSelectedItem().toString();
  }

  public String getNumOfRoomsCombo(){
    return numOfRoomsCombo.getSelectedItem().toString();
  }

  public String getNumOfBathroomsCombo(){
    return numOfBathroomsCombo.getSelectedItem().toString();
  }

  public String getWifiCheckBox(){
    if(wifiCheckBox.isSelected()){
      return "Wi-Fi";
    }else{
      return "";
    }
  } 

  public String getSwimmingPoolCheckBox(){
    if(swimmingpoolCheckBox.isSelected()){
      return "Swimming Pool";
    }else{
      return "";
    }
  }

  public String getAircondCheckBox(){
    if(aircondCheckBox.isSelected()){
      return "Air-Conditioned";
    }else{
      return "";
    }
  }

  public String getPropertyStatusCombo(){
    return propertyStatusCombo.getSelectedItem().toString();
  }

  public void resetListener(ActionListener listenforResetButton){
    resetButton.addActionListener(listenforResetButton);
  }

  public void editProfileListener(ActionListener listenforEditProfileButton){
    editProfileButton.addActionListener(listenforEditProfileButton);
  }

  public void adminBackButtonListener(ActionListener listenforAdminBackButton){
    adminBackButton.addActionListener(listenforAdminBackButton);
  }

  public void propertiesPageListener(ActionListener listenforPropertiesPageButton){
    propertiesPageButton.addActionListener(listenforPropertiesPageButton);
  }

  public void logoutListener(ActionListener listenforLogoutButton){
    logoutButton.addActionListener(listenforLogoutButton);
  }

  public void filterButtonListener(ActionListener listenforFilterButton){
    filterButton.addActionListener(listenforFilterButton);
  }

  public JScrollPane getScroll() {
    return scroll;
  }

  public JPanel getMainPagePanel() {
    return propertiesPagePanel;
  }

  public void displayErrorMessage(String errorMessage){
    JOptionPane.showMessageDialog(propertiesPagePanel,errorMessage);;
}

 

}
