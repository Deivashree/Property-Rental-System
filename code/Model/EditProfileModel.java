package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*  
  Entire class written by: 
  - Lee Wei Chuen

  Purpose of the class: 
  - To process the input of the user to edit their profile
*/

public class EditProfileModel {

    String filePath = "Account.txt";
    String username = "";
    String newNickname = "";
    private static Scanner x;

    private ArrayList<String> names;

    //to get the names
    public ArrayList<String> getNames() {
        return names;
    }

    //to read the accounts in the system
    public void readUserDetailsFromCSV() throws IOException {

        // get the detail of only the property that is being clicked
        names = new ArrayList<String>();

        // read property details from database
        String line = "";
        String[] prop;

        //parsing a CSV file into BufferedReader class constructor
        BufferedReader br = new BufferedReader(new FileReader("Account.txt"));
        while ((line = br.readLine()) != null)   //returns a Boolean value
        {
            prop = line.split(",");

            names.add(prop[0] + "," + prop[1] + "," + prop[2] + "," + prop[3]);
        }
    }

    //to edit the nickname of the user
    public void editUserName(String username, String newNickname) throws IOException {

        for (int i = 0; i < names.size(); i++) {
            String namesInArray = names.get(i);
            String [] splitNames = namesInArray.split(",");
            if(splitNames[2].equals(username.toString())) {
                names.set(i, splitNames[0] + "," + newNickname + "," + splitNames[2] + "," + splitNames[3]);
            }
        }
        FileWriter writer = new FileWriter("Account.txt");
        for(String str : names) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }
}