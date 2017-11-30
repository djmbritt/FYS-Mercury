/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hva.fys.mercury.models;

/**
 *
 * @author GG
 */
public class LuchtHaven {

    private String IATA_Code;
    private String Naam;
    private String Land;
    private String TimeZone;

    public LuchtHaven() {
    }

    public LuchtHaven(String IATA_Code, String Naam, String Land, String TimeZone) {
        this.IATA_Code = IATA_Code;
        this.Naam = Naam;
        this.Land = Land;
        this.TimeZone = TimeZone;
    }

    public String getIATA_Code() {
        return IATA_Code;
    }

    public void setIATA_Code(String IATA_Code) {
        this.IATA_Code = IATA_Code;
    }

    public String getNaam() {
        return Naam;
    }

    public void setNaam(String Naam) {
        this.Naam = Naam;
    }

    public String getLand() {
        return Land;
    }

    public void setLand(String Land) {
        this.Land = Land;
    }

    public String getTimeZone() {
        return TimeZone;
    }

    public void setTimeZone(String TimeZone) {
        this.TimeZone = TimeZone;
    }

}
