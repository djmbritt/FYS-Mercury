package hva.fys.mercury.controllers;

import hva.fys.mercury.DAO.BagageDAO;
import hva.fys.mercury.models.Bagage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DashboardController implements Initializable {

    @FXML
    private Button refresh;
    @FXML
    private PieChart pieChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    TableView mostRecentTable;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillTable();
        initializePieChart();
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
        BagageDAO dao = new BagageDAO();
        int gevonden = dao.getStatusBagageSize("gevonden");
        int verloren = dao.getStatusBagageSize("verloren");
        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                        new PieChart.Data("Gevonden", gevonden),
                        new PieChart.Data("Verloren", verloren)
                );

        pieChart.setTitle("All Time");
        pieChart.setData(pieChartData);
    }

    @FXML
    private void refresh() {
        fillTable();
    }

    private void fillTable() {
        BagageDAO dao = new BagageDAO();
        List<Bagage> dbBagageLijst = dao.getRecentBagage();
        ObservableList<Bagage> meestRecenteBagage = FXCollections.observableArrayList();
        meestRecenteBagage.addAll(dbBagageLijst);
        System.out.println("ObservableList size =" + meestRecenteBagage.size());
        mostRecentTable.setItems(meestRecenteBagage);
        for (int cnr = 0; cnr < mostRecentTable.getColumns().size(); cnr++) {
            TableColumn tc = (TableColumn) mostRecentTable.getColumns().get(cnr);
            String propertyName = tc.getId();

            if (propertyName != null && !propertyName.isEmpty()) {
                tc.setCellValueFactory(new PropertyValueFactory<>(propertyName));
                System.out.println("Attached collumn " + propertyName + "in tableview to matching attribute.");
            }
        }
        mostRecentTable.refresh();
    }

}
