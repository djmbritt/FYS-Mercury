package hva.fys.mercury.controllers;

import hva.fys.mercury.DAO.BagageDAO;
import hva.fys.mercury.models.Bagage;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class die de dashboard beheert
 *
 * @author José Niemel
 */
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
    @FXML
    Label chartLabel;

    ResourceBundle RsBundle = ResourceBundle.getBundle("UIResources", LoginController.locale);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillTable();
        initializePieChart();
        initializeLineChart();
    }

    /**
     * Zet informatie van de database in de LineChart
     */
    private void initializeLineChart() {
        BagageDAO bDAO = new BagageDAO();
        List<LocalDate> gevondenDates = bDAO.getdatesByStatus("gevonden");
        List<LocalDate> verlorenDates = bDAO.getdatesByStatus("verloren");
        int amountPerDay = 1;
        int previous;
        XYChart.Series gevonden = new XYChart.Series();
        gevonden.setName(RsBundle.getString("dashboard.15"));
        for (int i = 0; i < gevondenDates.size(); i++) {
            previous = i - 1;
            if ((gevondenDates.get(i).equals(previous))) {
                amountPerDay += 2;
            }
            gevonden.getData().add(new XYChart.Data(gevondenDates.get(i).toString(), amountPerDay));
            amountPerDay++;
        }
        XYChart.Series verloren = new XYChart.Series();
        verloren.setName(RsBundle.getString("dashboard.16"));
        for (int i = 0; i < verlorenDates.size(); i++) {
            previous = i - 1;
            if ((verlorenDates.get(i).equals(previous))) {
                amountPerDay += 2;
            }
            verloren.getData().add(new XYChart.Data(verlorenDates.get(i).toString(), amountPerDay));
            amountPerDay++;
        }

        lineChart.getData().addAll(gevonden, verloren);
    }

    /**
     * Zet informatie van de database in de Pie
     */
    private void initializePieChart() {
        BagageDAO dao = new BagageDAO();
        int gevonden = dao.getStatusBagageSize("gevonden");
        int verloren = dao.getStatusBagageSize("verloren");
        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                        new PieChart.Data(RsBundle.getString("dashboard.15"), gevonden),
                        new PieChart.Data(RsBundle.getString("dashboard.16"), verloren)
                );
        pieChart.setLegendSide(Side.LEFT);
        pieChart.setTitle("All Time");
        pieChart.setData(pieChartData);
        berekenPercentage(verloren, gevonden);

    }

    /**
     * Berekent percentage van het aantal verloren bagage
     * @param verloren aantal verloren bagagestukken
     * @param gevonden aantal gevonden bagagestukken
     */
    private void berekenPercentage(int verloren, int gevonden) {
        final int MAXIMUM_PERCENTAGE = 100;
        String format = RsBundle.getString("dashboard.17");
        double totaal = verloren + gevonden;
        double percentage = gevonden / totaal * MAXIMUM_PERCENTAGE;
        String text = String.format(format, percentage);
        System.out.println(text);
        chartLabel.setText(text);
    }

    /**
     * vernieuwd de informatie in de meestRecentetabel
     */
    @FXML
    private void refresh() {
        fillTable();
    }
 /**
     * Zet informatie van de database in de Tabel
     */
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
