package hva.fys.mercury.DAO;

import hva.fys.mercury.MainApp;
import hva.fys.mercury.models.Bagage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/*
* @author: David Britt
 */
public class BagageDAO {

    private static final DatabaseManager DB_MANAGER = new DatabaseManager(MainApp.DATABASE_NAME);
    private static final int MINIMUM_EDITED_COLUMN = 1;
    private static int columnsBewerkt;

    public static boolean registreerBagage(Bagage bagage) {

        final String INSERT_QUERY
                = "INSERT INTO Bagage( `BagageRegistratieNummer`, `DateFound`, `TimeFound`, `BrandMerk`, `BagageType`, `BagageLabel`, "
                + "`LocatieGevonden`, `MainColor`, `SecondColor`, `Formaat`, `Gewicht`, `OverigeEigenschappen`, `Status`) "
                + "VALUES ('%d', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')";

        String insertString = String.format(
                INSERT_QUERY,
                bagage.getRegistratieID(),
                bagage.getDatumGevonden(),
                bagage.getTijdGevonden(),
                bagage.getBagagemerk(),
                bagage.getBagageType(),
                bagage.getBagagelabel(),
                bagage.getGevondenLocatie(),
                bagage.getPrimaireKleur(),
                bagage.getSecundaireKleur(),
                bagage.getFormaat(),
                bagage.getGewichtInKG(),
                bagage.getOverigeEigenschappen(),
                bagage.getStatus()
        );

        columnsBewerkt = DB_MANAGER.executeUpdateQuery(insertString);
        DB_MANAGER.close();
        return (columnsBewerkt >= MINIMUM_EDITED_COLUMN);
    }

    public static boolean updateBagage(Bagage bagage) {
        final String UPDATE_QUERY
                = "UPDATE Bagage "
                + "SET DateFound='%s', TimeFound='%s', BrandMerk='%s', BagageType='%s', BagageLabel='%s', "
                + "LocatieGevonden='%s', MainColor='%s', SecondColor='%s', "
                + "Formaat='%s', Gewicht='%s', OverigeEigenschappen='%s', Status='%s'"
                + "WHERE BagageRegistratieNummer='%d';";

        String updateString = String.format(
                UPDATE_QUERY,
                bagage.getDatumGevonden(),
                bagage.getTijdGevonden(),
                bagage.getBagagemerk(),
                bagage.getBagageType(),
                bagage.getBagagelabel(),
                bagage.getGevondenLocatie(),
                bagage.getPrimaireKleur(),
                bagage.getSecundaireKleur(),
                bagage.getFormaat(),
                bagage.getGewichtInKG(),
                bagage.getOverigeEigenschappen(),
                bagage.getStatus(),
                bagage.getRegistratieID()
        );

        columnsBewerkt = DB_MANAGER.executeUpdateQuery(updateString);
        DB_MANAGER.close();
        return (columnsBewerkt >= MINIMUM_EDITED_COLUMN);
    }

    public static void getAllBagage(ObservableList<Bagage> bagageList) {
        try {

            System.out.println("Getting all bagage from database");
            String query = "SELECT * FROM Bagage;";
            ResultSet results = DB_MANAGER.executeResultSetQuery(query);

            while (results.next()) {
                Bagage bagage = new Bagage();
                bagage.setRegistratieID(results.getInt("BagageRegistratieNummer"));
                bagage.setDatumGevonden(results.getString("DateFound"));
                bagage.setTijdGevonden(results.getString("TimeFound"));
                bagage.setBagagemerk(results.getString("BrandMerk"));
                bagage.setBagageType(results.getString("BagageType"));
                bagage.setBagagelabel(results.getString("BagageLabel"));
                bagage.setGevondenLocatie(results.getString("LocatieGevonden"));
                bagage.setPrimaireKleur(results.getString("MainColor"));
                bagage.setSecundaireKleur(results.getString("SecondColor"));
                bagage.setFormaat(results.getString("Grootte"));
                bagage.setGewichtInKG(results.getString("Gewicht"));
                bagage.setOverigeEigenschappen(results.getString("OverigeEigenschappen"));
                bagage.setStatus(results.getString("Status"));
                bagage.setReizigerID(results.getString("Reiziger"));
                bagage.setIATA_Code(results.getString("IATA_Code"));

                bagageList.add(bagage);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void getRecentBagage(ObservableList<Bagage> bagageList) {
        try {

            System.out.println("Getting all bagage from database");
            String query = "SELECT * FROM Bagage MAX(DateFound);";
            ResultSet results = DB_MANAGER.executeResultSetQuery(query);

            while (results.next()) {
                Bagage bagage = new Bagage();
                bagage.setRegistratieID(results.getInt("BagageRegistratieNummer"));
                bagage.setDatumGevonden(results.getString("DateFound"));
                bagage.setTijdGevonden(results.getString("TimeFound"));
                bagage.setBagagemerk(results.getString("BrandMerk"));
                bagage.setBagageType(results.getString("BagageType"));
                bagage.setBagagelabel(results.getString("BagageLabel"));
                bagage.setGevondenLocatie(results.getString("LocatieGevonden"));
                bagage.setPrimaireKleur(results.getString("MainColor"));
                bagage.setSecundaireKleur(results.getString("SecondColor"));
                bagage.setFormaat(results.getString("Grootte"));
                bagage.setGewichtInKG(results.getString("Gewicht"));
                bagage.setOverigeEigenschappen(results.getString("OverigeEigenschappen"));
                bagage.setStatus(results.getString("Status"));
                bagage.setReizigerID(results.getString("Reiziger"));
                bagage.setIATA_Code(results.getString("IATA_Code"));

                bagageList.add(bagage);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void getBagage(ObservableList<Bagage> bagageList, String kolomNaam) {
        try {

            String query = String.format("SELECT %s FROM Bagage;", kolomNaam);
            ResultSet results = DB_MANAGER.executeResultSetQuery(query);

            while (results.next()) {
                Bagage bagage = new Bagage();

                bagage.setRegistratieID(results.getInt("BagageRegistratieNummer"));
                bagage.setDatumGevonden(results.getString("DateFound"));
                bagage.setTijdGevonden(results.getString("TimeFound"));
                bagage.setBagagemerk(results.getString("BrandMerk"));
                bagage.setBagageType(results.getString("BagageType"));
                bagage.setBagagelabel(results.getString("BagageLabel"));
                bagage.setGevondenLocatie(results.getString("LocatieGevonden"));
                bagage.setPrimaireKleur(results.getString("MainColor"));
                bagage.setSecundaireKleur(results.getString("SecondColor"));
                bagage.setFormaat(results.getString("Grootte"));
                bagage.setGewichtInKG(results.getString("Gewicht"));
                bagage.setOverigeEigenschappen(results.getString("OverigeEigenschappen"));
//                bagage.setStatus(results.getString("Status"));
                bagage.setReizigerID(results.getString("Reiziger"));
                bagage.setIATA_Code(results.getString("IATA_Code"));

                bagageList.add(bagage);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static List<Bagage> zoekBagage(List<StringProperty> zoekParameters) {
        List<Bagage> bagageLijst = new ArrayList<>();
        String query = "SELECT * FROM bagage where";
        String paramFormat = " %s= '%s' AND";

        int laatsteParameter = zoekParameters.size() - 1;
        for (int i = 0; i < zoekParameters.size(); i++) {

            System.out.println(i + " max= " + laatsteParameter);
            StringProperty parameter = zoekParameters.get(i);
            if (i == laatsteParameter) {
                paramFormat = " %s= '%s';";
            }
            query = query + String.format(paramFormat, zoekParameters.get(i).getName(), zoekParameters.get(i).getValue());

        }
        try {
            ResultSet results = DB_MANAGER.executeResultSetQuery(query);
            while (results.next()) {
                Bagage bagage = new Bagage();
                bagage.setRegistratieID(results.getInt("BagageRegistratieNummer"));
                bagage.setDatumGevonden(results.getString("DateFound"));
                bagage.setTijdGevonden(results.getString("TimeFound"));
                bagage.setBagagemerk(results.getString("BrandMerk"));
                bagage.setBagageType(results.getString("BagageType"));
                bagage.setBagagelabel(results.getString("BagageLabel"));
                bagage.setVluchtNummer(results.getString("ArrivedWithFlight"));
                bagage.setGevondenLocatie(results.getString("LocatieGevonden"));
                bagage.setPrimaireKleur(results.getString("MainColor"));
                bagage.setSecundaireKleur(results.getString("SecondColor"));
                bagage.setFormaat(results.getString("Formaat"));
                bagage.setGewichtInKG(results.getString("Gewicht"));
                bagage.setOverigeEigenschappen(results.getString("OverigeEigenschappen"));
//                bagage.setStatus(results.getString("Status"));
                bagage.setReizigerID(results.getString("Reiziger"));
                bagage.setIATA_Code(results.getString("IATA_Code"));

                bagageLijst.add(bagage);
            }
        } catch (SQLException sql) {
            System.out.println(sql);
        }
        return bagageLijst;
    }

    public static int getStatusBagageSize(String statusString) {
       String query = String.format("SELECT COUNT(Status) FROM Bagage WHERE Status='%s'", statusString);
       return Integer.parseInt(DB_MANAGER.executeStringQuery(query));
    }
    public static int getAllStatusBagageSize() {
       String query = String.format("SELECT COUNT(Status) FROM Bagage");
       return Integer.parseInt(DB_MANAGER.executeStringQuery(query));
    }
}
