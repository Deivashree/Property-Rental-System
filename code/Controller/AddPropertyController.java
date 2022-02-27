package Controller;

import Model.AddPropertyModel;
import Model.FirstPageModel;
import Model.Property;
import View.AddPropertyView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/*  
  Entire class written by: 
  - Deivashree A/P Selva Rajoo

  Purpose of the class: 
  - To make the add property page functional by combining the methods
    from the model and view
*/
public class AddPropertyController {
  
  private AddPropertyModel addPropertyModel;
  private AddPropertyView addPropertyView;
  private FirstPageModel theFirstPageModel;

  public AddPropertyController(AddPropertyModel addPropertyModel, AddPropertyView addPropertyView, FirstPageModel theFirstPageModel) {
    this.addPropertyModel = addPropertyModel;
    this.addPropertyView = addPropertyView;
    this.theFirstPageModel = theFirstPageModel;

    // action listener for save property button
    this.addPropertyView.addSavePropListener(e -> {  

      // to get the add property details from csv file
      try {
        addPropertyModel.getPropertyDetailsFromCSV();
      } catch (FileNotFoundException e2) {
        System.out.println("File not found.");
        e2.printStackTrace();
      } catch (IOException e2) {
        System.out.println("Error has occured.");
        e2.printStackTrace();
      }

      int propID; 
      String propName;
      double propRentPrice;
      String propAddress;
      String propType;
      double propSize;
      int numofRooms;
      int numOfBathrooms;
      String contactNum;
      String propStatus = "Active";
      String username;
      String wifiFac;
      String swimmingPoolFac;
      String airCondFac;
      ArrayList <String> facilities = new ArrayList<>();

      // to get the property details of the added property from addpropertyview
      propID = addPropertyModel.getAddPropertyDetails().size() + 1;
      propName = addPropertyView.getPropertyName();
			propRentPrice = addPropertyView.getPropertyRentalPrice();
      propAddress = addPropertyView.getPropertyAddress();
      propType = addPropertyView.getPropertyType().getSelectedItem().toString();
      propSize = addPropertyView.getPropertySize();
      numofRooms = addPropertyView.getNumOfRooms();
      numOfBathrooms = addPropertyView.getNumOfBathrooms();
      contactNum = addPropertyView.getContactNum();
      username = theFirstPageModel.getUser().getUsername();
    
      // to check if wifi,swimming pool and air condition is a facility in the added property
      if (addPropertyView.getWifiFac().isSelected()) {
        wifiFac = addPropertyView.getWifiFac().getText();
        facilities.add(wifiFac);
      }
      if (addPropertyView.getSwimmingPoolFac().isSelected()) {
        swimmingPoolFac = addPropertyView.getSwimmingPoolFac().getText();
        facilities.add(swimmingPoolFac);
      }
      if (addPropertyView.getAirCondFac().isSelected()) {
        airCondFac = addPropertyView.getAirCondFac().getText();
        facilities.add(airCondFac);
      }

      // to add the property into the array
			addPropertyModel.addProperty(new Property(propID, propName, propRentPrice, propAddress, propSize,
      propType, numofRooms, numOfBathrooms, contactNum, propStatus, username, facilities));
      
      // to save the added property detail into csv file
      try {
        addPropertyModel.savePropertyDetailsToCSV();
      } catch (IOException e1) {
        System.out.println("Error has occured.");
        e1.printStackTrace();
      }

      // to reset the text field and check box in addpropertyview page 
      addPropertyView.setPropertyName("");
      addPropertyView.setPropertyRentalPrice("");
      addPropertyView.setPropertyAddress("");
      addPropertyView.setPropertySize("");
      addPropertyView.setPropertyType(0);
      addPropertyView.setNumOfRooms("");
      addPropertyView.setNumOfBathrooms("");
      addPropertyView.setContactNum("");
      addPropertyView.getWifiFac().setSelected(false);
      addPropertyView.getSwimmingPoolFac().setSelected(false);
      addPropertyView.getAirCondFac().setSelected(false);

    });

  }

}
