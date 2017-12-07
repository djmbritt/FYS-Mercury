package hva.fys.mercury.DAO;

import hva.fys.mercury.MainApp;
import hva.fys.mercury.models.Reiziger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReizigerDAO {

    private final DatabaseManager DB_MANAGER;
    private final int MINIMUM_EDITED_COLUMN = 1;
    private static int columnsBewerkt;

    public ReizigerDAO() {
        DB_MANAGER = new DatabaseManager(MainApp.DATABASE_NAME);
    }

    public boolean registreerReiziger(Reiziger reiziger) {
        final String INSERT_QUERY = "INSERT INTO Reizigers "
                + "( voornaam, achternaam, woonplaats, adres, land, telefoon, email, iata_code) "
                + "VALUES ('%s' , '%s' , '%s' , '%s', '%s' ,%s, '%s' , '%s')";

        String insertString = String.format(
                INSERT_QUERY, reiziger.getReizigerID(), reiziger.getVoornaam(), reiziger.getAchternaam(),
                reiziger.getWoonplaats(), reiziger.getAdres(), reiziger.getLand(), reiziger.getTelefoonnummer(),
                reiziger.getEmail(), reiziger.getIATA_Code()
        );

        int columnsBewerkt = DB_MANAGER.executeUpdateQuery(insertString);
        System.out.println(columnsBewerkt);
        return (columnsBewerkt >= MINIMUM_EDITED_COLUMN);
    }

    public boolean bewerkReiziger(Reiziger reiziger) {
        final String UPDATE_QUERY = "UPDATE Reizigers "
                + "SET voornaam='%s', achternaam='%s', woonplaats='%s', "
                + "adres='%s', land='%s', telefoon='%s', Email='%s', IATA_Code= '%s' "
                + "WHERE ReizigerID=%d;";

        String updateString = String.format(UPDATE_QUERY, reiziger.getVoornaam(), reiziger.getAchternaam(),
                reiziger.getWoonplaats(), reiziger.getAdres(), reiziger.getLand(), reiziger.getTelefoonnummer(),
                reiziger.getEmail(), reiziger.getIATA_Code(), reiziger.getReizigerID());

        columnsBewerkt = DB_MANAGER.executeUpdateQuery(updateString);
        return (columnsBewerkt >= MINIMUM_EDITED_COLUMN);
    }

    public Reiziger getReiziger(String id) {
        String[] reizigerID = id.split(", ");
        final String SELECT_QUERY = "SELECT * FROM Reizigers where achternaam ='%s' AND woonplaats='%s'";
        String selectString = String.format(SELECT_QUERY, reizigerID[0], reizigerID[1]);
        System.out.println(selectString);
        Reiziger reiziger = new Reiziger();
        try (ResultSet rsReiziger = DB_MANAGER.executeResultSetQuery(selectString)) {
            while (rsReiziger.next()) {
                reiziger.setReizigerID(rsReiziger.getInt("ReizigerID"));
                reiziger.setVoornaam(rsReiziger.getString("voornaam"));
                reiziger.setAchternaam(rsReiziger.getString("achternaam"));
                reiziger.setWoonplaats(rsReiziger.getString("woonplaats"));
                reiziger.setAdres(rsReiziger.getString("adres"));
                reiziger.setLand(rsReiziger.getString("land"));
                reiziger.setTelefoonnummer(rsReiziger.getString("telefoon"));
                reiziger.setEmail(rsReiziger.getString("email"));
                reiziger.setIATA_Code(rsReiziger.getString("IATA_CODE"));
            }
            DB_MANAGER.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReizigerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reiziger;
    }

}
