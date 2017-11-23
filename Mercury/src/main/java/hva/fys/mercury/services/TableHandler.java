/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hva.fys.mercury.services;

import hva.fys.mercury.models.Bagage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Eigenaar
 */
public class TableHandler {
   
    
    private final ObservableList<Bagage> tableList = FXCollections.observableArrayList();
   
    public void fillTable(TableView table) {
         Bagage bag = new Bagage();
         
         bag.setRegistratieID("123");
         bag.setDatumGevonden("27 november");
         bag.setTijdGevonden("15:00");
        
        table.setItems(this.tableList);
        
        for (int cnr = 0; cnr < table.getColumns().size(); cnr++){
            TableColumn tc = (TableColumn) table.getColumns().get(cnr);
            String propertyName = tc.getId();
            if (propertyName != null && !propertyName.isEmpty()){
                tc.setCellValueFactory(new PropertyValueFactory<>(propertyName));
                System.out.println("Attached column '" + propertyName + "' in tableview to matching attribute");
            }
            
        }
    }
    
}
