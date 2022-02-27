package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*  
  Entire class written by: 
  -Ali Imran Bin Shahrin

  Purpose of the class: 
  - Model for the main page class mvc
*/
public class MainPageModel {
  
  private ArrayList <Property> propertyDetails;
  private ArrayList <Property> propertyFilter;

  public ArrayList<Property> getPropertyDetails() { 
    return propertyDetails;
  }

  public ArrayList<Property> getPropertyFilter() { 
    return propertyFilter;
  }

  public void getPropertyDetailsFromCSV() throws IOException,FileNotFoundException {

    propertyDetails = new ArrayList<Property>();

    // read property details from database
    String line = "";  
    String[] prop;

      //parsing a CSV file into BufferedReader class constructor  
    BufferedReader br = new BufferedReader(new FileReader("Database/PropertyDatabase.csv"));  
    while ((line = br.readLine()) != null)   //returns a Boolean value  
    {  

      String getString = line.replaceAll("\\[|\\]", "\"");
      
      prop = getString.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);   

      for(int i = 0; i < prop.length; i++) {
        
        if (prop[i].startsWith("\"")) {
          prop[i] = prop[i].replace("\"", "");
        }
      }

      ArrayList <String> fac = new ArrayList<>();
      fac.add(prop[11]);


      propertyDetails.add(new Property(Integer.parseInt(prop[0]), prop[1], Double.parseDouble(prop[2]), prop[3], Double.parseDouble(prop[4]), prop[5], Integer.parseInt(prop[6]), Integer.parseInt(prop[7]), prop[8], prop[9], prop[10], fac));
      
    }  
  } 


}
