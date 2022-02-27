package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/*  
  Entire class written by: 
  - Deivashree A/P Selva Rajoo

  Purpose of the class: 
  - To display the add property page for owner/agent to add property 
*/
public class AddPropertyView{

	private JPanel mainAddPropertyPanel;
	private JPanel addPropertyPanel; 
	private JLabel addPropertyTitle; 
	private JLabel propertyLabel;
  private JTextField propertyName;
	private JLabel propertyRentalPriceLabel;
	private JTextField propertyRentalPrice;
	private JLabel propertyAddressLabel;
	private JTextField propertyAddress;
	private JLabel propertyTypeLabel;
	private	JComboBox <String> propertyType;
	private JLabel propertySizeLabel;
	private JTextField propertySize;
	private JLabel numOfRoomsLabel;
	private JTextField numOfRooms;
	private JLabel numOfBathroomsLabel;
	private JTextField numOfBathrooms;
	private JLabel propertyFacilitiesLabel;
	private	JCheckBox wifiFac;
	private	JCheckBox swimmingPoolFac;
	private	JCheckBox airCondFac;
	private JLabel contactNumLabel;
	private JTextField contactNum;
	private JButton saveButton;
	private JButton backButton;

	// to initialize all the view components in the add property page
  public AddPropertyView() {
      			
		mainAddPropertyPanel = new JPanel(null);
		mainAddPropertyPanel.setBounds(0, 0, 1000, 700);
		mainAddPropertyPanel.setBackground(new Color(0x2a6b96));
				
    addPropertyPanel = new JPanel(null);
		addPropertyPanel.setBounds(20, 20, 945, 620);
		addPropertyPanel.setBackground(new Color(0x2786c2));

		addPropertyTitle = new JLabel("Add Property Page");
		addPropertyTitle.setFont(new java.awt.Font("Comic Sans MS", Font.PLAIN, 30));
		addPropertyTitle.setBounds(350, 20, 300, 50);
		addPropertyTitle.setForeground(Color.WHITE);

		propertyLabel = new JLabel("Property Name: ");
		propertyLabel.setFont(new java.awt.Font("Comic Sans MS", Font.PLAIN, 15));
		propertyLabel.setBounds(200, 100, 150, 30);
		propertyLabel.setForeground(Color.WHITE);

		propertyName = new JTextField(10);
		propertyName.setBounds(400, 100, 300, 30);

		propertyRentalPriceLabel = new JLabel("Property Rental Price:");
		propertyRentalPriceLabel.setFont(new java.awt.Font("Comic Sans MS", Font.PLAIN, 15));
		propertyRentalPriceLabel.setBounds(200, 140, 200, 30);
		propertyRentalPriceLabel.setForeground(Color.WHITE);
				
		propertyRentalPrice = new JTextField(10);
		propertyRentalPrice.setBounds(400, 140, 200, 30);

		propertyAddressLabel = new JLabel("Property Address:");
		propertyAddressLabel.setFont(new java.awt.Font("Comic Sans MS", Font.PLAIN, 15));
		propertyAddressLabel.setBounds(200, 180, 200, 30);
		propertyAddressLabel.setForeground(Color.WHITE);
				
		propertyAddress = new JTextField(10);
		propertyAddress.setBounds(400, 180, 400, 30);

		propertySizeLabel = new JLabel("Property Size:");
		propertySizeLabel.setFont(new java.awt.Font("Comic Sans MS", Font.PLAIN, 15));
		propertySizeLabel.setBounds(200, 220, 200, 30);
		propertySizeLabel.setForeground(Color.WHITE);
				
		propertySize = new JTextField(10);
		propertySize.setBounds(400, 220, 400, 30);

		propertyTypeLabel = new JLabel("Property Type:");
		propertyTypeLabel.setFont(new java.awt.Font("Comic Sans MS", Font.PLAIN, 15));
		propertyTypeLabel.setBounds(200, 260, 200, 30);
		propertyTypeLabel.setForeground(Color.WHITE);

		String [] propTypes = {"Double Storey", "Condominium", "Apartment"};
		propertyType = new JComboBox<>(propTypes);
		propertyType.setBounds(400, 260, 150, 30);

		numOfRoomsLabel = new JLabel("Number Of Rooms:");
		numOfRoomsLabel.setFont(new java.awt.Font("Comic Sans MS", Font.PLAIN, 15));
		numOfRoomsLabel.setBounds(200, 300, 200, 30);
		numOfRoomsLabel.setForeground(Color.WHITE);
				
		numOfRooms = new JTextField(10);
		numOfRooms.setBounds(400, 300, 400, 30);

		numOfBathroomsLabel = new JLabel("Number Of Bathrooms:");
		numOfBathroomsLabel.setFont(new java.awt.Font("Comic Sans MS", Font.PLAIN, 15));
		numOfBathroomsLabel.setBounds(200, 340, 200, 30);
		numOfBathroomsLabel.setForeground(Color.WHITE);
				
		numOfBathrooms = new JTextField(10);
		numOfBathrooms.setBounds(400, 340, 400, 30);
		
		contactNumLabel = new JLabel("Contact Number:");
		contactNumLabel.setFont(new java.awt.Font("Comic Sans MS", Font.PLAIN, 15));
		contactNumLabel.setBounds(200, 380, 200, 30);
		contactNumLabel.setForeground(Color.WHITE);
				
		contactNum = new JTextField(10);
		contactNum.setBounds(400, 380, 400, 30);

		propertyFacilitiesLabel = new JLabel("Property Facilities:");
		propertyFacilitiesLabel.setFont(new java.awt.Font("Comic Sans MS", Font.PLAIN, 15));
		propertyFacilitiesLabel.setBounds(200, 420, 200, 30);
		propertyFacilitiesLabel.setForeground(Color.WHITE);

		wifiFac = new JCheckBox("Wi-Fi");
		wifiFac.setBounds(400, 420, 100, 30);
		wifiFac.setBackground(new Color(0x2786c2));
		wifiFac.setForeground(Color.WHITE);

		swimmingPoolFac = new JCheckBox("Swimming Pool");
		swimmingPoolFac.setBounds(500, 420, 150, 30);
		swimmingPoolFac.setBackground(new Color(0x2786c2));
		swimmingPoolFac.setForeground(Color.WHITE);

		airCondFac = new JCheckBox("Air-Conditioned");
		airCondFac.setBounds(650, 420, 150, 30);
		airCondFac.setBackground(new Color(0x2786c2));
		airCondFac.setForeground(Color.WHITE);

		backButton = new JButton("Back");
		backButton.setBounds(20, 40, 70, 30);

		saveButton = new JButton("Save");
		saveButton.setBounds(730, 500, 70, 30);
		
		addPropertyPanel.add(backButton);	
		addPropertyPanel.add(addPropertyTitle);	
		addPropertyPanel.add(propertyLabel);
		addPropertyPanel.add(propertyName);
		addPropertyPanel.add(propertyRentalPriceLabel);
		addPropertyPanel.add(propertyRentalPrice);
		addPropertyPanel.add(propertyAddressLabel);
		addPropertyPanel.add(propertyAddress);
		addPropertyPanel.add(propertyTypeLabel);
		addPropertyPanel.add(propertyType);
		addPropertyPanel.add(propertySizeLabel);
		addPropertyPanel.add(propertySize);
		addPropertyPanel.add(numOfRoomsLabel);
		addPropertyPanel.add(numOfRooms);
		addPropertyPanel.add(numOfBathroomsLabel);
		addPropertyPanel.add(numOfBathrooms);
		addPropertyPanel.add(propertyFacilitiesLabel);
		addPropertyPanel.add(wifiFac);
		addPropertyPanel.add(swimmingPoolFac);
		addPropertyPanel.add(airCondFac);
		addPropertyPanel.add(contactNumLabel);
		addPropertyPanel.add(contactNum);
		addPropertyPanel.add(saveButton);	

		mainAddPropertyPanel.add(addPropertyPanel);
  }

	// to get property name
  public String getPropertyName(){	
		return propertyName.getText();		
	}
	
	// to set property name
	public void setPropertyName(String propName){	
		propertyName.setText(propName);		
	}

	// to get property rental price
	public double getPropertyRentalPrice(){	
		return Double.parseDouble(propertyRentalPrice.getText());	
	}

	// to set property rental price
	public void setPropertyRentalPrice(String propName){		
		propertyRentalPrice.setText(propName);		
	}

	// to get property address
	public String getPropertyAddress() {
		return propertyAddress.getText();
	}

	// to set property address
	public void setPropertyAddress(String propAddress) {
		propertyAddress.setText(propAddress);
	}

	// to get property type
	public JComboBox<String> getPropertyType() {
		return propertyType;
	}

	// to set property type
	public void setPropertyType(int propIndex) {
		propertyType.setSelectedIndex(propIndex); // 0
	}

	// to get property size
	public double getPropertySize() {
		return Double.parseDouble(propertySize.getText());
	}

	// to set property size
	public void setPropertySize(String propSize) {
		propertySize.setText(propSize);
	}

	// to get number of rooms in the property
	public int getNumOfRooms() {
		return Integer.parseInt(numOfRooms.getText());
	}

	// to set number of rooms in the property
	public void setNumOfRooms(String numOfRoom) {
		numOfRooms.setText(numOfRoom);
	}

	// to get number of bathrooms in the property
	public int getNumOfBathrooms() {
		return Integer.parseInt(numOfBathrooms.getText());
	}

	// to set number of bathrooms in the property
	public void setNumOfBathrooms(String numOfBathroom) {
		numOfBathrooms.setText(numOfBathroom);
	}

	// to check if wifi is a facility in the property
	public JCheckBox getWifiFac() {
		return wifiFac;
	}

	// to set wifi as a facility in the property
	public void setWifiFac(Boolean wifiF) {
		wifiFac.setSelected(wifiF);
	}

	// to check if swimming pool is a facility in the property
	public JCheckBox getSwimmingPoolFac() {
		return swimmingPoolFac;
	}

	// to set swimming pool as a facility in the property
	public void setSwimmingPoolFac(Boolean swimmingPoolF) {
		swimmingPoolFac.setSelected(swimmingPoolF);
	}

	// to check if air condition is a facility in the property
	public JCheckBox getAirCondFac() {
		return airCondFac;
	}

	// to set air condition as a facility in the property
	public void setAirCondFac(Boolean airCondF) {
		airCondFac.setSelected(airCondF);
	}

	// to get contact number of owner/agent
	public String getContactNum() {
		return contactNum.getText();
	}

	// to set contact number of owner/agent
	public void setContactNum(String contNum) {
		contactNum.setText(contNum);
	}

	// to add an action listener for save property button
	public void addSavePropListener(ActionListener listenForSaveButton){	
		saveButton.addActionListener(listenForSaveButton);		
	}

	// to add an action listener for back to main page button
	public void addBackFromAddPropListener(ActionListener listenForBackButton){		
		backButton.addActionListener(listenForBackButton);		
	}

	// to get add property panel
	public JPanel getAddPropertyPanel() {
    return addPropertyPanel;
  }

	// to get main add property panel
	public JPanel getMainAddPropertyPanel() {
    return mainAddPropertyPanel;
  }
}
