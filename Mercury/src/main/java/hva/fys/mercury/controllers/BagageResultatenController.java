/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hva.fys.mercury.controllers;

import hva.fys.mercury.models.Bagage;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BagageResultatenController implements Initializable {

    @FXML
    private TableView table;

    @FXML
    private Label resultaten;
    private final ObservableList<Bagage> bagageLijst = FXCollections.observableArrayList();

    private ParentControllerContext parentController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void fillTable(List<Bagage> list) {
        bagageLijst.addAll(list);
        table.setItems(bagageLijst);
        for (int cnr = 0; cnr < table.getColumns().size(); cnr++) {
            TableColumn tc = (TableColumn) table.getColumns().get(cnr);
            String propertyName = tc.getId();

            if (propertyName != null && !propertyName.isEmpty()) {
                tc.setCellValueFactory(new PropertyValueFactory<>(propertyName));
                System.out.println("Attached collumn " + propertyName + "in tableview to matching attribute.");
            }
        }
        String resultFormat = "%d Gevonden resultaten.";
        resultaten.setText(String.format(resultFormat, bagageLijst.size()));
    }

    public void refreshTable() {
        table.refresh();
    }

    @FXML
    public void terug(ActionEvent event) {
        parentController.notifyCloseChild();

    }
}
