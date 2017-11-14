package hva.fys.mercury.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Bagage {

    private String registratieID;
    private LocalDate datumGevonden;
    private LocalTime tijdGevonden;
    private String bagageType;
    private String merk;
    private String vluchtNummer;
    private int bagagelabel;
    private String gevondenLocatie;
    private String primaireKleur;
    private String secundaireKleur;
    private String formaat;
    private double gewichtInKG;
    private String overigeEigenschappen;

    public String getRegistratieID() {
        return registratieID;
    }

    public void setRegistratieID(String registratieID) {
        this.registratieID = registratieID;
    }

    public LocalDate getDatumGevonden() {
        return datumGevonden;
    }

    public void setDatumGevonden(LocalDate datumGevonden) {
        this.datumGevonden = datumGevonden;
    }

    public LocalTime getTijdGevonden() {
        return tijdGevonden;
    }

    public void setTijdGevonden(LocalTime tijdGevonden) {
        this.tijdGevonden = tijdGevonden;
    }

    public String getBagageType() {
        return bagageType;
    }

    public void setBagageType(String bagageType) {
        this.bagageType = bagageType;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getVluchtNummer() {
        return vluchtNummer;
    }

    public void setVluchtNummer(String vluchtNummer) {
        this.vluchtNummer = vluchtNummer;
    }

    public int getBagagelabel() {
        return bagagelabel;
    }

    public void setBagagelabel(int bagagelabel) {
        this.bagagelabel = bagagelabel;
    }

    public String getGevondenLocatie() {
        return gevondenLocatie;
    }

    public void setGevondenLocatie(String gevondenLocatie) {
        this.gevondenLocatie = gevondenLocatie;
    }

    public String getPrimaireKleur() {
        return primaireKleur;
    }

    public void setPrimaireKleur(String primaireKleur) {
        this.primaireKleur = primaireKleur;
    }

    public String getSecundaireKleur() {
        return secundaireKleur;
    }

    public void setSecundaireKleur(String secundaireKleur) {
        this.secundaireKleur = secundaireKleur;
    }

    public String getFormaat() {
        return formaat;
    }

    public void setFormaat(String formaat) {
        this.formaat = formaat;
    }

    public double getGewichtInKG() {
        return gewichtInKG;
    }

    public void setGewichtInKG(double gewichtInKG) {
        this.gewichtInKG = gewichtInKG;
    }

    public String getOverigeEigenschappen() {
        return overigeEigenschappen;
    }

    public void setOverigeEigenschappen(String overigeEigenschappen) {
        this.overigeEigenschappen = overigeEigenschappen;
    }
    
}
