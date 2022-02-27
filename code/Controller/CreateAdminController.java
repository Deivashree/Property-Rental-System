package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.CreateAdminModel;
import View.AdminMenuView;
import View.CreateAdminView;

/*  
  Entire class written by: 
  - Lee Wei Chuen

  Purpose of the class: 
  - To make the create admin page functional by combining the methods from the model and view
*/

public class CreateAdminController {
    private CreateAdminView theView;
    private CreateAdminModel theModel;

    //the constructor for create admin controller
    public CreateAdminController(CreateAdminView theView, CreateAdminModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addCreateAdminListener(new CreateAdminController.ButtonListener());
    }

    //to run the register account's method if the user click register button
    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
    
            if(e.getSource() == theView.getRegisterButton()){
                theModel.setUser(theView.getInfo());
                theModel.register();
            }
        }
    }
}
