package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Model.DeleteAccountModel;
import View.AdminMenuView;
import View.DeleteAccountView;

/*  
  Entire class written by: 
  - Lee Wei Chuen

  Purpose of the class: 
  - To make the delete account page functional by combining the methods from the model and view
*/

public class DeleteAccountController {
    private DeleteAccountView theView;
    private DeleteAccountModel theModel;

    //the constuctor for delete account controller
    public DeleteAccountController(DeleteAccountView theView, DeleteAccountModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addDeleteAdminListener(new DeleteAccountController.ButtonListener());
    }

    // to refresh the delete account page
    public void updateDeleteAccountView() {
        theModel.readAccounts();
        theView.displayDeleteAccountView(theModel.getUsersArrayList());
    }

    //to delete account if the admin choose accounts and click the delete button
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource() == theView.getDeleteButton()) {
                try {
                    theModel.deleteAccount(theView);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                updateDeleteAccountView();
                theView.getDeleteAccountPanel().revalidate();
                theView.getDeleteAccountPanel().repaint();
                
            }
        }
    }
}
