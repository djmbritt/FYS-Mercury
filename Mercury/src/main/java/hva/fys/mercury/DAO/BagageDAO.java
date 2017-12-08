package hva.fys.mercury.DAO;

import hva.fys.mercury.MainApp;
import hva.fys.mercury.models.Bagage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 * De class zorgt ervoor dat er informatie uit de bagage tabel uit de database
 * wordt gehaald en stuurt die informatie in een Bagage model naar de view.
 *
 * @author David Britt
 * @author José Niemel
 */
public class BagageDAO {

    private final DatabaseManager DB_MANAGER;
    private final int MINIMUM_EDITED_COLUMN = 1;
    private int columnsBewerkt;

    public BagageDAO() {
        this.DB_MANAGER = new DatabaseManager(MainApp.DATABASE_NAME);
    }

    /**
     * slaat nieuwe informatie op in de bagageTabel van de database
     *
     * @param bagage een bagage model met informatie
     * @return een boolean met de waarde 'true' als de informatie succesvol is
     * opgeslagen in de database en 'false' als het niet is gelukt om de
     * informatie op te slaan
     */
    public boolean registreerBagage(Bagage bagage) {

        final String INSERT_QUERY = "INSERT INTO bagage ( DateFound, TimeFound, BagageType, BrandMerk, "
                + " BagageLabel, LocatieGevonden, MainColor, SecondColor, Formaat, Gewicht, OverigeEigenschappen, Status ) "
                + "values ( '%s', '%s','%s', '%s', '%s', '%s', "
                + "'%s', '%s', '%s', '%s', '%s', '%s' "
                + " );";

        String insertString = String.format(
                INSERT_QUERY,
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
        System.out.println("bewerkte collumns: " + columnsBewerkt);
        return (columnsBewerkt >= MINIMUM_EDITED_COLUMN);
    }

    /**
     * zorgt ervoor dat bestaande informatie in de database wordt gewijzigd
     *
     * @param bagage een bagage model met informatie
     *
     * @return een boolean met de waarde 'true' als de informatie succesvol is
     * opgeslagen in de database en 'false' als het niet is gelukt om de
     * informatie op te slaan
     */
    public boolean updateBagage(Bagage bagage) {
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

    /**
     * haalt aan de hand van de ingevoerde status een lijst met data uit de
     * database
     *
     * @param status status van de bagage (keuze uit: "gevonden" of "verloren")
     * @return een List van LocalDate met daarin de data van de bagagestukken
     */
    public List<LocalDate> getdatesByStatus(String status) {
        List<LocalDate> dates = new ArrayList();
        String query = String.format("select datefound from Bagage where status='%s';", status);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy", Locale.ENGLISH);
        try (ResultSet results = DB_MANAGER.executeResultSetQuery(query)) {

            while (results.next()) {
                LocalDate date = LocalDate.parse(results.getString("datefound"), formatter);
                dates.add(date);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BagageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dates;
    }

    /**
     * geeft een lijst van de 30 meest recente aangemelde bagagestukken terug
     *
     * @return een List van Bagage met daarom de 30 mmeest recent aangemelde
     * bagagestukken
     */
    public List<Bagage> getRecentBagage() {
        List<Bagage> bagageList = new ArrayList();
        try {

            System.out.println("Getting all bagage from database");
            String query = "SELECT * FROM Bagage ORDER BY BagageRegistratieNummer  LIMIT 30;";
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
                bagage.setFormaat(results.getString("Formaat"));
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
        return bagageList;
    }

    /**
     * Haalt ,door middel van het van bagagenummer, bagage informatie in de
     * database;
     *
     * @param BagageNummer registratienummer van de bagage
     * @return een Bagage model met daarin de informatie uit de database
     */
    public Bagage getBagage(int BagageNummer) {
        Bagage bagage = new Bagage();

        try {

            String query = String.format("SELECT * FROM Bagage WHERE BagageRegistratieNummer='%d';", BagageNummer);
            ResultSet results = DB_MANAGER.executeResultSetQuery(query);

            while (results.next()) {

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
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return bagage;
    }

    /**
     * Zoekt met behulp van parameters informatie in de database en geeft de
     * zoekresultaten terug in een List van Bagage objecten
     *
     * @param zoekParameters een lijst van StringProperty met daarin de
     * parameters
     * @return een lijst van bagage met daarin informatie
     */
    public List<Bagage> zoekBagage(List<StringProperty> zoekParameters) {
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

    /**
     * Haalt op basis van de ingevoerde status het aantal uit de database (vb:
     * indien de status 'gevonden' is haalt hij het aantal gevonden
     * bagagestukken uit de database)
     *
     * @param status status van de bagage (keuze uit: "gevonden" of "verloren")
     * @return een integer met daarin het aantal bagagestukken
     */
    public int getStatusBagageSize(String status) {
        String query = String.format("SELECT COUNT(Status) FROM Bagage WHERE Status='%s'", status);
        int i = Integer.parseInt(DB_MANAGER.executeStringQuery(query));
        System.out.println("i");
        return i;
    }

}
