package hva.fys.mercury.models;

public class Reiziger {

    private int reizigerID;
    private String voornaam;
    private String achternaam;
    private String adres;
    private String woonplaats;
    private String postcode;
    private String land;
    private int telefoonnummer;
    private String email;
    private String IATA_Code;

    public Reiziger() {
    }

    public Reiziger(int reizigerID, String voornaam, String achternaam, String adres, String woonplaats, String postcode, String land, int telefoonnummer, String email, String IATA_Code) {
        this.reizigerID = reizigerID;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.adres = adres;
        this.woonplaats = woonplaats;
        this.postcode = postcode;
        this.land = land;
        this.telefoonnummer = telefoonnummer;
        this.email = email;
        this.IATA_Code = IATA_Code;
    }

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
    public int getTelefoonnummer() {
        return telefoonnummer;
    }

    /**
     * @param telefoonnummer the telefoonnummer to set
     */
    public void setTelefoonnummer(int telefoonnummer) {
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

    public int getReizigerID() {
        return reizigerID;
    }

    public void setReizigerID(int reizigerID) {
        this.reizigerID = reizigerID;
    }

    public String getIATA_Code() {
        return IATA_Code;
    }

    public void setIATA_Code(String IATA_Code) {
        this.IATA_Code = IATA_Code;
    }

    public void setBagageRegistratieNummer(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
