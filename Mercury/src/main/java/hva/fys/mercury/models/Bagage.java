package hva.fys.mercury.models;

public class Bagage {

    private int registratieID;
    private String datumGevonden;
    private String tijdGevonden;
    private String bagageType;
    private String bagagemerk;
    private String vluchtNummer;
    private String bagagelabel;
    private String gevondenLocatie;
    private String primaireKleur;
    private String secundaireKleur;
    private String formaat;
    private String gewichtInKG;
    private String reizigerID;
    private String IATA_Code;
    private String overigeEigenschappen;
    private String status;
    private static int counter = 1000000000;

    public Bagage() { 
    }

    public Bagage(int registratieID, String datumGevonden, String tijdGevonden, String bagageType, String bagagemerk, String vluchtNummer, String bagagelabel, String gevondenLocatie, String primaireKleur, String secundaireKleur, String formaat, String gewichtInKG, String reizigerID, String IATA_Code, String overigeEigenschappen, String status) {
        this.registratieID = registratieID;
        this.datumGevonden = datumGevonden;
        this.tijdGevonden = tijdGevonden;
        this.bagageType = bagageType;
        this.bagagemerk = bagagemerk;
        this.vluchtNummer = vluchtNummer;
        this.bagagelabel = bagagelabel;
        this.gevondenLocatie = gevondenLocatie;
        this.primaireKleur = primaireKleur;
        this.secundaireKleur = secundaireKleur;
        this.formaat = formaat;
        this.gewichtInKG = gewichtInKG;
        this.reizigerID = reizigerID;
        this.IATA_Code = IATA_Code;
        this.overigeEigenschappen = overigeEigenschappen;
        this.status = status;
    }

    public int getRegistratieID() {
        return registratieID;
    }

    public void setRegistratieID(int registratieID) {
        this.registratieID = registratieID;
    }

    public String getDatumGevonden() {
        return datumGevonden;
    }

    public void setDatumGevonden(String datumGevonden) {
        this.datumGevonden = datumGevonden;
    }

    public String getTijdGevonden() {
        return tijdGevonden;
    }

    public void setTijdGevonden(String tijdGevonden) {
        this.tijdGevonden = tijdGevonden;
    }

    public String getBagageType() {
        return bagageType;
    }

    public void setBagageType(String bagageType) {
        this.bagageType = bagageType;
    }

    public String getBagagemerk() {
        return bagagemerk;
    }

    public void setBagagemerk(String bagagemerk) {
        this.bagagemerk = bagagemerk;
    }

    public String getVluchtNummer() {
        return vluchtNummer;
    }

    public void setVluchtNummer(String vluchtNummer) {
        this.vluchtNummer = vluchtNummer;
    }

    public String getBagagelabel() {
        return bagagelabel;
    }

    public void setBagagelabel(String bagagelabel) {
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

    public String getGewichtInKG() {
        return gewichtInKG;
    }

    public void setGewichtInKG(String gewichtInKG) {
        this.gewichtInKG = gewichtInKG;
    }

    public String getReizigerID() {
        return reizigerID;
    }

    public void setReizigerID(String reizigerID) {
        this.reizigerID = reizigerID;
    }

    public String getIATA_Code() {
        return IATA_Code;
    }

    public void setIATA_Code(String IATA_Code) {
        this.IATA_Code = IATA_Code;
    }

    public String getOverigeEigenschappen() {
        return overigeEigenschappen;
    }

    public void setOverigeEigenschappen(String overigeEigenschappen) {
        this.overigeEigenschappen = overigeEigenschappen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
