package Model;

import java.util.ArrayList;

/*  
  Entire class written by: 
  - Deivashree A/P Selva Rajoo

  Purpose of the class: 
  - To create a property class which contains the attributes of a property

  - To obtain the property information using getters and setters 
    which are created for every attribute
*/
public class Property {
  
  private int propertyID; 
  private String propertyName;
  private double propertyRentalPrice; 
  private String propertyAddress;
  private double propertySize; 
  private String propertyType;
  private int numOfRooms;
  private int numOfBathrooms;
  private ArrayList<String> facilities; 
  private String contactNum; // contactNum - to display the owner/agent's contact number
  private String propertyStatus; // property status - property is either active or inactive
  private String username; // username - to identify the owner/agent of the property

  // constructor with all the property attributes
  public Property(int propertyID, String propertyName, double propertyRentalPrice, String propertyAddress, double propertySize,
  String propertyType, int numOfRooms, int numOfBathrooms, String contactNum, String propertyStatus, String username, ArrayList <String> facilities) {

    this.propertyID = propertyID;
    this.propertyName = propertyName;
    this.propertyRentalPrice = propertyRentalPrice;
    this.propertyAddress = propertyAddress;
    this.propertySize = propertySize;
    this.propertyType = propertyType;
    this.numOfRooms = numOfRooms;
    this.numOfBathrooms = numOfBathrooms;
    this.contactNum = contactNum;
    this.propertyStatus = propertyStatus;
    this.username = username;
    this.facilities = facilities;
    
  }
  
  // get property ID
  public int getPropertyID() {
    return propertyID;
  }

  // set property ID
  public void setPropertyID(int propertyID) {
    this.propertyID = propertyID;
  }

  // get property name 
  public String getPropertyName() {
    return propertyName;
  }

  // set property name
  public void setPropertyName(String propertyName) {
    this.propertyName = propertyName;
  }

  // get property rental price
  public double getPropertyRentalPrice() {
    return propertyRentalPrice;
  }

  // set property rental price
  public void setPropertyRentalPrice(double propertyRentalPrice) {
    this.propertyRentalPrice = propertyRentalPrice;
  }

  // get property status
  public String getPropertyStatus() {
    return propertyStatus;
  }

  // set property status
  public void setPropertyStatus(String propertyStatus) {
    this.propertyStatus = propertyStatus;
  }

  // get property facilities
  public ArrayList<String> getFacilities() {
    return facilities;
  }

  // set property facilities
  public void setFacilities(ArrayList<String> facilities) {
    this.facilities = facilities;
  }

  // get number of bathrooms in a property
  public int getNumOfBathrooms() {
    return numOfBathrooms;
  }

  // set number of bathrooms in a property
  public void setNumOfBathrooms(int numOfBathrooms) {
    this.numOfBathrooms = numOfBathrooms;
  }

  // get number of rooms in a property
  public int getNumOfRooms() {
    return numOfRooms;
  }

  // set number of rooms in a property
  public void setNumOfRooms(int numOfRooms) {
    this.numOfRooms = numOfRooms;
  }

  // get property type
  public String getPropertyType() {
    return propertyType;
  }

  // set property type
  public void setPropertyType(String propertyType) {
    this.propertyType = propertyType;
  }

  // get property size
  public double getPropertySize() {
    return propertySize;
  }
  
  // set property size
  public void setPropertySize(double propertySize) {
    this.propertySize = propertySize;
  }

  // get property address
  public String getPropertyAddress() {
    return propertyAddress;
  }

  // set property address
  public void setPropertyAddress(String propertyAddress) {
    this.propertyAddress = propertyAddress;
  }

  // get contact number of property owner/agent
  public String getContactNum() {
    return contactNum;
  }

  // set contact number of property owner/agent
  public void setContactNum(String contactNum) {
    this.contactNum = contactNum;
  }

  // get username
  public String getUsername() {
    return username;
  }

  // set username
  public void setUsername(String username) {
    this.username = username;
  }
 
  // in order to display the property details
  @Override
  public String toString() {
    return "Property: " + propertyID + "," + propertyName + "," + propertyRentalPrice + "," + propertyAddress
    + "," + propertySize + "," + propertyType + "," + numOfRooms + "," + numOfBathrooms
    + "," + contactNum + "," + propertyStatus + "," + username + "," + facilities;
  }

}
