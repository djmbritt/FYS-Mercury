package hva.fys.mercury.controllers;

/**
 * Deze class bestuurd de Admin Panel
 * 
 *
 * @author David Britt
 */
import hva.fys.mercury.DAO.GebruikerDAO;
import hva.fys.mercury.models.Gebruiker;
import java.net.URL;
import java.util.Calendar;
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

    private ParentControllerContext parentController;

    private ObservableList<Gebruiker> gebruikerList = FXCollections.observableArrayList();

    public void setParentContext(ParentControllerContext pC) {
        System.out.println("this.parentcontroller: " + pC.toString());
        this.parentController = pC;
        pC.displayStatusMessage("Handling Admin Panel");
    }

    /**
     * Deze methode zorgt ervoor dat de Tabel visible wordt en de formulier invisible.
     *
     */
    private void showTableView() {
        this.gebruikerAanpassenPane.setVisible(false);
        this.gebruikerTableView.setVisible(true);
    }
    /**
     * Deze methode zorgt ervoor dat de tabel invisible wordt en de formulier visible.
     *
     */
    public void showFoundLuggagePane() {
        this.gebruikerTableView.setVisible(false);
        this.gebruikerAanpassenPane.setVisible(true);
    }

    @Override
    public void notifyCloseChild() {
        showTableView();
    }

    @Override
    public void deleteLastElement() {
        gebruikerList.remove(gebruikerList.size() - 1);
    }

    @Override
    public void notifyChildHasUpdated() {
        gebruikerTableView.refresh();
    }

    @Override
    public void displayStatusMessage(String message) {
//        statusMessage.setText(message);
    }
    
    /**
     * Deze methode zorgt ervoor dat de gebruiker bagage kan toevoegen aan de tabel.
     */
    @FXML
    public void handleAddItemAction() {
        gebruikerAanpassenPaneController.setParentContext(this, addItemToGebruikerList());
        gebruikerTableView.refresh();
        showFoundLuggagePane();
    }
    /**
     * Deze methode zorgt ervoor dat de gebruiker bagage kan verwijderen uit de tabel.
     */
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
     /**
     * Deze methode zorgt ervoor dat de gebruiker een medewerker kan selecteren 
     * uit de tabel om aanpassingen aan gegevens te doen.
     */
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
     /**
     * Deze methode zorgt ervoor dat de gebruiker uitlogt.
     * 
     */
    @FXML
    public void handleExitAction() {
        System.out.println("Logging out");
        this.parentController.notifyCloseChild();
    }
    /**
     * Deze methode zorgt ervoor dat de fillTable methode wordt aangeroepen en 
     * de tabel wordt gerefreshed zodra de pagina wordt geïnitialiseerd.
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("AdminPanelController.Initialize()");

        fillTable(gebruikerDAO.readAllGebruikerDB());
        gebruikerTableView.refresh();

    }
    /**
     * Deze methode zorgt ervoor dat de tabel wordt gevuld.
     * @param list Lijst met gebruikers
     */
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
    /**
     * Deze methode zorgt ervoor dat nieuwe werknemers toegevoegd worden aan de
     * tabel en de gebruikerList.
     * @return Dit geeft alle informatie terug die door de gebruiker is ingevoerd.
     */
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
    /**
     * Dit zorgt ervoor dat informatie van het desbetreffende object wordt
     * verkregen in deze class.
     * @param o 
     */
    @Override
    public void transferObject(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
