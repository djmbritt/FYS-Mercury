package hva.fys.mercury.controllers;

import hva.fys.mercury.DAO.BagageDAO;
import hva.fys.mercury.DAO.DatabaseManager;
import hva.fys.mercury.DAO.ReizigerDAO;
import hva.fys.mercury.MainApp;
import hva.fys.mercury.models.Bagage;
import hva.fys.mercury.models.Reiziger;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * 
 * @author José Niemel
 */
public class BagageInformatieController implements Initializable {

    @FXML
    private TextField voornaam;
    @FXML
    private TextField achternaam;
    @FXML
    private TextField adres;
    @FXML
    private TextField woonplaats;
    @FXML
    private TextField postcode;
    @FXML
    private TextField land;
    @FXML
    private TextField telefoonnummer;
    @FXML
    private TextField email;

    //bagage
    @FXML
    private TextField bagageLabel;
    @FXML
    private TextField vluchtNummer;
    @FXML
    private TextField tijdGevonden;
    @FXML
    private TextField locatieGevonden;
    @FXML
    private TextField merk;
    @FXML
    private TextField formaat;
    @FXML
    private TextField gewicht;
    @FXML
    private TextField iATA;
    @FXML
    private TextField overigeEigenschappen;
    @FXML
    private ComboBox bagageType;
    @FXML
    private ComboBox status;
    @FXML
    private ComboBox primaireKleur;
    @FXML
    private ComboBox secundaireKleur;
    @FXML
    private DatePicker datumGevonden;
    @FXML
    private HBox buttonBox;
    @FXML
    private HBox editButtonBar;
    private ParentControllerContext parentController;
    private List<TextField> textFieldList;
    private List<ComboBox> comboBoxList;

    private Bagage bagage;
    private Reiziger reiziger;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        textFieldList = new ArrayList();
        comboBoxList = new ArrayList();
        addTextFieldsToList();
        addComboBoxesToList();
        setStatusBox();
        setKleurBox();
        setBagageTypeBox();
        disableFields();

    }

    @FXML
    public void annuleer() {
        System.out.println("Annulleer pressed");
        setFields(bagage);
        buttonBox.setVisible(true);
        editButtonBar.setVisible(false);
        disableFields();

    }

    @FXML
    public void opslaan() {
        ReizigerDAO daoReiziger = new ReizigerDAO();
        BagageDAO bDAO = new BagageDAO();

        reiziger.setVoornaam(voornaam.getText());
        reiziger.setAchternaam(achternaam.getText());
        reiziger.setAdres(adres.getText());
        reiziger.setWoonplaats(woonplaats.getText());
        reiziger.setPostcode(postcode.getText());
        reiziger.setLand(land.getText());
        reiziger.setTelefoonnummer(telefoonnummer.getText());
        reiziger.setEmail(email.getText());
        bagage.setBagagelabel(bagageLabel.getText());
        bagage.setVluchtNummer(vluchtNummer.getText());
        bagage.setDatumGevonden(datumGevonden.getValue().format(DateTimeFormatter.ofPattern("d-MMM-yyyy")));
        bagage.setTijdGevonden(tijdGevonden.getText());
        bagage.setGevondenLocatie(locatieGevonden.getText());
        bagage.setBagageType(bagageType.getValue().toString());
        bagage.setBagagemerk(merk.getText());
        bagage.setPrimaireKleur(primaireKleur.getValue().toString());
        bagage.setSecundaireKleur(secundaireKleur.getValue().toString());
        bagage.setFormaat(formaat.getText());
        bagage.setGewichtInKG(gewicht.getText());
        bagage.setIATA_Code(iATA.getText());
        if (!(status.getValue()== null)) {
            bagage.setStatus(status.getValue().toString());
        }
        bagage.setOverigeEigenschappen(overigeEigenschappen.getText());

        bDAO.updateBagage(bagage);
        daoReiziger.bewerkReiziger(reiziger);
        disableFields();
        buttonBox.setVisible(true);
        editButtonBar.setVisible(false);
    }

    @FXML
    public void locationChange() {
        List<String> locaties = getLocationsFromDB();
        ChoiceDialog<String> locatieMelding = new ChoiceDialog<>(" ", locaties);
        locatieMelding.setTitle("Bagage opsturen.");
        locatieMelding.setHeaderText("Huidige Locatie: " + bagage.getIATA_Code());
        locatieMelding.setGraphic(new ImageView(this.getClass().getResource("/images/airport_icon.png").toString()));
        locatieMelding.setContentText("Stuur bagage naar: ");
        Optional<String> keuze = locatieMelding.showAndWait();
        String selectie;
        if (keuze.isPresent()) {
            selectie = keuze.get();
        }
        System.out.println("bagage wordt verstuurd naar: ");
    }

    @FXML
    public void edit() {
        buttonBox.setVisible(false);
        editButtonBar.setVisible(true);
        enableFields();
    }

    @FXML
    public void terug() {
        parentController.notifyChildHasUpdated();
    }

    public void setFields(Bagage bagage) {
        ReizigerDAO daoReiziger = new ReizigerDAO();
        reiziger = daoReiziger.getReiziger(bagage.getReizigerID());
        System.out.println("Reiiger info= " + reiziger.toString());
        this.bagage = bagage;
        BagageInfoFields();
        reizigerInfoFields(reiziger);

    }

    public void setParentContext(ParentControllerContext pC) {
        System.out.println("this.parentcontroller: " + pC.toString());
        this.parentController = pC;
    }

    private List<String> getLocationsFromDB() {
        List<String> locaties = new ArrayList<>();
        DatabaseManager dbman = new DatabaseManager(MainApp.DATABASE_NAME);
        String query = "Select LuchtHavenNaam From LuchtHaven";
        try {
            ResultSet rs = dbman.executeResultSetQuery(query);
            while (rs.next()) {
                locaties.add(rs.getString("LuchtHavenNaam"));
            }
            dbman.close();
        } catch (SQLException ex) {
            Logger.getLogger(BagageZoekenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return locaties;
    }

    private void addTextFieldsToList() {
        TextField[] textfields = {
            voornaam,
            achternaam,
            adres,
            woonplaats,
            postcode,
            land,
            telefoonnummer,
            email,
            bagageLabel,
            vluchtNummer,
            tijdGevonden,
            locatieGevonden,
            iATA,
            merk,
            formaat,
            gewicht,
            overigeEigenschappen
        };
        textFieldList.addAll(Arrays.asList(textfields));
    }

    private void addComboBoxesToList() {
        ComboBox[] comboboxes = {bagageType, status, primaireKleur, secundaireKleur};
        comboBoxList.addAll(Arrays.asList(comboboxes));
    }

    private void disableFields() {
        for (ComboBox combobox : comboBoxList) {
            combobox.setDisable(true);
        }
        for (TextField textField : textFieldList) {
            textField.setDisable(true);
        }
        datumGevonden.setDisable(true);
    }

    private void enableFields() {
        for (ComboBox combobox : comboBoxList) {
            combobox.setDisable(false);
        }
        for (TextField textField : textFieldList) {
            textField.setDisable(false);
        }

        datumGevonden.setDisable(false);
    }

    private void BagageInfoFields() {
        bagageLabel.setText(bagage.getBagagelabel());
        vluchtNummer.setText(bagage.getVluchtNummer());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy", Locale.ENGLISH);
        String dateString = bagage.getDatumGevonden();
        datumGevonden.setValue(LocalDate.parse(dateString, formatter));
        tijdGevonden.setText(bagage.getTijdGevonden());
        locatieGevonden.setText(bagage.getGevondenLocatie());
        merk.setText(bagage.getBagagemerk());
        formaat.setText(bagage.getFormaat());
        gewicht.setText(bagage.getGewichtInKG());
        iATA.setText(bagage.getIATA_Code());
        bagageType.getSelectionModel().select(bagage.getBagageType());
        primaireKleur.getSelectionModel().select(bagage.getPrimaireKleur());
        secundaireKleur.getSelectionModel().select(bagage.getSecundaireKleur());
        overigeEigenschappen.setText(bagage.getOverigeEigenschappen());

    }

    private void setStatusBox() {
        status.getItems().addAll(
                "Vermist",
                "Gevonden",
                "Afgehandeld"
        );
    }

    private void setKleurBox() {
        DatabaseManager dbman = new DatabaseManager(MainApp.DATABASE_NAME);
        List<String> kleuren = new ArrayList();
        kleuren.add("");
        String query = "Select * From Kleuren";
        try {
            ResultSet rs = dbman.executeResultSetQuery(query);
            while (rs.next()) {
                kleuren.add(rs.getString("Engels"));
            }

            dbman.close();
        } catch (SQLException ex) {
            Logger.getLogger(BagageZoekenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        primaireKleur.getItems().addAll(kleuren);
        primaireKleur.getSelectionModel().selectFirst();
        secundaireKleur.getItems().addAll(kleuren);
        secundaireKleur.getSelectionModel().selectFirst();
    }

    private void setBagageTypeBox() {
        DatabaseManager dbman = new DatabaseManager(MainApp.DATABASE_NAME);
        List<String> types = new ArrayList();
        types.add("");
        String query = "Select * From BagageTypes";
        try {
            ResultSet rs = dbman.executeResultSetQuery(query);
            while (rs.next()) {
                types.add(rs.getString("Engels"));
            }

            dbman.close();
        } catch (SQLException ex) {
            Logger.getLogger(BagageZoekenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bagageType.getItems().addAll(types);
        bagageType.getSelectionModel().selectFirst();
    }

    private void reizigerInfoFields(Reiziger reiziger) {
        voornaam.setText(reiziger.getVoornaam());
        achternaam.setText(reiziger.getAchternaam());
        adres.setText(reiziger.getAdres());
        woonplaats.setText(reiziger.getWoonplaats());
        postcode.setText(reiziger.getPostcode());
        land.setText(reiziger.getLand());
        telefoonnummer.setText(reiziger.getTelefoonnummer());
        email.setText(reiziger.getEmail());
    }
}
