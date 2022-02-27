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
  - Nurul Izzah Binti Shahrin

  Purpose of the class: 
  - To allow agent/owner to edit the property in the system
*/
public class PropertiesPageModel {

  private ArrayList <Property> propertyDetails;
  private ArrayList <Property> propertyDetailsDisplay;

  // to get the property details of all the properties
  public ArrayList<Property> getPropertyDetails() { 
    return propertyDetails;
  }

  // to get the property details of all the properties for display
  public ArrayList<Property> getPropertyDetailsDisplay() { 
    return propertyDetailsDisplay;
  }

  // to read property details from csv file and store in array
  public void getPropertyDetailsFromCSV(String username) throws IOException, FileNotFoundException {

    propertyDetails = new ArrayList<Property>();
    propertyDetailsDisplay = new ArrayList<Property>();

    String line = "";  
    String[] prop;

    //parsing a CSV file into BufferedReader class constructor  
    BufferedReader br = new BufferedReader(new FileReader("Database/PropertyDatabase.csv"));  
    while ((line = br.readLine()) != null)   //returns a Boolean value  
    {  

      String getString = line.replaceAll("\\[|\\]","\"");

      prop = getString.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);   // use comma as separator 
      
      for(int i = 0; i < prop.length; i++) {
        if (prop[i].startsWith("\"")) {
          prop[i] = prop[i].replace("\"", "");
        }
      }
      
      ArrayList <String> fac = new ArrayList<>();
      fac.add(prop[11]);

      if(username.equals(prop[10])) {
        propertyDetailsDisplay.add(new Property(Integer.parseInt(prop[0]), prop[1], Double.parseDouble(prop[2]), prop[3], Double.parseDouble(prop[4]), prop[5], Integer.parseInt(prop[6]), Integer.parseInt(prop[7]), prop[8], prop[9], prop[10], fac));
      }

      propertyDetails.add(new Property(Integer.parseInt(prop[0]), prop[1], Double.parseDouble(prop[2]), prop[3], Double.parseDouble(prop[4]), prop[5], Integer.parseInt(prop[6]), Integer.parseInt(prop[7]), prop[8], prop[9], prop[10], fac));
    }
    br.close();
  }

  // to delete property details from csv file
  public void deletePropertyFromCSV(int rowNumber) throws IOException, FileNotFoundException {

    String propName = propertyDetailsDisplay.get(rowNumber).getPropertyName();

    for (int i = 0; i < propertyDetails.size(); i++) {
      if (propertyDetails.get(i).getPropertyName().equals(propName.toString())) {
        propertyDetails.remove(i);
      }
    }

    FileWriter writer = new FileWriter("Database/PropertyDatabase.csv"); 

    int i = 1;
    for(Property property : propertyDetails) {

      writer.write((i) + "," + property.getPropertyName() + "," + property.getPropertyRentalPrice() + "," + '"' + property.getPropertyAddress() + '"'
      + "," + property.getPropertySize() + "," + property.getPropertyType() + "," + property.getNumOfRooms() + "," + property.getNumOfBathrooms()
      + "," + property.getContactNum() + "," + property.getPropertyStatus() + "," + property.getUsername() + "," + property.getFacilities() + System.lineSeparator());

      i++;
    }

    writer.close();
  }
}
