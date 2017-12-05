package hva.fys.mercury.controllers;
 
import hva.fys.mercury.DAO.BagageDAO;
import hva.fys.mercury.DAO.DatabaseManager;
import hva.fys.mercury.DAO.GebruikerDAO;
import hva.fys.mercury.MainApp;
import hva.fys.mercury.models.Bagage;
import hva.fys.mercury.models.Gebruiker;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DashboardController implements Initializable {
    private int Percentage;
    
    private static final DatabaseManager DB_MANAGER = new DatabaseManager(MainApp.DATABASE_NAME);
    @FXML
    private PieChart pieChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private Label chartLabel;
    
    @FXML
    private TableView bagageTable;

    @FXML
    private Label resultaten;
    private final ObservableList<Bagage> bagageLijst = FXCollections.observableArrayList();

    private ParentControllerContext parentController;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeLineChart();
        initializePieChart();
        initializeTable();
        this.fillTable(bagageLijst);
    }            

    public void fillTable(List<Bagage> list) {
        bagageLijst.addAll(bagageLijst);
        bagageTable.setItems(bagageLijst);
        for (int cnr = 0; cnr < bagageTable.getColumns().size(); cnr++) {
            TableColumn tc = (TableColumn) bagageTable.getColumns().get(cnr);
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
        bagageTable.refresh();
    }
    
    private void initializeTable() {
         BagageDAO.getRecentBagage(bagageLijst);
    }
    
    private void initializeLineChart() { 
        XYChart.Series gevonden = new XYChart.Series();
        gevonden.setName("Gevonden");
        gevonden.getData().add(new XYChart.Data("1", 23));
        gevonden.getData().add(new XYChart.Data("2", 11));
        gevonden.getData().add(new XYChart.Data("3", 33));
        gevonden.getData().add(new XYChart.Data("4", 44));
        
         XYChart.Series verloren = new XYChart.Series();
         verloren.setName("verloren");
        verloren.getData().add(new XYChart.Data("1", 11));
        verloren.getData().add(new XYChart.Data("2", 22));
        verloren.getData().add(new XYChart.Data("3", 33));
        verloren.getData().add(new XYChart.Data("4", 41));
        
        lineChart.getData().addAll(gevonden, verloren);
    }
    
    
    private void initializePieChart() {
        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                        new PieChart.Data("Gevonden", BagageDAO.getStatusBagageSize("Gevonden")),
                        new PieChart.Data("Verloren", BagageDAO.getStatusBagageSize("Verloren"))
                );

        pieChart.setTitle("All Time");
        pieChart.setData(pieChartData);
    }
   

}
