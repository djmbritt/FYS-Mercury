package hva.fys.mercury.DAO;

import hva.fys.mercury.MainApp;
import hva.fys.mercury.models.Gebruiker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * De class zorgt ervoor dat er informatie uit de Gebruikers tabel uit de database
 * wordt gehaald
 * @author: David Britt 
 */
public class GebruikerDAO {

    private final DatabaseManager DB_MANAGER;
    private final int MINIMUM_EDITED_COLUMN = 1;
    private int columnsBewerkt;

    public GebruikerDAO() {
        this.DB_MANAGER = new DatabaseManager(MainApp.DATABASE_NAME);
    }

    /**
     * slaat nieuwe informatie op in de database
     *
     * @param gebruiker een gebruiker model met informatie
     * @return een boolean met de waarde 'true' als de informatie succesvol is
     * opgeslagen in de database en 'false' als het niet is gelukt om de
     * informatie op te slaan
     */
    public boolean registreerGebruiker(Gebruiker gebruiker) {

        final String INSERT_QUERY
                = "INSERT INTO Gebruikers (`EmployeeID`, `Initials`, `FirstName`, `MiddleName`, `SurName`, "
                + "`BirthDate`, `StartEmploymentDate`, `WorkEmail`, `WorkingLocation`, `StatusEmployment`, "
                + "`EndDateEmployment`, `PersonalEmail`, `MobilePhoneNumber`, `HomePhoneNumber`, "
                + "`DepartmentEmployment`, `HomeAdress`, `PostalCode`) "
                + "VALUES('%d', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');";

        String insertString = String.format(
                INSERT_QUERY,
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
                gebruiker.getHomeAdress(),
                gebruiker.getDepartmentEmployment(),
                gebruiker.getHomeAdress(),
                gebruiker.getPostalCode()
        );

        columnsBewerkt = DB_MANAGER.executeUpdateQuery(insertString);
        DB_MANAGER.close();
        return (columnsBewerkt >= MINIMUM_EDITED_COLUMN);
        //Ik snap niet wat de bedoeling is van hierboven?
        //Waarom columsBewerkt gedefinieerd helemaal boven in en niet de methode zelf?
    }

    /**
     * zorgt ervoor dat bestaande informatie in de database wordt gewijzigd
     *
     * @param gebruiker een gebruiker model met informatie
     *
     * @return een boolean met de waarde 'true' als de informatie succesvol is
     * opgeslagen in de database en 'false' als het niet is gelukt om de
     * informatie op te slaan
     */
    public boolean updateGebruiker(Gebruiker gebruiker) {

        final String UPDATE_QUERY
                = "UPDATE Gebruikers SET "
                + "Initials='%s', FirstName='%s', MiddleName='%s', SurName='%s', BirthDate='%s', "
                + "StartEmploymentDate='%s', WorkEmail='%s', WorkingLocation='%s', StatusEmployment='%s', "
                + "EndDateEmployment='%s', PersonalEmail='%s', MobilePhoneNumber='%s', HomePhoneNumber='%s', "
                + "DepartmentEmployment='%s', HomeAdress='%s', PostalCode='%s' "
                + "WHERE EmployeeID='%d';";

        String updateString = String.format(
                UPDATE_QUERY,
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
                gebruiker.getHomeAdress(),
                gebruiker.getDepartmentEmployment(),
                gebruiker.getHomeAdress(),
                gebruiker.getPostalCode(),
                gebruiker.getEmployeeID()
        );

        columnsBewerkt = DB_MANAGER.executeUpdateQuery(updateString);
        DB_MANAGER.close();
        return (columnsBewerkt >= MINIMUM_EDITED_COLUMN);
    }

    /**
     * Haalt ,door middel van het van registratieNummer, gebruiker informatie in
     * de database;
     *
     * @param registratieNummer registratienummer van de gebruiker
     * @return een gebruiker model met daarin de informatie uit de database
     */
    public Gebruiker getGebruikerDB(int registratieNummer) {
        Gebruiker gebruiker = new Gebruiker();
        try {

            System.out.println("Getting all Gebruiker from database");
            String query = String.format("SELECT EmployeeID FROM Gebruikers WHERE EmployeeID='%d';", registratieNummer);
            ResultSet results = DB_MANAGER.executeResultSetQuery(query);

            if (results.wasNull()) {
                return null;
            } else {
                while (results.next()) {

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
                    gebruiker.setHomeAdress(results.getString("HomePhoneNumber"));
                    gebruiker.setDepartmentEmployment(results.getString("DepartmentEmployment"));
                    gebruiker.setHomeAdress(results.getString("HomeAdress"));
                    gebruiker.setPostalCode(results.getString("PostalCode"));
                    return gebruiker;
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        DB_MANAGER.close();
        return null;
    }

    /**
     * haalt alle informatie uit de gebruikers tabel van de database en geeft
     * die informatie terug in een List van Gebruiker
     *
     * @return een List van Gebruiker met daarin alle informatie van de
     * gebruikers tabel
     */
    public List<Gebruiker> readAllGebruikerDB() {
        List<Gebruiker> gebruikerList = new ArrayList();
        try {

            System.out.println("Getting all bagage from database");
            String query = "SELECT * FROM Gebruikers;";
            ResultSet results = DB_MANAGER.executeResultSetQuery(query);
            System.out.println("Got bagage from database.");

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
                gebruiker.setHomeAdress(results.getString("HomePhoneNumber"));
                gebruiker.setDepartmentEmployment(results.getString("DepartmentEmployment"));
                gebruiker.setHomeAdress(results.getString("HomeAdress"));
                gebruiker.setPostalCode(results.getString("PostalCode"));

                gebruikerList.add(gebruiker);
            }

        } catch (SQLException e) {
            DB_MANAGER.close();
            System.out.println(e);
        }
        return gebruikerList;
    }

    /**
     * telt het aantal gebruikers in de database en geet het aantal gebruikers
     * terug
     *
     * @return aantal gebruikers in de database
     */
    public int totaalGebruikers() {
        int totaal = 0;
        try {
            String query = "SELECT Count(*) FROM Gebruikers;";
            totaal = Integer.parseInt(DB_MANAGER.executeStringQuery(query));
        } catch (NumberFormatException e) {
        }
        return totaal;
    }

    public List<Gebruiker> readQueryGebruikerDB(List<String> sqlStatementsList) {
        List<Gebruiker> gebruikerList = new ArrayList();
        String sqlStatement;
        if (sqlStatementsList.isEmpty()) {
            sqlStatement = sqlStatementsList.toString();
        } else {
            sqlStatement = sqlStatementsList.toString().join(", ");
        }
        try {

            String query = String.format("SELECT %s FROM Gebruikers;", sqlStatement);
            ResultSet results = DB_MANAGER.executeResultSetQuery(query);

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
                gebruiker.setHomeAdress(results.getString("HomePhoneNumber"));
                gebruiker.setDepartmentEmployment(results.getString("DepartmentEmployment"));
                gebruiker.setHomeAdress(results.getString("HomeAdress"));
                gebruiker.setPostalCode(results.getString("PostalCode"));

                gebruikerList.add(gebruiker);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return gebruikerList;
    }

    /**
     * verwijdert gebruiker uit de database
     *
     * @param gebruiker gebruiker die uit de database verwijderd moet worden
     */
    public void deleteGebruikerDB(Gebruiker gebruiker) {
        String query = String.format("DELETE FROM Gebruikers WHERE EmployeeID='%d';", gebruiker.getEmployeeID());
        try {
            DB_MANAGER.executeUpdateQuery(query);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * haalt een lijst met de iataCode van alle luchthavens uit database
     *
     * @return een List van String met daarin de IATA codes van alle luchthavens
     */
    public List<String> getLuchtHavenList() {
        List<String> luchtHavenList = new ArrayList();

        try {
            String query = "SELECT * FROM LuchtHaven;";
            ResultSet luchthavenSet = DB_MANAGER.executeResultSetQuery(query);
            while (luchthavenSet.next()) {
                luchtHavenList.add(luchthavenSet.getString("IATA_Code"));
            }
        } catch (SQLException e) {
            System.err.println("getLuchtHavenError: " + e);
        }
        return luchtHavenList;
    }

    /**
     * haalt, op basis van het ingevoerde email adres, het wachtwoord van de
     * gebruiker uit de database
     *
     * @param userEmail email adres van de gebruiker
     * @return een string met daarin het wachtwoord van de gebruiker
     */
    public String getPassword(String userEmail) {
        String resultString = null;
        try {
            String query = String.format("SELECT Wachtwoord FROM Gebruikers WHERE WorkEmail='%s';", userEmail);
            resultString = DB_MANAGER.executeStringQuery(query);
        } catch (Exception e) {
            System.err.println("getPasswordError: " + e);
        }
        return resultString;
    }

    /**
     * haalt, op basis van het ingevoerde email adres, de gebruikersrol van de
     * gebruiker uit de database
     *
     * @param userEmail email adres van de gebruiker
     * @return een string met daarin de rol van de gebruiker
     */
    public String getUserRoll(String userEmail) {
        String query = String.format("SELECT DepartmentEmployment FROM Gebruikers WHERE WorkEmail='%s';", userEmail);
        String resultString = null;
        try {
            resultString = DB_MANAGER.executeStringQuery(query);
        } catch (Exception e) {
            System.err.println("getUserRollError: " + e);
        }
        return resultString;
    }

}
