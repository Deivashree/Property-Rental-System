package View;

import javax.swing.*;
import java.awt.*;

import Model.AddPropertyModel;
import Model.CreateAdminModel;
import Model.DeleteAccountModel;
import Model.EditProfileModel;
import Model.EditPropertyModel;
import Model.FirstPageModel;
import Model.MainPageModel;
import Model.PropertiesPageModel;
import Controller.AddPropertyController;
import Controller.AdminMenuController;
import Controller.CreateAdminController;
import Controller.DeleteAccountController;
import Controller.EditProfileController;
import Controller.EditPropertyController;
import Controller.FirstPageController;
import Controller.MainPageController;
import Controller.PropertiesPageController;

public class MainWindow {

  FirstPageModel theFirstPageModel;
  FirstPageView theFirstPageView;
  FirstPageController theFirstPageController;

  MainPageView mainPageView;
  MainPageModel mainPageModel;
  MainPageController mainPageController;

  EditProfileView editProfileView;
  EditProfileModel editProfileModel;
  EditProfileController editProfileController;

  PropertiesPageView propertyPageView;
  PropertiesPageModel propertyPageModel;
  PropertiesPageController propertiesPageController;

  AddPropertyView addPropertyView;
  AddPropertyModel addPropertyModel;
  AddPropertyController addPropertyController;

  EditPropertyView editPropertyView;
  EditPropertyModel editPropertyModel;
  EditPropertyController editPropertyController;

  AdminMenuView adminMenuView;
  AdminMenuController adminMenuController;

  CreateAdminView createAdminView;
  CreateAdminModel createAdminModel;
  CreateAdminController createAdminController;

  DeleteAccountView deleteAccountView;
  DeleteAccountModel deleteAccountModel;
  DeleteAccountController deleteAccountController;

  private JFrame mainFrame = new JFrame();
  private JPanel mainPanel = new JPanel();
  private CardLayout cardLayout = new CardLayout();

  public MainWindow() {

    theFirstPageModel = new FirstPageModel();
    theFirstPageView = new FirstPageView();
    theFirstPageController = new FirstPageController(theFirstPageModel, theFirstPageView);

    mainPageView = new MainPageView();
    mainPageModel = new MainPageModel();
    mainPageController = new MainPageController(mainPageModel, mainPageView);

    editProfileView = new EditProfileView();
    editProfileModel = new EditProfileModel();
    editProfileController = new EditProfileController(editProfileView, editProfileModel, theFirstPageModel);

    propertyPageView = new PropertiesPageView();
    propertyPageModel = new PropertiesPageModel();
    propertiesPageController = new PropertiesPageController(propertyPageModel, propertyPageView, theFirstPageModel);

    addPropertyView = new AddPropertyView();
    addPropertyModel = new AddPropertyModel();
    addPropertyController = new AddPropertyController(addPropertyModel, addPropertyView, theFirstPageModel);

    editPropertyView = new EditPropertyView();
    editPropertyModel = new EditPropertyModel();
    editPropertyController = new EditPropertyController(editPropertyModel, editPropertyView, theFirstPageModel);

    adminMenuView = new AdminMenuView();
    adminMenuController = new AdminMenuController(adminMenuView);

    createAdminView = new CreateAdminView();
    createAdminModel = new CreateAdminModel();
    createAdminController = new CreateAdminController(createAdminView, createAdminModel);

    deleteAccountView = new DeleteAccountView();
    deleteAccountModel = new DeleteAccountModel();
    deleteAccountController = new DeleteAccountController(deleteAccountView, deleteAccountModel);

    mainPanel.setLayout(cardLayout);
    mainPanel.add(propertyPageView.getPropertiesPanel(), "1");
    mainPanel.add(addPropertyView.getMainAddPropertyPanel(), "2");
    mainPanel.add(editPropertyView.getMainEditPropertyPanel(), "3");
    mainPanel.add(mainPageView.getMainPagePanel(), "4");
    mainPanel.add(theFirstPageView.getFirstPagePanel(), "5");
    mainPanel.add(editProfileView.getEditProfilePanel(), "6");
    mainPanel.add(adminMenuView.getAdminMenuPanel(), "7");
    mainPanel.add(createAdminView.getCreateAdminPanel(), "8");
    mainPanel.add(deleteAccountView.getDeleteAccountPanel(), "9");

    cardLayout.show(mainPanel, "5");

    theFirstPageController.loginAndRegisterHandler(cardLayout, mainPanel, mainPageController);
    adminMenuController.adminMenuHandler(cardLayout, mainPanel, mainPageController, deleteAccountController, 
    createAdminView);

    mainPageView.editProfileListener(e -> {
      cardLayout.show(mainPanel, "6");
    });

    mainPageView.logoutListener(e -> {
      theFirstPageView.setNicknameField();
      theFirstPageView.setUsernameField();
      theFirstPageView.setPasswordField();
      theFirstPageView.textFieldChanger();
      cardLayout.show(mainPanel, "5");
    });

    propertyPageView.addAddPropListener(e -> {
      cardLayout.show(mainPanel, "2");
    });

    propertyPageView.addBackListener(e -> {
      mainPageController.updatemainPageView();
      cardLayout.show(mainPanel, "4");
    });

    addPropertyView.addBackFromAddPropListener(e -> {
      propertiesPageController.updatePropertyPageView(cardLayout, mainPanel, editPropertyController);
      cardLayout.show(mainPanel, "1");
    });

    editPropertyView.addBackFromEditPropListener(e -> {
      propertiesPageController.updatePropertyPageView(cardLayout, mainPanel, editPropertyController);
      cardLayout.show(mainPanel, "1");
    });

    createAdminView.addCreateAdminListener(e -> {
      if (e.getSource() == createAdminView.getBackButton()) {
        cardLayout.show(mainPanel, "7");
      }
    });

    deleteAccountView.addDeleteAdminListener(e -> {
      if (e.getSource() == deleteAccountView.getBackButton()) {
        cardLayout.show(mainPanel, "7");
      }
    });

    editProfileView.backButtonListener(e -> {
      if (e.getSource() == editProfileView.getBackButton()) {
        editProfileView.setUsername();
        cardLayout.show(mainPanel, "4");
      }
    });

    mainPageController.adminBackButtonPage(cardLayout, mainPanel, theFirstPageModel);
    mainPageController.changePropertiesPage(cardLayout, mainPanel, editPropertyController, theFirstPageModel,
        propertiesPageController);

    mainFrame.setLayout(new BorderLayout());
    mainFrame.add(mainPanel);
    mainFrame.setTitle("Cyberjaya Online Rental Management System");
    ImageIcon img = new ImageIcon("Assets/Cyberjaya Logo.png");
    mainFrame.setIconImage(img.getImage());
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setSize(1000, 700);
    mainFrame.setResizable(false);
    mainFrame.setVisible(true);
  }

}
