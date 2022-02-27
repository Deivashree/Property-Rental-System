package View;

import Model.Property;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*  
  Entire class written by: 
  - Deivashree A/P Selva Rajoo

  Purpose of the class: 
  - To display the edit property page for owner/agent to edit property 
*/
public class EditPropertyView {

	private int propertyID;
	private int editButtonPosition;

	private JPanel mainEditPropertyPanel;
	private JPanel editPropertyPanel;
	private JLabel editPropertyTitle;
	private JLabel propertyLabel;
	private JTextField propertyName;
	private JLabel propertyRentalPriceLabel;
	private JTextField propertyRentalPrice;
	private JLabel propertyAddressLabel;
	private JTextField propertyAddress;
	private JLabel propertyTypeLabel;
	private JComboBox<String> propertyType;
	private JLabel propertySizeLabel;
	private JTextField propertySize;
	private JLabel numOfRoomsLabel;
	private JTextField numOfRooms;
	private JLabel numOfBathroomsLabel;
	private JTextField numOfBathrooms;
	private JLabel propertyFacilitiesLabel;
	private JCheckBox wifiFac;
	private JCheckBox swimmingPoolFac;
	private JCheckBox airCondFac;
	private JLabel contactNumLabel;
	private JTextField contactNum;
	private JLabel propertyStatusLabel;
	private JComboBox<String> propertyStatus;
	private JButton saveButton;
	private JButton backButton;

	// to initialize all the view components in the edit property page
	public EditPropertyView() {

		mainEditPropertyPanel = new JPanel(null);
		mainEditPropertyPanel.setBounds(0, 0, 1000, 700);
		mainEditPropertyPanel.setBackground(new Color(0x2a6b96));

		editPropertyPanel = new JPanel(null);
		editPropertyPanel.setBounds(20, 20, 945, 620);
		editPropertyPanel.setBackground(new Color(0x2786c2));

		editPropertyTitle = new JLabel("Edit Property Page");
		editPropertyTitle.setFont(new java.awt.Font("Comic Sans MS", Font.PLAIN, 30));
		editPropertyTitle.setBounds(350, 20, 300, 50);
		editPropertyTitle.setForeground(Color.WHITE);

		propertyLabel = new JLabel("Property Name:");
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

		String[] propTypes = { "Double Storey", "Condominium", "Apartment" };
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

		propertyStatusLabel = new JLabel("Property Status: ");
		propertyStatusLabel.setFont(new java.awt.Font("Comic Sans MS", Font.PLAIN, 15));
		propertyStatusLabel.setBounds(200, 460, 200, 30);
		propertyStatusLabel.setForeground(Color.WHITE);

		String[] propStatus = { "Active", "Inactive" };
		propertyStatus = new JComboBox<>(propStatus);
		propertyStatus.setBounds(400, 460, 150, 30);

		backButton = new JButton("Back");
		backButton.setBounds(20, 40, 70, 30);

		saveButton = new JButton("Save");
		saveButton.setBounds(730, 500, 70, 30);

		editPropertyPanel.add(backButton);
		editPropertyPanel.add(editPropertyTitle);
		editPropertyPanel.add(propertyLabel);
		editPropertyPanel.add(propertyName);
		editPropertyPanel.add(propertyRentalPriceLabel);
		editPropertyPanel.add(propertyRentalPrice);
		editPropertyPanel.add(propertyAddressLabel);
		editPropertyPanel.add(propertyAddress);
		editPropertyPanel.add(propertyTypeLabel);
		editPropertyPanel.add(propertyType);
		editPropertyPanel.add(propertySizeLabel);
		editPropertyPanel.add(propertySize);
		editPropertyPanel.add(numOfRoomsLabel);
		editPropertyPanel.add(numOfRooms);
		editPropertyPanel.add(numOfBathroomsLabel);
		editPropertyPanel.add(numOfBathrooms);
		editPropertyPanel.add(propertyFacilitiesLabel);
		editPropertyPanel.add(wifiFac);
		editPropertyPanel.add(swimmingPoolFac);
		editPropertyPanel.add(airCondFac);
		editPropertyPanel.add(contactNumLabel);
		editPropertyPanel.add(contactNum);
		editPropertyPanel.add(propertyStatusLabel);
		editPropertyPanel.add(propertyStatus);
		editPropertyPanel.add(saveButton);

		mainEditPropertyPanel.add(editPropertyPanel);

	}

	// to display the selected property to edit
	public void printPropertyDetails(ArrayList<Property> propertyDetails, int pos) {

		// to obtain the property details from array based on the selected property
		propertyID = propertyDetails.get(pos).getPropertyID();
		String propName = propertyDetails.get(pos).getPropertyName();
		Double propRentPrice = propertyDetails.get(pos).getPropertyRentalPrice();
		String propAddress = propertyDetails.get(pos).getPropertyAddress();
		String propType = propertyDetails.get(pos).getPropertyType();
		Double propSize = propertyDetails.get(pos).getPropertySize();
		Integer numofRoom = propertyDetails.get(pos).getNumOfRooms();
		Integer numOfBathroom = propertyDetails.get(pos).getNumOfBathrooms();
		String contNum = propertyDetails.get(pos).getContactNum();
		String propStatus = propertyDetails.get(pos).getPropertyStatus();
		ArrayList<String> fac = new ArrayList<>();

		// to add facilities in fac arraylist
		for (String myInt : propertyDetails.get(pos).getFacilities()) {

			String[] sp = myInt.split(", ");

			for (int i = 0; i < sp.length; i++) {
				fac.add(sp[i]);
			}

		}

		// to identify which facility needs to be displayed as checked in the checkbox
		for (int i = 0; i < fac.size(); i++) {

			if (fac.get(i).contains(wifiFac.getText())) {
				wifiFac.setSelected(true);
			}
			if (fac.get(i).contains(swimmingPoolFac.getText())) {
				swimmingPoolFac.setSelected(true);
			}
			if (fac.get(i).contains(airCondFac.getText())) {
				airCondFac.setSelected(true);
			}
		}

		// to set the property details on the textfield and checkbox
		propertyName.setText(propName);
		propertyRentalPrice.setText(propRentPrice.toString());
		propertyAddress.setText(propAddress);
		propertyType.setSelectedItem(propType.toString());
		propertySize.setText(propSize.toString());
		numOfRooms.setText(numofRoom.toString());
		numOfBathrooms.setText(numOfBathroom.toString());
		contactNum.setText(contNum);
		propertyStatus.setSelectedItem(propStatus.toString());

	}

	// to set the position of the edit button which is selected by owner/agent
	public void setEditButtonPosition(int pos) {
		editButtonPosition = pos;
	}

	// to get the position of the edit button which is selected by owner/agent
	public int getEditButtonPosition() {
		return editButtonPosition;
	}

	// to get property ID
	public int getPropertyID() {
		return propertyID;
	}

	// to set property ID
	public void setPropertyID(int propID) {
		propertyID = propID;
	}

	// to get property name
	public String getPropertyName() {
		return propertyName.getText();
	}

	// to set property name
	public void setPropertyName(String propName) {
		propertyName.setText(propName);
	}

	// to get property rental price
	public double getPropertyRentalPrice() {
		return Double.parseDouble(propertyRentalPrice.getText());
	}

	// to set property rental price
	public void setPropertyRentalPrice(String propName) {
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

	// to get selected property type
	public JComboBox<String> getPropertyType() {
		return propertyType;
	}

	// to set property type
	public void setPropertyType(int propIndex) {
		propertyType.setSelectedIndex(propIndex);
	}

	// to get property size
	public double getPropertySize() {
		return Double.parseDouble(propertySize.getText());
	}

	// to set property size
	public void setPropertySize(String propSize) {
		propertySize.setText(propSize);
	}

	public int getNumOfRooms() {
		return Integer.parseInt(numOfRooms.getText());
	}

	// to set number of rooms in a property
	public void setNumOfRooms(String numOfRoom) {
		numOfRooms.setText(numOfRoom);
	}

	// to get number of bathrooms in a property
	public int getNumOfBathrooms() {
		return Integer.parseInt(numOfBathrooms.getText());
	}

	// to set number of bathrooms in a property
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

	// to get selected property status
	public JComboBox<String> getPropertyStatus() {
		return propertyStatus;
	}

	// to set property status
	public void setPropertyStatus(int propIndex) {
		propertyStatus.setSelectedIndex(propIndex);
	}

	// to get edit property panel
	public JPanel getEditPropertyPanel() {
		return editPropertyPanel;
	}

	// to get main edit property panel
	public JPanel getMainEditPropertyPanel() {
		return mainEditPropertyPanel;
	}

	// to add an action listener for save property button
	public void addSaveEdittedPropListener(ActionListener listenForSaveButton) {
		saveButton.addActionListener(listenForSaveButton);
	}

	// to add an action listener for back to add property page button
	public void addBackFromEditPropListener(ActionListener listenForBackButton) {
		backButton.addActionListener(listenForBackButton);
	}

}
