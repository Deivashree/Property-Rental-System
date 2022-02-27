package Model;

import java.io.*;
import java.util.ArrayList;

/*  
  Entire class written by: 
  - Lee Wei Chuen

  Purpose of the class: 
  - To process the input to create admin account
*/

public class CreateAdminModel extends FirstPageModel{
    private User user;

    public CreateAdminModel() {
    }

    //create admin model overloaded constructor
    public CreateAdminModel (String nickname, String username, String password) {
        this.user = new User("Admin", nickname, username, password);
    }

    //to get the user
    public User getUser() {
        return this.user;
    }

    //to set the user
    public void setUser(User user) {
        this.user = user;
    }

    //to register an admin account
    @Override
    public void register() {
        String line;
        ArrayList<String> listOfUsername = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Account.txt"));
            while ((line=br.readLine()) != null) {
                String[] info = line.split(",");
                listOfUsername.add(info[2]);
            }
            br.close();
        } catch (IOException a) {
            System.out.println("No data found");;
        }

        boolean registerKey = false;
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

                pw.println("Admin" + "," + user.getNickname() + "," + user.getUsername() + "," + user.getPassword());
                pw.flush();
                pw.close();
                System.out.println("Successfully Registered");
            } catch (Exception E) {
                System.out.println("Record not saved.");
            }
        }
    }
}
