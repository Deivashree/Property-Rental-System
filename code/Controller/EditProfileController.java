package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Model.EditProfileModel;
import Model.FirstPageModel;
import View.EditProfileView;

/*  
  Entire class written by: 
  - Lee Wei Chuen

  Purpose of the class: 
  - To make the edit profile page functional by combining the methods from the model and view
*/

public class EditProfileController{
    
    private EditProfileView theView;
    private EditProfileModel theModel;
    private FirstPageModel theFirstPageModel;

    //the overloaded constructor for edit profile controller 
    public EditProfileController(EditProfileView theView, EditProfileModel theModel, FirstPageModel theFirstPageModel){
        this.theView = theView;
        this.theModel = theModel;
        this.theFirstPageModel = theFirstPageModel;
        this.theView.editUserNameListener(new EditListener());
    }

    //to change the nickname if the user click edit nickname button
    class EditListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String newUsername = theView.getUsername();
            try {
                theModel.readUserDetailsFromCSV();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            try {
                theModel.editUserName(theFirstPageModel.getUser().getUsername(), newUsername);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            theView.setUsername();
            theView.textFieldChanger();
        }
    }
}