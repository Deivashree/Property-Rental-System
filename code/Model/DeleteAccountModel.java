package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import View.DeleteAccountView;

import java.io.FileWriter;

/*  
  Entire class written by: 
  - Lee Wei Chuen

  Purpose of the class: 
  - To process the input from admin to delete account
*/

public class DeleteAccountModel {
    private ArrayList<User> usersArrayList;
    private ArrayList<String> names;

    //to get the users arraylist
    public ArrayList<User> getUsersArrayList() {
        return usersArrayList;
    }

    //to read all the accounts in the system into a users arraylist
    public void readAccounts() {
        usersArrayList = new ArrayList<>();
        String line;
        boolean access = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Account.txt"));
            while ((line = br.readLine()) != null) {
                if (!access) {
                    access = true;
                    continue;
                } else {
                    String[] info = line.split(",");
                    User user = new User(info[0], info[1], info[2], info[3]);
                    usersArrayList.add(user);
                }
            }
            br.close();
        } catch (IOException a) {
            System.out.println("No data found");
            ;
        }
    }

    //to search the account that wanted to be deleted and delete it
    public void deleteAccount(DeleteAccountView theView) throws IOException {

        for (int i = theView.getCheckboxesArrayList().size() - 1; i >= 0; i--) {

            if (theView.getCheckboxesArrayList().get(i).isSelected()) {
                names = new ArrayList<String>();

                // read property details from database
                String line = "";
                String[] prop;
                int counter = -1;
                //parsing a CSV file into BufferedReader class constructor
                BufferedReader br = new BufferedReader(new FileReader("Account.txt"));
                while ((line = br.readLine()) != null)   //returns a Boolean value
                {
                    prop = line.split(",");
                    if (counter != i) {
                        names.add(prop[0] + "," + prop[1] + "," + prop[2] + "," + prop[3]);
                    }
                    counter++;
                }

                FileWriter writer = new FileWriter("Account.txt");
                for (String str : names) {
                    writer.write(str + System.lineSeparator());
                }
                writer.close();
            }


        }
    }
}

