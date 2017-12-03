package hva.fys.mercury.DAO;

import hva.fys.mercury.models.Bagage;
import hva.fys.mercury.models.Reiziger;

public class BagageDAO {

    private static DatabaseManager dbManager = new DatabaseManager("MercuryTest");
    private static final int MINIMUM_EDITED_COLUMN = 1;
    private static int columnsBewerkt;

    public static boolean registreerReiziger(Reiziger bagage) {
        final String INSERT_QUERY = "INSERT INTO Reizigers (ReizigerID, voornaam, achternaam, woonplaats, adres, land, telefoon, email, iata_code) "
                + "VALUES (%d ,'%s' , '%s' , '%s' , '%s', '%s' ,%s, '%s' , '%s')";
        
        String insertString = String.format(
                INSERT_QUERY, bagage.getReizigerID(), bagage.getVoornaam(), bagage.getAchternaam(), 
                bagage.getWoonplaats(), bagage.getAdres(), bagage.getLand(), bagage.getTelefoonnummer(), 
                bagage.getEmail(), bagage.getIATA_Code()
        );
        
        int columnsBewerkt = dbManager.executeUpdateQuery(insertString);
        dbManager.close();
        return (columnsBewerkt >= MINIMUM_EDITED_COLUMN);
    }

    public static boolean updateReiziger(Reiziger bagage) {
        final String UPDATE_QUERY = "UPDATE Reizigers "
                + "SET voornaam='%s', achternaam='%s', woonplaats='%s', "
                + "adres='%s', land='%s', telefoon='%s', Email='%s', IATA_Code= '%s' "
                + "WHERE ReizigerID=%d;";
        
        String updateString = String.format(UPDATE_QUERY, bagage.getVoornaam(), bagage.getAchternaam(), 
                bagage.getWoonplaats(), bagage.getAdres(), bagage.getLand(), bagage.getTelefoonnummer(), 
                bagage.getEmail(), bagage.getIATA_Code(), bagage.getReizigerID());
        
        columnsBewerkt = dbManager.executeUpdateQuery(updateString);
        dbManager.close();
        return (columnsBewerkt >= MINIMUM_EDITED_COLUMN);
    }

}
