package Controller;

import Model.EditPropertyModel;
import Model.FirstPageModel;
import View.EditPropertyView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/*  
  Entire class written by: 
  - Deivashree A/P Selva Rajoo

  Purpose of the class: 
  - To make the edit property page functional by combining the methods
    from the model and view
*/
public class EditPropertyController {
  
  private EditPropertyModel editPropertyModel;
  private EditPropertyView editPropertyView;
  private FirstPageModel theFirstPageModel;

  public EditPropertyController(EditPropertyModel editPropertyModel, EditPropertyView editPropertyView, FirstPageModel theFirstPageModel) {
    this.editPropertyModel = editPropertyModel;
    this.editPropertyView = editPropertyView;
    this.theFirstPageModel = theFirstPageModel;
    
    // action listener for save property button
    this.editPropertyView.addSaveEdittedPropListener(e -> { 

      int propID;
      String propName;
      double propRentPrice;
      String propAddress;
      String propType;
      double propSize;
      int numofRooms;
      int numOfBathrooms;
      String contactNum;
      String propStatus;
      String wifiFac;
      String swimmingPoolFac;
      String airCondFac;
      ArrayList <String> facilities = new ArrayList<>();

      // to get the property details of the editted property from editpropertyview
      propID = editPropertyView.getPropertyID();
      propName = editPropertyView.getPropertyName();
			propRentPrice = editPropertyView.getPropertyRentalPrice();
      propAddress = editPropertyView.getPropertyAddress();
      propType = editPropertyView.getPropertyType().getSelectedItem().toString();
      propSize = editPropertyView.getPropertySize();
      numofRooms = editPropertyView.getNumOfRooms();
      numOfBathrooms = editPropertyView.getNumOfBathrooms();
      contactNum = editPropertyView.getContactNum();
      propStatus = editPropertyView.getPropertyStatus().getSelectedItem().toString();

      // to check if wifi,swimming pool and air condition is a facility in the editted property
      if (editPropertyView.getWifiFac().isSelected()) {
        wifiFac = editPropertyView.getWifiFac().getText();
        facilities.add(wifiFac);
      }
      if (editPropertyView.getSwimmingPoolFac().isSelected()) {
        swimmingPoolFac = editPropertyView.getSwimmingPoolFac().getText();
        facilities.add(swimmingPoolFac);
      }
      if (editPropertyView.getAirCondFac().isSelected()) {
        airCondFac = editPropertyView.getAirCondFac().getText();
        facilities.add(airCondFac);
      }

      // to update the editted property detail and save in csv file
			try {
        editPropertyModel.updatePropertyDetailsToCSV(propID, propName, propRentPrice, propAddress, propSize,
        propType, numofRooms, numOfBathrooms, contactNum, propStatus, facilities);
      } catch (FileNotFoundException e1) {
        System.out.println("File not found.");
        e1.printStackTrace();
      } catch (IOException e1) {
        System.out.println("Error has occured.");
        e1.printStackTrace();
      }

      // to reset the text field and check box in editpropertyview page 
      editPropertyView.setPropertyName("");
      editPropertyView.setPropertyRentalPrice("");
      editPropertyView.setPropertyAddress("");
      editPropertyView.setPropertySize("");
      editPropertyView.setPropertyType(0);
      editPropertyView.setNumOfRooms("");
      editPropertyView.setNumOfBathrooms("");
      editPropertyView.setContactNum("");
      editPropertyView.setPropertyStatus(0);
      editPropertyView.getWifiFac().setSelected(false);
      editPropertyView.getSwimmingPoolFac().setSelected(false);
      editPropertyView.getAirCondFac().setSelected(false);
    });

    // action listener for back button from edit property page
    this.editPropertyView.addBackFromEditPropListener(e -> { 
      
      // to reset the text field and check box in editpropertyview page 
      editPropertyView.setPropertyName("");
      editPropertyView.setPropertyRentalPrice("");
      editPropertyView.setPropertyAddress("");
      editPropertyView.setPropertySize("");
      editPropertyView.setPropertyType(0);
      editPropertyView.setNumOfRooms("");
      editPropertyView.setNumOfBathrooms("");
      editPropertyView.setContactNum("");
      editPropertyView.setPropertyStatus(0);
      editPropertyView.getWifiFac().setSelected(false);
      editPropertyView.getSwimmingPoolFac().setSelected(false);
      editPropertyView.getAirCondFac().setSelected(false);
    });

  }

  // to display the selected property on the edit property page
  public void displayEditPropertyView(int pos) {
    
    // to get the selected property details from csv
    try {
      editPropertyModel.getPropertyDetailsFromCSV(theFirstPageModel.getUser().getUsername());
    } catch (FileNotFoundException e2) {
      System.out.println("File not found.");
      e2.printStackTrace();
    } catch (IOException e2) {
      System.out.println("Error has occured.");
      e2.printStackTrace();
    }
    
    // to display the selected property details on edit property page
    editPropertyView.printPropertyDetails(editPropertyModel.getEditPropertyDisplayArray(), pos);  
  }

}
