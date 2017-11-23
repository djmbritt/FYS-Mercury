package hva.fys.mercury.models;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

public class Reiziger {

    private final List<StringProperty> properties;
    private StringProperty voornaam;
    private StringProperty achternaam;
    private StringProperty adres;
    private StringProperty woonplaats;
    private StringProperty postcode;
    private StringProperty land;
    private StringProperty telefoonnummer;
    private StringProperty email;

    public Reiziger() {
        voornaam = new SimpleStringProperty(this, "voornaam");
        achternaam = new SimpleStringProperty(this, "achternaam");
        adres = new SimpleStringProperty(this, "adres");
        woonplaats = new SimpleStringProperty(this, "woonplaats");

        postcode = new SimpleStringProperty(this, "postcode");
        land = new SimpleStringProperty(this, "land");
        telefoonnummer = new SimpleStringProperty(this, "telefoonnummer");
        email = new SimpleStringProperty(this, "email");

        properties = new ArrayList<>();
        addAllToProperties();
    }

    public String getVoornaam() {
        return voornaam.get();
    }

    /**
     * @param voornaam the voornaam to set
     */
    public void setVoornaam(String voornaam) {
        this.voornaam.setValue(voornaam);
    }

    /**
     * @return the achternaam
     */
    public String getAchternaam() {
        return achternaam.get();
    }

    /**
     * @param achternaam the achternaam to set
     */
    public void setAchternaam(String achternaam) {
        this.achternaam.setValue(achternaam);
    }

    /**
     * @return the adres
     */
    public String getAdres() {
        return adres.get();
    }

    /**
     * @param adres the adres to set
     */
    public void setAdres(String adres) {
        this.adres.setValue(adres);
    }

    /**
     * @return the woonplaats
     */
    public String getWoonplaats() {
        return woonplaats.get();
    }

    /**
     * @param woonplaats the woonplaats to set
     */
    public void setWoonplaats(String woonplaats) {
        this.woonplaats.setValue(woonplaats);
    }

    /**
     * @return the postcode
     */
    public String getPostcode() {
        return postcode.get();
    }

    /**
     * @param postcode the postcode to set
     */
    public void setPostcode(String postcode) {
        this.postcode.setValue(postcode);
    }

    /**
     * @return the land
     */
    public String getLand() {
        return land.get();
    }

    /**
     * @param land the land to set
     */
    public void setLand(String land) {
        this.land.setValue(land);
    }

    /**
     * @return the telefoonnummer
     */
    public String getTelefoonnummer() {
        return telefoonnummer.get();
    }

    /**
     * @param telefoonnummer the telefoonnummer to set
     */
    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer.setValue(telefoonnummer);
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email.get();
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email.setValue(email);
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
        properties.add(voornaam);
        properties.add(achternaam);
        properties.add(adres);
        properties.add(woonplaats);
        properties.add(postcode);
        properties.add(land);
        properties.add(telefoonnummer);
        properties.add(email);
    }
}
