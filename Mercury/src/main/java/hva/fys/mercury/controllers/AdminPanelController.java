package hva.fys.mercury.controllers;

import hva.fys.mercury.controllers.ParentControllerContext;
import hva.fys.mercury.DAO.DatabaseManager;
import hva.fys.mercury.DAO.GebruikerDAO;
import hva.fys.mercury.models.Gebruiker;
import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.ButtonType;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class AdminPanelController implements Initializable, ParentControllerContext {

    GebruikerDAO gebruikerDAO = new GebruikerDAO();

    @FXML
    private TableView gebruikerTableView;

    @FXML
    private AnchorPane gebruikerAanpassenPane;

    @FXML
    private GebruikerAanpassenPaneController gebruikerAanpassenPaneController;

    private ObservableList<Gebruiker> gebruikerList = FXCollections.observableArrayList();

    //Parent controller methods
    private void showTableView() {
        this.gebruikerAanpassenPane.setVisible(false);
        this.gebruikerTableView.setVisible(true);
    }

    @Override
    public void notifyCloseChild() {
        showTableView();
    }

    @Override
    public void notifyChildHasUpdated() {
        gebruikerTableView.refresh();
    }

    @Override
    public void displayStatusMessage(String message) {
//        statusMessage.setText(message);
    }

    @FXML
    public void handleAddItemAction() {
        gebruikerAanpassenPaneController.setParentContext(this, addItemToGebruikerList());
        showFoundLuggagePane();
    }

    @FXML
    public void handleDeleteItemAction() {
        System.out.println("Deleting item...");
        Gebruiker selectedItem = (Gebruiker) gebruikerTableView.getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Item not found");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure you want to delete this item?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                gebruikerList.removeAll(selectedItem);
                gebruikerDAO.deleteGebruikerDB(selectedItem);
            } else {
                System.out.println("Item not deleted.");
            }
        }

    }

    @FXML
    public void handleChangeItemAction() {
        System.out.println("Changed item button pressed.");

        Gebruiker selectedItem = (Gebruiker) gebruikerTableView.getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Item not found");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Changing item");

            System.out.println("this: " + this.toString());
            System.out.println("selectedItem: " + selectedItem.toString());
            System.out.println("gebruikerAanpassenPaneController: " + gebruikerAanpassenPaneController.toString());

            gebruikerAanpassenPaneController.setParentContext(this, selectedItem);

            showFoundLuggagePane();
        }
    }

    @FXML
    public void handleExitAction() {
        //figure out kico mi ta bai haci aki nan.
        //Persona mester por log out.
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("AdminPanelController.Initialize()");

        fillTable(gebruikerDAO.readAllGebruikerDB());
        gebruikerTableView.refresh();

    }

    public void fillTable(List<Gebruiker> list) {
        gebruikerList.addAll(list);

        gebruikerTableView.setItems(gebruikerList);

        for (int cnr = 0; cnr < gebruikerTableView.getColumns().size(); cnr++) {
            TableColumn tc = (TableColumn) gebruikerTableView.getColumns().get(cnr);
            String propertyName = tc.getId();

            if (propertyName != null && !propertyName.isEmpty()) {
                tc.setCellValueFactory(new PropertyValueFactory<>(propertyName));
                System.out.println("Attached collumn " + propertyName + "in tableview to matching attribute.");
            }

        }
    }

    public Gebruiker addItemToGebruikerList() { 
        String newID = "" + Calendar.YEAR + Calendar.MONTH + Calendar.DAY_OF_MONTH + gebruikerDAO.totaalGebruikers();
        System.out.println("newid: " + newID);
        Gebruiker gebruiker = new Gebruiker(Integer.parseInt(newID));
        gebruikerList.add(gebruiker);

        // associate the data collection with the table view.
        gebruikerTableView.setItems(this.gebruikerList);

        for (int cnr = 0; cnr < gebruikerTableView.getColumns().size(); cnr++) {
            TableColumn tc = (TableColumn) gebruikerTableView.getColumns().get(cnr);
            String propertyName = tc.getId();

            if (propertyName != null && !propertyName.isEmpty()) {
                tc.setCellValueFactory(new PropertyValueFactory<>(propertyName));
                System.out.println("Attached collumn " + propertyName + "in tableview to matching attribute.");
            }

        }
        return gebruiker;
    }

    public void showFoundLuggagePane() {
        this.gebruikerTableView.setVisible(false);
        this.gebruikerAanpassenPane.setVisible(true);
    }

    @Override
    public void transferObject(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
