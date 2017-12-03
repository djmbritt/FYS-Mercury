package hva.fys.mercury.DAO;

import hva.fys.mercury.models.Reiziger;
import java.util.List;

public class ReizigerDAO {

    private static DatabaseManager dbManager = new DatabaseManager("MercuryTest");
    private static final int MINIMUM_EDITED_COLUMN = 1;
    private static int columnsBewerkt;

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
        dbManager.close();
        return (columnsBewerkt >= MINIMUM_EDITED_COLUMN);
    }

    public static boolean updateReiziger(Reiziger reiziger) {
        final String UPDATE_QUERY = "UPDATE Reizigers "
                + "SET voornaam='%s', achternaam='%s', woonplaats='%s', "
                + "adres='%s', land='%s', telefoon='%s', Email='%s', IATA_Code= '%s' "
                + "WHERE ReizigerID=%d;";

        String updateString = String.format(UPDATE_QUERY, reiziger.getVoornaam(), reiziger.getAchternaam(),
                reiziger.getWoonplaats(), reiziger.getAdres(), reiziger.getLand(), reiziger.getTelefoonnummer(),
                reiziger.getEmail(), reiziger.getIATA_Code(), reiziger.getReizigerID());

        columnsBewerkt = dbManager.executeUpdateQuery(updateString);
        dbManager.close();
        return (columnsBewerkt >= MINIMUM_EDITED_COLUMN);
    }

    public static Reiziger getReiziger(String naam) {

    }

    public static boolean deleteReiziger(Reiziger reiziger) {
        final String DELETE_QUERY = "DELETE"
    }

}
