package hva.fys.mercury.DAO;

import hva.fys.mercury.MainApp;
import hva.fys.mercury.models.Gebruiker;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

/*
* @author: David Britt
 */
public class GebruikerDAO {

    private static final DatabaseManager DB_MANAGER = new DatabaseManager(MainApp.DATABASE_NAME);
    private static final int MINIMUM_EDITED_COLUMN = 1;
    private static int columnsBewerkt;

    public static boolean registreerGebruiker(Gebruiker gebruiker) {

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

        int columnsBewerkt = DB_MANAGER.executeUpdateQuery(insertString);
        DB_MANAGER.close();
        return (columnsBewerkt >= MINIMUM_EDITED_COLUMN);
        //Ik snap niet wat de bedoeling is van hierboven?
        //Waarom columsBewerkt gedefinieerd helemaal boven in en niet de methode zelf?
    }

    public static boolean updateGebruiker(Gebruiker gebruiker) {

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

//    public static Boolean gebruikerExistDB(int registratieNummer){
//        String query = String.format("SELECT EmployeeID FROM Gebruikers WHERE", registratieNummer);
//        
////        DB_MANAGER.
//        
//    }
    public static Gebruiker getGebruikerDB(int registratieNummer) {
        Gebruiker gebruiker = new Gebruiker();
        try {

            System.out.println("Getting all Gebruiker from database");
            String query = String.format("SELECT EmployeeID FROM Gebruikers WHERE='%d';", registratieNummer);
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

        } catch (Exception e) {
            System.out.println(e);
        }
        DB_MANAGER.close();
        return null;
    }

    public static List<Gebruiker> readAllGebruikerDB() {
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

        } catch (Exception e) {
            DB_MANAGER.close();
            System.out.println(e);
        }
        return gebruikerList;
    }

    public static List<Gebruiker> readQueryGebruikerDB(List<String> sqlStatementsList) {
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

    public static void deleteGebruikerDB(Gebruiker gebruiker) {
        String query = String.format("DELETE FROM Gebruikers WHERE EmployeeID='%d';", gebruiker.getEmployeeID());
        try {
            DB_MANAGER.executeUpdateQuery(query);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
