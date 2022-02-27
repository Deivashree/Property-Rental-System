package Controller;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Model.FirstPageModel;
import View.AdminMenuView;
import View.FirstPageView;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

/*  
  Entire class written by: 
  - Lee Wei Chuen

  Purpose of the class: 
  - To make the first page functional by combining the methods from the model and view
*/

public class FirstPageController {
    
    private FirstPageModel model;
    private FirstPageView view;

    //the overloaded constructor for first page controller
    public FirstPageController (FirstPageModel model, FirstPageView view) {
        this.model = model;
        this.view = view;
    }

    //to listen to the user's action and decide which code to be executed
    public void loginAndRegisterHandler(CardLayout cardLayout, JPanel mainPanel, MainPageController mainPageController) {

        view.addFirstPageListener(e -> {

        if(e.getSource() == view.getLoginButton()) {
            model.setUser(view.getInfo());

            if (model.login()) {
                //Go to main view property page
                cardLayout.show(mainPanel, "4");
                mainPageController.updatemainPageView();

                if(model.getUser().getRole().equals("Admin")) {
                    cardLayout.show(mainPanel, "7");
                }
            }
            else {
                view.displayMessage("Please enter correct username or password");
            }
        } else if(e.getSource() == view.getRegisterButton()){
            if(view.getInfo().getRole() != "Admin") {
                model.setUser(view.getInfo());
                model.register();
                if(!model.getRegisterKey()) {
                    cardLayout.show(mainPanel, "4");
                    mainPageController.updatemainPageView();
                }
            } else {
                view.displayMessage("Registration fail");
            }
        }

        });
    } 
}