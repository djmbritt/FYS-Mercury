/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hva.fys.mercury.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public abstract class TableHandler {

    private ObservableList<?> OBlist;

    public TableHandler() {
        OBlist = FXCollections.observableArrayList();
    }
 
    public TableView fillTable(TableView tb ) {
        for (int cnr = 0; cnr < tb.getColumns().size(); cnr++) {
            TableColumn tc = (TableColumn) tb.getColumns().get(cnr);
            String propertyName = tc.getId();
            if (propertyName != null && !propertyName.isEmpty()) {
                tc.setCellValueFactory(new PropertyValueFactory<>(propertyName));

            }
        }
        return tb;
    }
}
