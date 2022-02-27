package Model;

import java.io.*;
import java.util.ArrayList;

import Database.Database;

public class FirstPageModel {

/*  
  Entire class written by: 
  - Lee Wei Chuen
   
  Purpose of the class: 
  - To process the input to register account for tenant, owner and property agent.
  - To process the input to log in account for admin, tenant, owner and property agent.
*/

    private Database database = Database.getInstance();
    protected User user;
    private boolean registerKey;

    public FirstPageModel() {
    }

    //the overloaded constructor for first page model
    public FirstPageModel (String role, String nickname, String username, String password) {
        this.user = new User(role, nickname, username, password);
    }

    //to get the user
    public User getUser() {
        return this.user;
    }

    //to set the user
    public void setUser(User user) {
        this.user = user;
    }

    //to check if the user able or disable to log in
    public boolean login() {

        database.getUserDetailsFromCSV();

        for (int i = 0; i < database.getUserDetailsArray().size(); i++) {
            String userInfo = database.getUserDetailsArray().get(i);

            String [] info = userInfo.split(",");

            if ((info[0].equals(user.getRole())) && (info[1].equals(user.getNickname())) &&
                    (info[2].equals(user.getUsername())) && (info[3].equals(user.getPassword()))) {
                return true;
            }
        }
        return false; 
    }

    //to check if the user able or disable to register
    public void register() {
        database.getUserDetailsFromCSV();
        ArrayList<String> listOfUsername = new ArrayList<>();

        for (int i = 0; i < database.getUserDetailsArray().size(); i++) {
            String userInfo = database.getUserDetailsArray().get(i);
            String [] info = userInfo.split(",");
            listOfUsername.add(info[2]);
        }

        registerKey = false;
        for(int i = 0; i<listOfUsername.size(); i++) {
            if(user.getUsername().equals(listOfUsername.get(i))) {
                registerKey = true;
            }
        }

        if(!registerKey) {
            try {
                FileWriter fw = new FileWriter("Account.txt",  true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                pw.println(user.getRole() + "," + user.getNickname() + "," + user.getUsername() + "," + user.getPassword());
                pw.flush();
                pw.close();
                System.out.println("Successfully Registered");
            } catch (Exception E) {
                System.out.println("Record not saved.");
            }
        }

    }

    //to get the register key
    public Boolean getRegisterKey() {
        return registerKey;
    }
}