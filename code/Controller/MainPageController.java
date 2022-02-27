package Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Model.EditPropertyModel;
import Model.FirstPageModel;
import Model.MainPageModel;
import Model.Property;
import Model.MainPageModel;
import View.EditPropertyView;
import View.MainPageView;
import View.MainWindow;
import View.MainPageView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*  
  Entire class written by: 
  - Ali Imran Bin Shahrin

  Purpose of the class: 
  - To act as a controller for the main page class and combine the values from the model and view.
*/

public class MainPageController {
  
  private MainPageModel mainPageModel;
  private MainPageView mainPageView; 

  

  public MainPageController(MainPageModel mainPageModel, MainPageView mainPageView) {
    this.mainPageModel = mainPageModel;
    this.mainPageView = mainPageView;

    this.mainPageView.filterButtonListener(new filterListener());
    this.mainPageView.resetListener(new resetListener());
  }



  public MainPageModel getMainPageModel() {
    return mainPageModel;
  }

  public MainPageView getMainPageView() {
    return mainPageView;
  }

  //Check if the person logged in is Owner or Agent
  public void changePropertiesPage(CardLayout cardLayout, JPanel mainPanel, EditPropertyController editPropertyController, FirstPageModel firstPageModel,PropertiesPageController propertiesPageController){
    mainPageView.propertiesPageListener(e ->{
      if(firstPageModel.getUser().getRole().equals("Owner")| firstPageModel.getUser().getRole().equals("Agent")){
        cardLayout.show(mainPanel, "1");
        propertiesPageController.updatePropertyPageView(cardLayout, mainPanel, editPropertyController);
      }else{
        mainPageView.displayErrorMessage("You cannot access this page.");
      }
      
      
    });
  }

  //Back button in the main page for admin only
  public void adminBackButtonPage(CardLayout cardLayout, JPanel mainPanel,FirstPageModel firstPageModel){
    mainPageView.adminBackButtonListener(e->{
      if(firstPageModel.getUser().getRole().equals("Admin")){
        cardLayout.show(mainPanel, "7");
      }else{
        mainPageView.displayErrorMessage("You cannot access this page.");
      }
    });
   
  }

  //update the view of the main page
  public void updatemainPageView(){

    try {
      mainPageModel.getPropertyDetailsFromCSV();
    } catch (FileNotFoundException e1) {
        System.out.println("File not found.");
      e1.printStackTrace();
    } catch (IOException e1) {
        System.out.println("Error has occured.");
      e1.printStackTrace();
    }



    mainPageView.printPropertyDetails(mainPageModel.getPropertyDetails());
  }


  class resetListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      updatemainPageView();
      mainPageView.getMainPagePanel().revalidate();
      mainPageView.getMainPagePanel().repaint();
    }
    
  }


  class filterListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub

        String propertyRentalPriceFilter = mainPageView.getPropertyRentalPriceCombo();
        String propertySizeFilter = mainPageView.getPropertySizeCombo();
        String propertyTypeFilter = mainPageView.getPropertyTypeCombo();
        String numOfRoomsFilter = mainPageView.getNumOfRoomsCombo();
        String numOfBathroomsFilter = mainPageView.getNumOfBathroomsCombo();
        String wifiCheckBoxFilter = mainPageView.getWifiCheckBox();
        String swimmingpoolCheckBoxFilter = mainPageView.getSwimmingPoolCheckBox();
        String aircondCheckBoxFilter = mainPageView.getAircondCheckBox();
        String propertyStatusFilter = mainPageView.getPropertyStatusCombo();
     
        ArrayList<String> propertyFilter = new ArrayList<>();
        propertyFilter.add(propertyRentalPriceFilter);
        propertyFilter.add(propertySizeFilter);
        propertyFilter.add(propertyTypeFilter);
        propertyFilter.add(numOfRoomsFilter);
        propertyFilter.add(numOfBathroomsFilter);
        propertyFilter.add(wifiCheckBoxFilter);
        propertyFilter.add(swimmingpoolCheckBoxFilter);
        propertyFilter.add(aircondCheckBoxFilter);
        propertyFilter.add(propertyStatusFilter);


       
        
      
        ArrayList<Property> filterProperty = new ArrayList<>();

        for(int i =0; i<mainPageModel.getPropertyDetails().size();i++){ //filter properties based on filter chosen by user

          String WiFi = "" ;
          String SwimmingPool = "";
          String AirCond = "";

          String[] faciliti = mainPageModel.getPropertyDetails().get(i).getFacilities().get(0).split(",");
          
   

          for(int j = 0;j< faciliti.length;j++){
        
            if(faciliti[j].equals("Wi-Fi")){
              WiFi = "Wi-Fi";
           
            }
            if(faciliti[j].equals("Swimming Pool")){
              SwimmingPool = "Swimming Pool";
           
            }
            if(faciliti[j].equals("Air-Conditioned")){
              AirCond = "Air-Conditioned";
            }
          }

         
         
          if(mainPageModel.getPropertyDetails().get(i).getPropertyRentalPrice() <= Double.parseDouble(propertyFilter.get(0)) &&
             mainPageModel.getPropertyDetails().get(i).getPropertySize() <= Double.parseDouble(propertyFilter.get(1)) &&
             mainPageModel.getPropertyDetails().get(i).getPropertyType().equals(propertyFilter.get(2))    &&
             mainPageModel.getPropertyDetails().get(i).getNumOfRooms() == Integer.parseInt(propertyFilter.get(3))  &&
             mainPageModel.getPropertyDetails().get(i).getNumOfBathrooms() == Integer.parseInt(propertyFilter.get(4)) &&
             (WiFi.equals(propertyFilter.get(5)) == true ||
             SwimmingPool.equals(propertyFilter.get(6)) == true ||
             AirCond.equals(propertyFilter.get(7)) == true) &&
             mainPageModel.getPropertyDetails().get(i).getPropertyStatus().equals(propertyFilter.get(8)) ){

     
            
            filterProperty.add(mainPageModel.getPropertyDetails().get(i));
            
    
              
                
          }
        }mainPageView.printPropertyDetails(filterProperty);
        mainPageView.getMainPagePanel().revalidate();
        mainPageView.getMainPagePanel().repaint();

    }


  }
  

}
