package hva.fys.mercury.DAO;

/*
*@author: David Britt
*/

import hva.fys.mercury.models.Bagage;
import hva.fys.mercury.models.Gebruiker;
import hva.fys.mercury.models.LuchtHaven;
import hva.fys.mercury.models.Reiziger;
import java.sql.ResultSet;

import javafx.collections.ObservableList;

public class JDBCMethods {

    static DatabaseManager database = new DatabaseManager("Corendon");

    public static void createBagageDatabase(Bagage bagage) {

        String query = String.format(
                "INSERT INTO Bagage( "
                + "`BagageRegistratieNummer`, `DateFound`, `TimeFound`, `BrandMerk`, `BagageType`, "
                + "`BagageLabel`, `LocatieGevonden`, `MainColor`, `SecondColor`, `Formaat`, `Gewicht`, `OverigeEigenschappen`, "
                + "`Status`"
                + ") "
                + "VALUES ('%d', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                bagage.getRegistratieID(),
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
        //                bagage.getReizigerID(), , `ReizigerID`, `IATA_Code`  , '%d', '%s'
        //                bagage.getIATA_Code()
        );

        int numberAffected = database.executeUpdateQuery(query);
        System.out.println(numberAffected);

    }

    public static void readBagageDatabase(ObservableList<Bagage> bagageList) {
        try {

            String query = "SELECT * FROM Bagage";
            ResultSet results = database.executeResultSetQuery(query);

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
                bagage.setReizigerID(results.getString("ReizigerID"));
                bagage.setIATA_Code(results.getString("IATA_Code"));

                bagageList.add(bagage);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void updateBagageDatabase(){}
    
    public static void deleteBagageDatabase(){}

    public static void createGebruikersDatabase(Gebruiker gebruiker) {

        String query = String.format(
                "INSERT INTO Gebruiker( "
                + "`EmployeeID`, `Initials`, `FirstName`, `MiddleName`, `SurName`, `BirthDate`,"
                + " `StartEmploymentDate`, `WorkEmail`, `WorkingLocation`, `StatusEmployment`, "
                + "`EndDateEmployment`, `PersonalEmail`, `MobilePhoneNumber`, `HomePhoneNumber`, "
                + "`DepartmentEmployment`, `HomeAdress` "
                + ") "
                + "VALUES ('%d', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                gebruiker.getEmployeeID(),
                gebruiker.getInitials(),
                gebruiker.getFirstName(),
                gebruiker.getMiddleName(),
                gebruiker.getSurName(),
                gebruiker.getBirthDate(),
                gebruiker.getStartEmploymentDate(),
                gebruiker.getWorkEmail(),
                gebruiker.getWorkingLocation(),
                gebruiker.getStatusEmployment(),
                gebruiker.getEndDateEmployment(),
                gebruiker.getPersonalEmail(),
                gebruiker.getMobilePhoneNumber(),
                gebruiker.getPostalCode(),
                gebruiker.getDepartmentEmployment(),
                gebruiker.getHomeAdress()
        );

        int numberAffected = database.executeUpdateQuery(query);
        System.out.println(numberAffected);

    }

    public static void readGebruikersDatabase(ObservableList<Gebruiker> gebruikerList) {
        try {

            String query = "SELECT * FROM Gebruiker";
            ResultSet results = database.executeResultSetQuery(query);

            while (results.next()) {
                Gebruiker gebruiker = new Gebruiker();

                gebruiker.setEmployeeID(results.getInt("EmployeeID"));
                gebruiker.setInitials(results.getString("Initials"));
                gebruiker.setFirstName(results.getString("FirstName"));
                gebruiker.setMiddleName(results.getString("MiddleName"));
                gebruiker.setSurName(results.getString("SurName"));
                gebruiker.setBirthDate(results.getString("BirthDate"));
                gebruiker.setStartEmploymentDate(results.getString("StartEmploymentDate"));
                gebruiker.setWorkEmail(results.getString("WorkEmail"));
                gebruiker.setWorkingLocation(results.getString("WorkingLocation"));
                gebruiker.setStatusEmployment(results.getString("StatusEmployment"));
                gebruiker.setEndDateEmployment(results.getString("EndDateEmployment"));
                gebruiker.setPersonalEmail(results.getString("PersonalEmail"));
                gebruiker.setMobilePhoneNumber(results.getString("MobilePhoneNumber"));
                gebruiker.setPostalCode(results.getString("HomePhoneNumber"));
                gebruiker.setDepartmentEmployment(results.getString("DepartmentEmployment"));
                gebruiker.setHomeAdress(results.getString("HomeAdres"));

                gebruikerList.add(gebruiker);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    static public void updateGebruikerDatabase(){}
    
    static public void deleteGebruikerDatabase(){}

    public static void createReizigerDatabase(Reiziger reiziger) {

        String query = String.format(
                "INSERT INTO Reiziger( "
                + "`ReizigerID`, `VoorNaam`, `AchterNaam`, `WoonPlaats`,"
                + " `Adres`, `Land`, `Telefoon`, `Email`, "
                + "`IATA_Code`"
                + ") "
                + "VALUES ('%d', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s' )",
                reiziger.getReizigerID(),
                reiziger.getVoornaam(),
                reiziger.getAchternaam(),
                reiziger.getWoonplaats(),
                reiziger.getAdres(),
                reiziger.getLand(),
                reiziger.getTelefoonnummer(),
                reiziger.getEmail(),
                reiziger.getIATA_Code()
        );

        int numberAffected = database.executeUpdateQuery(query);
        System.out.println(numberAffected);

    }

    public static void readReizigerDatabase(ObservableList<Reiziger> reizigerList) {
        try {

            String query = "SELECT * FROM Reiziger";
            ResultSet results = database.executeResultSetQuery(query);

            while (results.next()) {
                Reiziger reiziger = new Reiziger();

                reiziger.setReizigerID(results.getInt("ReizigerID"));
                reiziger.setVoornaam(results.getString("VoorNaam"));
                reiziger.setAchternaam(results.getString("AchterNaam"));
                reiziger.setWoonplaats(results.getString("WoonPlaats"));
                reiziger.setAdres(results.getString("Adres"));
                reiziger.setLand(results.getString("Land"));
                //reiziger.setTelefoonnummer(results.getString("Telefoon"));
                reiziger.setEmail(results.getString("Email"));
                reiziger.setIATA_Code(results.getString("IATA_Code"));
                reiziger.setBagageRegistratieNummer(results.getString("BagageRegistratieNummer"));

                reizigerList.add(reiziger);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void updateReizigerDatabase(){}
    public static void deleteReizigerDatabase(){}

    public static void createLuchtHavenDatabase(LuchtHaven luchtHaven) {

        String query = String.format(
                "INSERT INTO LuchtHaven( "
                + "`IATA_Code`, `Naam`, `Land`, `TimeZone`,"
                + ") "
                + "VALUES ('%s', '%s', '%s', '%s')",
                luchtHaven.getIATA_Code(),
                luchtHaven.getNaam(),
                luchtHaven.getLand(),
                luchtHaven.getTimeZone()
        );

        int numberAffected = database.executeUpdateQuery(query);
        System.out.println(numberAffected);

    }

    public static void readLuchtHavenDatabase(ObservableList<LuchtHaven> luchtHavenList) {
        try {

            String query = "SELECT * FROM LuchtHaven";
            ResultSet results = database.executeResultSetQuery(query);

            while (results.next()) {
                LuchtHaven luchtHaven = new LuchtHaven();

                luchtHaven.setIATA_Code(results.getString("IATA_Code"));
                luchtHaven.setNaam(results.getString("Naam"));
                luchtHaven.setLand(results.getString("Land"));
                luchtHaven.setTimeZone(results.getString("TimeZone"));

                luchtHavenList.add(luchtHaven);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void updateLuchtHavenDatabase(){}
    public static void deleteLuchtHavenDatabase(){}

}
