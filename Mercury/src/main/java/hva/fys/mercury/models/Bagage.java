package hva.fys.mercury.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

public class Bagage {

    private List<StringProperty> properties;
    private StringProperty registratieID;
    private StringProperty datumGevonden;
    private StringProperty tijdGevonden;
    private StringProperty bagageType;
    private StringProperty merk;
    private StringProperty vluchtNummer;
    private StringProperty bagagelabel;
    private StringProperty gevondenLocatie;
    private StringProperty primaireKleur;
    private StringProperty secundaireKleur;
    private StringProperty formaat;
    private StringProperty gewichtInKG;
    private StringProperty overigeEigenschappen;
    private BooleanProperty status;

    public Bagage() {
        registratieID = new SimpleStringProperty(this, "registratieID");
        datumGevonden = new SimpleStringProperty(this, "datumGevonden");
        tijdGevonden = new SimpleStringProperty(this, "tijdGevonden");
        bagageType = new SimpleStringProperty(this, "bagageType");

        merk = new SimpleStringProperty(this, "merk");
        vluchtNummer = new SimpleStringProperty(this, "vluchtNummer");
        bagagelabel = new SimpleStringProperty(this, "bagagelabel");
        gevondenLocatie = new SimpleStringProperty(this, "gevondenLocatie");

        primaireKleur = new SimpleStringProperty(this, "primaireKleur");
        secundaireKleur = new SimpleStringProperty(this, "secundaireKleur");
        formaat = new SimpleStringProperty(this, "formaat");
        gewichtInKG = new SimpleStringProperty(this, "gewichtInKG");
        overigeEigenschappen = new SimpleStringProperty(this, "overigeEigenschappen");
        properties = new ArrayList<>();
        addAllToProperties();
    }

    public String getRegistratieID() {
        return registratieID.get();
    }

    public void setRegistratieID(String registratieID) {
        this.registratieID.setValue(registratieID);
    }

    public String getDatumGevonden() {
        return datumGevonden.get();
    }

    public void setDatumGevonden(String datumGevonden) {
        this.datumGevonden.setValue(datumGevonden);
    }

    public String getTijdGevonden() {
        return tijdGevonden.get();
    }

    public void setTijdGevonden(String tijdGevonden) {
        this.tijdGevonden.setValue(tijdGevonden);
    }

    public String getBagageType() {
        return bagageType.get();
    }

    public void setBagageType(String bagageType) {
        this.bagageType.setValue(bagageType);
    }

    public String getMerk() {
        return merk.get();
    }

    public void setMerk(String merk) {
        this.merk.setValue(merk);
    }

    public String getVluchtNummer() {
        return vluchtNummer.get();
    }

    public void setVluchtNummer(String vluchtNummer) {
        this.vluchtNummer.setValue(vluchtNummer);
    }

    public String getBagagelabel() {
        return bagagelabel.get();
    }

    public void setBagagelabel(String bagagelabel) {
        this.bagagelabel.setValue(bagagelabel);
    }

    public String getGevondenLocatie() {
        return gevondenLocatie.get();
    }

    public void setGevondenLocatie(String gevondenLocatie) {
        this.gevondenLocatie.setValue(gevondenLocatie);
    }

    public String getPrimaireKleur() {
        return primaireKleur.get();
    }

    public void setPrimaireKleur(String primaireKleur) {
        this.primaireKleur.setValue(primaireKleur);
    }

    public String getSecundaireKleur() {
        return secundaireKleur.get();
    }

    public void setSecundaireKleur(String secundaireKleur) {
        this.secundaireKleur.setValue(secundaireKleur);
    }

    public String getFormaat() {
        return formaat.get();
    }

    public void setFormaat(String formaat) {
        this.formaat.setValue(formaat);
    }

    public String getGewichtInKG() {
        return gewichtInKG.get();
    }

    public void setGewichtInKG(String gewichtInKG) {
        this.gewichtInKG.setValue(gewichtInKG);
    }

    public String getOverigeEigenschappen() {
        return overigeEigenschappen.get();
    }

    public void setOverigeEigenschappen(String overigeEigenschappen) {
        this.overigeEigenschappen.setValue(overigeEigenschappen);
    }

    public void setAllProperties(List<TextField> list) {
        for (int x = 0; x < list.size(); x++) {
            for (int y = 0; y < properties.size(); y++) {
                String tempListID = list.get(x).getId();
                String tempPropertiesName = properties.get(y).getName();

                System.out.println(tempListID);
                System.out.println(tempPropertiesName);

                if (tempListID.equalsIgnoreCase(tempPropertiesName)) {
                    properties.get(y).bind(list.get(x).textProperty());
                }
            }
        }

    }

    private void addAllToProperties() {
        properties.add(registratieID);
        properties.add(datumGevonden);
        properties.add(tijdGevonden);
        properties.add(bagageType);
        properties.add(merk);
        properties.add(vluchtNummer);
        properties.add(bagagelabel);
        properties.add(gevondenLocatie);
        properties.add(primaireKleur);
        properties.add(secundaireKleur);
        properties.add(formaat);
        properties.add(gewichtInKG);
        properties.add(overigeEigenschappen);
    }

    /**
     * @return the status
     */
    public BooleanProperty getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(BooleanProperty status) {
        this.status = status;
    }

}
