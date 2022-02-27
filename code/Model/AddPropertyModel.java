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
  - To allow agent/owner to add properties into the system 
*/
public class AddPropertyModel {

  // arraylist to store all property details
  private ArrayList <Property> addPropertyArray = new ArrayList<Property>();

  // to add property into the addPropertyArray
  public void addProperty(Property property) {
    addPropertyArray.add(property);  
  }

  // to get details from addPropertyArray
  public ArrayList<Property> getAddPropertyDetails() { 
    return addPropertyArray;
  }

  // to write property details to csv file
  public void savePropertyDetailsToCSV() throws IOException,FileNotFoundException {
    
    FileWriter writer = new FileWriter("Database/PropertyDatabase.csv"); 

    // to write each of the property details from array to csv file
    for(Property property : addPropertyArray) {

      writer.write(property.getPropertyID() + "," + property.getPropertyName() + "," + property.getPropertyRentalPrice() + "," + '"' + property.getPropertyAddress() + '"'
      + "," + property.getPropertySize() + "," + property.getPropertyType() + "," + property.getNumOfRooms() + "," + property.getNumOfBathrooms()
      + "," + property.getContactNum() + "," + property.getPropertyStatus() + "," + property.getUsername() + "," + property.getFacilities() + System.lineSeparator());

    }

    writer.close();

  }

  // to read property details from csv file and store in addPropertyArray
  public void getPropertyDetailsFromCSV() throws IOException,FileNotFoundException {

    addPropertyArray = new ArrayList<Property>();

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

      addPropertyArray.add(new Property(Integer.parseInt(prop[0]), prop[1], Double.parseDouble(prop[2]), prop[3], Double.parseDouble(prop[4]), prop[5], Integer.parseInt(prop[6]), Integer.parseInt(prop[7]), prop[8], prop[9], prop[10], fac));
    }  

    br.close();
  }

}
