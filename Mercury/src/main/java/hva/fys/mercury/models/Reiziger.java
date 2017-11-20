package hva.fys.mercury.models;

import java.util.List;
import javafx.scene.control.TextField;

public class Reiziger {

    private String voornaam;
    private String achternaam;
    private String adres;
    private String woonplaats;
    private String postcode;
    private String land;
    private String telefoonnummer;
    private String email;

    /**
     * @return the voornaam
     */
    public String getVoornaam() {
        return voornaam;
    }

    /**
     * @param voornaam the voornaam to set
     */
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    /**
     * @return the achternaam
     */
    public String getAchternaam() {
        return achternaam;
    }

    /**
     * @param achternaam the achternaam to set
     */
    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    /**
     * @return the adres
     */
    public String getAdres() {
        return adres;
    }

    /**
     * @param adres the adres to set
     */
    public void setAdres(String adres) {
        this.adres = adres;
    }

    /**
     * @return the woonplaats
     */
    public String getWoonplaats() {
        return woonplaats;
    }

    /**
     * @param woonplaats the woonplaats to set
     */
    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    /**
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * @param postcode the postcode to set
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * @return the land
     */
    public String getLand() {
        return land;
    }

    /**
     * @param land the land to set
     */
    public void setLand(String land) {
        this.land = land;
    }

    /**
     * @return the telefoonnummer
     */
    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    /**
     * @param telefoonnummer the telefoonnummer to set
     */
    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public void setAllProperties(List<TextField> list) {

    }
}
