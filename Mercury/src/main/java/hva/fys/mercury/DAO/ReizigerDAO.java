package hva.fys.mercury.DAO;

import hva.fys.mercury.models.Reiziger;

public class ReizigerDAO {

    private DatabaseManager dbManager;
    private final int MINIMUM_EDITED_COLUMN = 1;
    private int columnsBewerkt;

    public boolean registreerReiziger(Reiziger reiziger) {
        final String INSERT_QUERY = "INSERT INTO Reizigers (ReizigerID, voornaam, achternaam, woonplaats, adres, land, telefoon, email, iata_code) "
                + "VALUES (%d ,'%s' , '%s' , '%s' , '%s', '%s' ,%s, '%s' , '%s')";
        dbManager = new DatabaseManager();
        String insertString = String.format(
                INSERT_QUERY, reiziger.getReizigerID(), reiziger.getVoornaam(), reiziger.getAchternaam(), 
                reiziger.getWoonplaats(), reiziger.getAdres(), reiziger.getLand(), reiziger.getTelefoonnummer(), 
                reiziger.getEmail(), reiziger.getIATA_Code()
        );
        int columnsBewerkt = dbManager.executeUpdateQuery(insertString);
        dbManager.close();
        return (columnsBewerkt >= MINIMUM_EDITED_COLUMN);
    }

    public boolean updateReiziger(Reiziger reiziger) {
        final String UPDATE_QUERY = "UPDATE Reizigers SET voornaam = '%s' , achternaam= '%s' , woonplaats= '%s' , "
                + "adres='%s' , land='%s', telefoon =%s email='%s' , iata_code= '%s' WHERE reizigerID= %d";
        dbManager = new DatabaseManager();
        String updateString = String.format(UPDATE_QUERY, reiziger.getVoornaam(), reiziger.getAchternaam(), 
                reiziger.getWoonplaats(), reiziger.getAdres(), reiziger.getLand(), reiziger.getTelefoonnummer(), 
                reiziger.getEmail(), reiziger.getIATA_Code(), reiziger.getReizigerID());
        columnsBewerkt = dbManager.executeUpdateQuery(updateString);
        dbManager.close();
        return (columnsBewerkt >= MINIMUM_EDITED_COLUMN);
    }

}
