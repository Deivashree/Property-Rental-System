package Model;

/*  
  Entire class written by: 
  - Lee Wei Chuen
   
  Purpose of the class: 
  - To store the user's attribute   
*/

public class User {
    private String role;
    private String nickname;
    private String username;
    private String password;

    public User() {

    }

    public User(String role, String nickname, String username, String password) {
        this.role = role;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public String getNickname() {
        return nickname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return this.role + ", " + this.nickname + ", " + this.username + ", " + this.password;
    }

    @Override
    public String toString() {
        return this.role + ", " + this.nickname + ", " + this.username + ", " + this.password;
    }

}
