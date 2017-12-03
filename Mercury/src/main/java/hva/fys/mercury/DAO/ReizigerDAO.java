package hva.fys.mercury.DAO;

import hva.fys.mercury.MainApp;
import hva.fys.mercury.models.Reiziger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReizigerDAO {

    private static DatabaseManager dbManager = new DatabaseManager(MainApp.DATABASE_NAME);
    private static final int MINIMUM_EDITED_COLUMN = 1;
    private static int columnsBewerkt;
    private static  int reizigerID = 0;
    
   private int maakReizigerID(){
       
   }

    public static boolean registreerReiziger(Reiziger reiziger) {
        final String INSERT_QUERY = "INSERT INTO Reizigers "
                + "(ReizigerID, voornaam, achternaam, woonplaats, adres, land, telefoon, email, iata_code) "
                + "VALUES (%d ,'%s' , '%s' , '%s' , '%s', '%s' ,%s, '%s' , '%s')";

        String insertString = String.format(
                INSERT_QUERY, reiziger.getReizigerID(), reiziger.getVoornaam(), reiziger.getAchternaam(),
                reiziger.getWoonplaats(), reiziger.getAdres(), reiziger.getLand(), reiziger.getTelefoonnummer(),
                reiziger.getEmail(), reiziger.getIATA_Code()
        );

        int columnsBewerkt = dbManager.executeUpdateQuery(insertString); 
        return (columnsBewerkt >= MINIMUM_EDITED_COLUMN);
    }

    public static boolean bewerkReiziger(Reiziger reiziger) {
        final String UPDATE_QUERY = "UPDATE Reizigers "
                + "SET voornaam='%s', achternaam='%s', woonplaats='%s', "
                + "adres='%s', land='%s', telefoon='%s', Email='%s', IATA_Code= '%s' "
                + "WHERE ReizigerID=%d;";

        String updateString = String.format(UPDATE_QUERY, reiziger.getVoornaam(), reiziger.getAchternaam(),
                reiziger.getWoonplaats(), reiziger.getAdres(), reiziger.getLand(), reiziger.getTelefoonnummer(),
                reiziger.getEmail(), reiziger.getIATA_Code(), reiziger.getReizigerID());

        columnsBewerkt = dbManager.executeUpdateQuery(updateString); 
        return (columnsBewerkt >= MINIMUM_EDITED_COLUMN);
    }

    public static Reiziger getReiziger(int id) {
        final String SELECT_QUERY = "SELECT * FROM Reizigers where ReizigerID =%d ";
        String selectString = String.format(SELECT_QUERY, id); 
        Reiziger reiziger = new Reiziger();;
        try {
            ResultSet rsReiziger = dbManager.executeResultSetQuery(selectString);
            while(rsReiziger.next()){
                reiziger.setReizigerID(rsReiziger.getInt("ReizigerID"));
                reiziger.setVoornaam(rsReiziger.getString("voornaam"));
                reiziger.setAchternaam(rsReiziger.getString("achternaam"));
                reiziger.setWoonplaats(rsReiziger.getString("woonplaats"));
                reiziger.setAdres(rsReiziger.getString("adres"));
                reiziger.setLand(rsReiziger.getString("land"));
                reiziger.setTelefoonnummer(rsReiziger.getInt("telefoon"));
                reiziger.setEmail(rsReiziger.getString("email"));
                reiziger.setIATA_Code(rsReiziger.getString("IATA_CODE"));
                
                
            }
            rsReiziger.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReizigerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbManager.close();
        return reiziger;
    }

}
