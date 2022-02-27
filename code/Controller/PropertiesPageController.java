package Controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import Model.FirstPageModel;
import Model.PropertiesPageModel;
import View.PropertiesPageView;

import javax.swing.*;
import java.awt.*;

/*  
  Entire class written by: 
  - Nurul Izzah Binti Shahrin

  Purpose of the class: 
  - To make the property page functional by combining the methods
    from the model and view
*/
public class PropertiesPageController {
  
  private PropertiesPageModel propertyPageModel;
  private PropertiesPageView propertyPageView; 
  private FirstPageModel theFirstPageModel;
  

  public PropertiesPageController(PropertiesPageModel propertyPageModel, PropertiesPageView propertyPageView, FirstPageModel theFirstPageModel) {
    this.propertyPageModel = propertyPageModel;
    this.propertyPageView = propertyPageView;
    this.theFirstPageModel = theFirstPageModel;
  }

  //to get the property page model
  public PropertiesPageModel getPropertiesPageModel() {
    return propertyPageModel;
  }

  //to get the property page view
  public PropertiesPageView getPropertiesPageView() {
    return propertyPageView;
  }

  // to update the display for the property page 
  public void updatePropertyPageView(CardLayout cardLayout, JPanel mainPanel, EditPropertyController editPropertyController) {

    // to get the selected property details from csv
    try {
      propertyPageModel.getPropertyDetailsFromCSV(theFirstPageModel.getUser().getUsername());
    } catch (FileNotFoundException e1) {
        System.out.println("File not found.");
      e1.printStackTrace();
    } catch (IOException e1) {
        System.out.println("Error has occured.");
      e1.printStackTrace();
    }

    propertyPageView.printPropertyDetails(propertyPageModel.getPropertyDetails(), theFirstPageModel.getUser().getUsername());

    // action listener for all of the edit property button
    propertyPageView.addAllEditPropListener(e -> { 

      for(int i = 0; i < propertyPageView.getEditButton().length; i++) {
        if(propertyPageView.getEditButton()[i] == e.getSource()) {
          cardLayout.show(mainPanel, "3");
          propertyPageView.setEditButtonPosition(i);
          editPropertyController.displayEditPropertyView(propertyPageView.getEditButtonPosition());

        }
      }
      
    });

    // action listener for all of the delete property button
    propertyPageView.addAllDeletePropListener(e -> { 
      for(int i = 0; i < propertyPageView.getDeleteButton().length; i++) {
        if(propertyPageView.getDeleteButton()[i] == e.getSource()) {
 
          try {
            propertyPageModel.getPropertyDetailsFromCSV(theFirstPageModel.getUser().getUsername());
            propertyPageModel.deletePropertyFromCSV(i);
          } catch (FileNotFoundException e1) {
            System.out.println("File not found.");
            e1.printStackTrace();
          } catch (IOException e1) {
              System.out.println("Error has occured.");
            e1.printStackTrace();
          }
        }
        
      }

      updatePropertyPageView(cardLayout, mainPanel, editPropertyController);
      propertyPageView.getPropertiesPanel().revalidate();
      propertyPageView.getPropertiesPanel().repaint();
    });
  
  }

}
