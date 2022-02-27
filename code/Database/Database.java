package Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*  
  Entire class written by: 
  - Deivashree A/P Selva Rajoo

  Purpose of the class: 
  - To read user details txt file and pass it to the model 
    to add and verify user information
*/
public class Database {

  //arraylist to store user details
  private ArrayList <String> userDetailsArray = new ArrayList<>();
  
  //create an object of Database
  private static Database instance = new Database();

  //make the constructor private so that this class cannot be instantiated
  private Database(){}

  //Get the only object available
  public static Database getInstance(){
     return instance;
  }

  // to read data from txt file and store in array
  public void getUserDetailsFromCSV() {
    String line;
    
    try {
      BufferedReader br = new BufferedReader(new FileReader("Account.txt"));
      while ((line=br.readLine()) != null) {            
        userDetailsArray.add(line);
      }

      br.close();
    } catch (IOException a) {
        System.out.println("No data found");
    }
  }

  //to get array with user details
  public ArrayList <String> getUserDetailsArray() {
    return userDetailsArray;
  }
}