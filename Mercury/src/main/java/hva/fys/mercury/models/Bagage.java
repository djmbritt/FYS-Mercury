package hva.fys.mercury.models;


public class Bagage {

    private int registratieID;
    private String datumGevonden;
    private String tijdGevonden;
    private String bagageType;
    private String merk;
    private String vluchtNummer;
    private String bagagelabel;
    private String gevondenLocatie;
    private String primaireKleur;
    private String secundaireKleur;
    private String formaat;
    private String gewicht;
    private boolean status;

    /**
     * @return the registratieID
     */
    public int getRegistratieID() {
        return registratieID;
    }

    /**
     * @param registratieID the registratieID to set
     */
    public void setRegistratieID(int registratieID) {
        this.registratieID = registratieID;
    }

    /**
     * @return the datumGevonden
     */
    public String getDatumGevonden() {
        return datumGevonden;
    }

    /**
     * @param datumGevonden the datumGevonden to set
     */
    public void setDatumGevonden(String datumGevonden) {
        this.datumGevonden = datumGevonden;
    }

    /**
     * @return the tijdGevonden
     */
    public String getTijdGevonden() {
        return tijdGevonden;
    }

    /**
     * @param tijdGevonden the tijdGevonden to set
     */
    public void setTijdGevonden(String tijdGevonden) {
        this.tijdGevonden = tijdGevonden;
    }

    /**
     * @return the bagageType
     */
    public String getBagageType() {
        return bagageType;
    }

    /**
     * @param bagageType the bagageType to set
     */
    public void setBagageType(String bagageType) {
        this.bagageType = bagageType;
    }

    /**
     * @return the merk
     */
    public String getMerk() {
        return merk;
    }

    /**
     * @param merk the merk to set
     */
    public void setMerk(String merk) {
        this.merk = merk;
    }

    /**
     * @return the vluchtNummer
     */
    public String getVluchtNummer() {
        return vluchtNummer;
    }

    /**
     * @param vluchtNummer the vluchtNummer to set
     */
    public void setVluchtNummer(String vluchtNummer) {
        this.vluchtNummer = vluchtNummer;
    }

    /**
     * @return the bagagelabel
     */
    public String getBagagelabel() {
        return bagagelabel;
    }

    /**
     * @param bagagelabel the bagagelabel to set
     */
    public void setBagagelabel(String bagagelabel) {
        this.bagagelabel = bagagelabel;
    }

    /**
     * @return the gevondenLocatie
     */
    public String getGevondenLocatie() {
        return gevondenLocatie;
    }

    /**
     * @param gevondenLocatie the gevondenLocatie to set
     */
    public void setGevondenLocatie(String gevondenLocatie) {
        this.gevondenLocatie = gevondenLocatie;
    }

    /**
     * @return the primaireKleur
     */
    public String getPrimaireKleur() {
        return primaireKleur;
    }

    /**
     * @param primaireKleur the primaireKleur to set
     */
    public void setPrimaireKleur(String primaireKleur) {
        this.primaireKleur = primaireKleur;
    }

    /**
     * @return the secundaireKleur
     */
    public String getSecundaireKleur() {
        return secundaireKleur;
    }

    /**
     * @param secundaireKleur the secundaireKleur to set
     */
    public void setSecundaireKleur(String secundaireKleur) {
        this.secundaireKleur = secundaireKleur;
    }

    /**
     * @return the formaat
     */
    public String getFormaat() {
        return formaat;
    }

    /**
     * @param formaat the formaat to set
     */
    public void setFormaat(String formaat) {
        this.formaat = formaat;
    }

    /**
     * @return the gewichtInKG
     */
    public String getGewicht() {
        return gewicht;
    }

    /**
     * @param gewicht the gewichtInKG to set
     */
    public void setGewicht(String gewicht) {
        this.gewicht = gewicht;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

}