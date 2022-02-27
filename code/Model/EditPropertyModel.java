package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*  
  Entire class written by: 
  - Deivashree A/P Selva Rajoo

  Purpose of the class: 
  - To allow agent/owner to edit the property in the system
*/
public class EditPropertyModel {
  
  // to store the property details of all properties
  private ArrayList <Property> editPropertyArray = new ArrayList<Property>();

  // to store the property details of the current logged in owner/agent
  private ArrayList <Property> editPropertyDisplay = new ArrayList<Property>();

  // to get the property details of all properties
  public ArrayList<Property> getEditPropertyDetails() { 
    return editPropertyArray;
  }

  // to get the property details of the current logged in owner/agent
  public ArrayList<Property> getEditPropertyDisplayArray() { 
    return editPropertyDisplay;
  }

  //to update the editted property details to csv file
  public void updatePropertyDetailsToCSV(int propID, String propName, double propRentPrice, String propAddress,
  double propSize, String propType, int numofRooms, int numOfBathrooms, String contactNum, String propStatus, ArrayList <String> facilities) throws IOException,FileNotFoundException {

    // to set the editted property details to the array
    for (int i = 0; i < editPropertyArray.size(); i++) {
      if(editPropertyArray.get(i).getPropertyID() == propID) {

        editPropertyArray.get(i).setPropertyName(propName);
        editPropertyArray.get(i).setPropertyRentalPrice(propRentPrice);
        editPropertyArray.get(i).setPropertyAddress(propAddress);
        editPropertyArray.get(i).setPropertySize(propSize);
        editPropertyArray.get(i).setPropertyType(propType);
        editPropertyArray.get(i).setNumOfRooms(numofRooms);
        editPropertyArray.get(i).setNumOfBathrooms(numOfBathrooms);
        editPropertyArray.get(i).setContactNum(contactNum);
        editPropertyArray.get(i).setPropertyStatus(propStatus);
        editPropertyArray.get(i).setFacilities(facilities);

      }
    }

    FileWriter writer = new FileWriter("Database/PropertyDatabase.csv"); 

    // to write the all the property details into csv file
    for(Property property : editPropertyArray) {

      writer.write(property.getPropertyID() + "," + property.getPropertyName() + "," + property.getPropertyRentalPrice() + "," + '"' + property.getPropertyAddress() + '"'
      + "," + property.getPropertySize() + "," + property.getPropertyType() + "," + property.getNumOfRooms() + "," + property.getNumOfBathrooms()
      + "," + property.getContactNum() + "," + property.getPropertyStatus() + "," + property.getUsername() + "," + property.getFacilities() + System.lineSeparator());

    }

    writer.close();
  }


  // to read property details from csv file and store in array
  public void getPropertyDetailsFromCSV(String username) throws IOException,FileNotFoundException {

    // to store the property details of all properties
    editPropertyArray = new ArrayList<Property>();
    // to store the property details of the current logged in owner/agent
    editPropertyDisplay = new ArrayList<Property>();

    String line = "";  
    String[] prop;

    // read property details from database
    BufferedReader br = new BufferedReader(new FileReader("Database/PropertyDatabase.csv"));  
    while ((line = br.readLine()) != null)  
    {  
      // to replace the brackets in csv file to double quote
      String getString = line.replaceAll("\\[|\\]", "\"");

      // to split the csv file based on comma or double quote
      prop = getString.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);  

      // to remove double quote
      for(int i = 0; i < prop.length; i++) {
        if (prop[i].startsWith("\"")) {
          prop[i] = prop[i].replace("\"", "");
        }
      }

      // to add facilities into an arraylist and pass it to the array
      ArrayList <String> fac = new ArrayList<>();
      fac.add(prop[11]);

      // to add the property details of the current logged in owner/agent into the array
      if(username.equals(prop[10])) {
        editPropertyDisplay.add(new Property(Integer.parseInt(prop[0]), prop[1], Double.parseDouble(prop[2]), prop[3], Double.parseDouble(prop[4]), prop[5], Integer.parseInt(prop[6]), Integer.parseInt(prop[7]), prop[8], prop[9], prop[10], fac));
      }
      
      // to add all property details into the array
      editPropertyArray.add(new Property(Integer.parseInt(prop[0]), prop[1], Double.parseDouble(prop[2]), prop[3], Double.parseDouble(prop[4]), prop[5], Integer.parseInt(prop[6]), Integer.parseInt(prop[7]), prop[8], prop[9], prop[10], fac));
    }  
    br.close();
  }

}
