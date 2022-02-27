package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import javax.swing.JPanel;
import Model.CreateAdminModel;
import Model.DeleteAccountModel;
import View.AdminMenuView;
import View.CreateAdminView;
import View.DeleteAccountView;

/*  
  Entire class written by: 
  - Lee Wei Chuen

  Purpose of the class: 
  - To make the admin menu page functional by combining the methods from admin menu view 
  and the methods from main window
*/

public class AdminMenuController {
  private AdminMenuView theView;

  //the overloaded constructor for admin menu controller
  public AdminMenuController(AdminMenuView theView) {
    this.theView = theView;
  }

  //to manage which window to appear after admin choose the feature in the admin menu
  public void adminMenuHandler(CardLayout cardLayout, JPanel mainPanel, MainPageController mainPageController,
      DeleteAccountController deleteAccountController, CreateAdminView createAdminView) {

    theView.addCreateAdminListener(e -> {
      if (e.getSource() == theView.getCreateAccountButton()) {
        createAdminView.setNicknameField();
        createAdminView.setUsernameField();
        createAdminView.setPasswordField();
        createAdminView.textFieldChanger();
        cardLayout.show(mainPanel, "8");

      } else if (e.getSource() == theView.getMainPageButton()) {

        mainPageController.updatemainPageView();
        cardLayout.show(mainPanel, "4");

      } else if (e.getSource() == theView.getDeleteAccountButton()) {
        deleteAccountController.updateDeleteAccountView();
        cardLayout.show(mainPanel, "9");
      }
    });
  }
}