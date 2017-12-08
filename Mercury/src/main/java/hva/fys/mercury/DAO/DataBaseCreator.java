package hva.fys.mercury.DAO;

/**
 * *
 * bouwt een test Database
 *
 * @author: David Britt
 *
 */
public class DataBaseCreator {

    /**
     * maakt een nieuw database aan en indien de database al bestaat wordt die
     * verwijderd en vervangen door een nieuwe
     *
     * @param dbName naam van de database die gecreëerd moet worden
     */
    public static void createDatabase(String dbName) {

        System.out.println("Creating the " + dbName + " database...");

        // use the sys schema for creating another db
        DatabaseManager sysJDBC = new DatabaseManager("sys");
        //original:
//        sysJDBC.executeUpdateQuery("CREATE DATABASE IF NOT EXISTS " + dbName);

        sysJDBC.executeUpdateQuery("DROP DATABASE IF EXISTS " + dbName);
        sysJDBC.executeUpdateQuery("CREATE DATABASE " + dbName);

        sysJDBC.close();

        // create or truncate Airport table in the Airline database
        System.out.println("Creating the " + dbName + " Table...");
        DatabaseManager myJDBC = new DatabaseManager(dbName);

        //Luchthaven table
        myJDBC.executeUpdateQuery("DROP TABLE IF EXISTS `LuchtHaven`;");
        myJDBC.executeUpdateQuery(
                "CREATE TABLE IF NOT EXISTS `LuchtHaven` ("
                + "`IATA_Code` varchar(3) NOT NULL,"
                + "`LuchtHavenNaam` varchar(45)  DEFAULT NULL,"
                + "`Land` varchar(45)  DEFAULT NULL,"
                + "`TimeZone` int(2)  DEFAULT NULL,"
                + "`DaylightSaving` varchar(45)  DEFAULT NULL,"
                + "PRIMARY KEY (`IATA_Code`)"
                + ");"
        );

        //Vluchten
        myJDBC.executeUpdateQuery("DROP TABLE IF EXISTS `Vluchten`;");
        myJDBC.executeUpdateQuery(
                "CREATE TABLE `Vluchten` ("
                + "`VluchtenID` int(4) NOT NULL,"
                + "`Airline` varchar(45) DEFAULT NULL,"
                + "`VluchtNummer` varchar(45) DEFAULT NULL,"
                + "`VanLocatie` varchar(45) DEFAULT NULL,"
                + "`NaarLocatie` varchar(45) DEFAULT NULL,"
                + "PRIMARY KEY (`VluchtenID`)"
                + ");"
        );

        //Locaties
        myJDBC.executeUpdateQuery("DROP TABLE IF EXISTS `Locaties`;");
        myJDBC.executeUpdateQuery(
                "CREATE TABLE `Locaties` ("
                + "`LocatieID` int(4) NOT NULL,"
                + "`Engels` varchar(45) DEFAULT NULL,"
                + "`Nederlands` varchar(45) DEFAULT NULL,"
                + "`Spaans` varchar(45) DEFAULT NULL,"
                + "`Turks` varchar(45) DEFAULT NULL,"
                + "PRIMARY KEY (`LocatieID`)"
                + ");"
        );

        //BagageType
        myJDBC.executeUpdateQuery("DROP TABLE IF EXISTS `BagageTypes`;");
        myJDBC.executeUpdateQuery(
                "CREATE TABLE `BagageTypes` ("
                + "`BagageTypeID` int(4) NOT NULL,"
                + "`Engels` varchar(45) DEFAULT NULL,"
                + "`Nederlands` varchar(45) DEFAULT NULL,"
                + "`Spaans` varchar(45) DEFAULT NULL,"
                + "`Turks` varchar(45) DEFAULT NULL,"
                + "PRIMARY KEY (`BagageTypeID`)"
                + ");"
        );

        //Kleuren
        myJDBC.executeUpdateQuery("DROP TABLE IF EXISTS `Kleuren`;");
        myJDBC.executeUpdateQuery(
                "CREATE TABLE `Kleuren` ("
                + "`RalCode` int(4) NOT NULL,"
                + "`Engels` varchar(45) DEFAULT NULL,"
                + "`Nederlands` varchar(45) DEFAULT NULL,"
                + "`Spaans` varchar(45) DEFAULT NULL,"
                + "`Turks` varchar(45) DEFAULT NULL,"
                + "PRIMARY KEY (`RalCode`)"
                + ");"
        );

        //Reizigers Table
        myJDBC.executeUpdateQuery("DROP TABLE IF EXISTS `Reizigers`;");
        myJDBC.executeUpdateQuery(
                "CREATE TABLE `Reizigers` ("
                + "`ReizigerID` int(11) NOT NULL AUTO_INCREMENT,"
                + "`VoorNaam` varchar(45)  DEFAULT NULL,"
                + "`AchterNaam` varchar(45)  DEFAULT NULL,"
                + "`WoonPlaats` varchar(45)  DEFAULT NULL,"
                + "`Adres` varchar(45)  DEFAULT NULL,"
                + "`Land` varchar(45)  DEFAULT NULL,"
                + "`Telefoon` varchar(45)  DEFAULT NULL,"
                + "`Email` varchar(45)  DEFAULT NULL,"
                + "`IATA_Code` varchar(3) DEFAULT NULL,"
                + "`BagageRegistratieNummer` int(11) DEFAULT NULL,"
                + "PRIMARY KEY (`ReizigerID`),"
                + "FOREIGN KEY (`IATA_Code`) REFERENCES LuchtHaven (`IATA_Code`)"
                + ");"
        );

        //Bagage Table
        myJDBC.executeUpdateQuery("DROP TABLE IF EXISTS `Bagage`;");
        myJDBC.executeUpdateQuery(
                "CREATE TABLE IF NOT EXISTS `Bagage` ("
                + "`BagageRegistratieNummer` int(11) NOT NULL  AUTO_INCREMENT,"
                + "`IATA_Code` varchar(3) DEFAULT NULL,"
                + "`DateFound` varchar(45)  DEFAULT NULL,"
                + "`TimeFound` varchar(45)  DEFAULT NULL,"
                + "`BagageType` varchar(45)  DEFAULT NULL,"
                + "`BrandMerk` varchar(45)  DEFAULT NULL,"
                + "`ArrivedWithFlight` varchar(45)  DEFAULT NULL,"
                + "`BagageLabel` varchar(45)  DEFAULT NULL,"
                + "`LocatieGevonden` varchar(45)  DEFAULT NULL,"
                + "`MainColor` varchar(45)  DEFAULT NULL,"
                + "`SecondColor` varchar(45)  DEFAULT NULL,"
                + "`Formaat` varchar(45)  DEFAULT NULL,"
                /*
                 Double check gewicht, mischien beter om int(3) van te maken?       
                 */
                + "`Gewicht` varchar(45)  DEFAULT NULL,"
                + "`Reiziger` varchar(45)  DEFAULT NULL,"
                + "`OverigeEigenschappen` varchar(45)  DEFAULT NULL,"
                //                + "`ReizigerID` int(11)  DEFAULT NULL,"
                //{Gevonden, Verloren, Afgehandeld}
                + "`Status` varchar(45)  DEFAULT NULL,"
                + "PRIMARY KEY (`BagageRegistratieNummer`),"
                //                + "FOREIGN KEY (`ReizigerID`) REFERENCES Reizigers(`ReizigerID`),"
                + "FOREIGN KEY (`IATA_Code`) REFERENCES LuchtHaven(`IATA_Code`)"
                /*
                    Figure out why these foreign keys don't work
                    My theory at the moment is that you can not set a FK to a none PK entity.
                 */
                //                + "FOREIGN KEY (`BagageType`) REFERENCES BagageTypes(`Engels`),"
                //                + "FOREIGN KEY (`ArrivedWithFlight`) REFERENCES Vluchten(`VluchtNummer`),"
                //                + "FOREIGN KEY (`LocatieGevonden`) REFERENCES Locatie(`Engels`),"
                //                + "FOREIGN KEY (`MainColor`) REFERENCES Kleuren(`Engels`),"
                //                + "FOREIGN KEY (`SecondColor`) REFERENCES Kleuren(`Engels`),"

                + ");"
        );

        //Gebruiker Table
        myJDBC.executeUpdateQuery("DROP TABLE IF EXISTS `Gebruikers`;");
        myJDBC.executeUpdateQuery(
                "CREATE TABLE `Gebruikers` ("
                + "`EmployeeID` int(11) NOT NULL  AUTO_INCREMENT,"
                + "`Initials` varchar(45)  DEFAULT NULL,"
                + "`FirstName` varchar(45)  DEFAULT NULL,"
                + "`MiddleName` varchar(45)  DEFAULT NULL,"
                + "`SurName` varchar(45)  DEFAULT NULL,"
                + "`BirthDate` varchar(45)  DEFAULT NULL,"
                + "`StartEmploymentDate` varchar(45)  DEFAULT NULL,"
                + "`WorkEmail` varchar(45)  DEFAULT NULL,"
                + "`WorkingLocation` varchar(45)  DEFAULT NULL,"
                + "`StatusEmployment` varchar(45)  DEFAULT NULL,"
                + "`EndDateEmployment` varchar(45)  DEFAULT NULL,"
                + "`PersonalEmail` varchar(45)  DEFAULT NULL,"
                + "`MobilePhoneNumber` varchar(45)  DEFAULT NULL,"
                + "`HomePhoneNumber` varchar(45)  DEFAULT NULL,"
                + "`DepartmentEmployment` varchar(45)  DEFAULT NULL,"
                + "`HomeAdress` varchar(45)  DEFAULT NULL,"
                + "`PostalCode` varchar(45)  DEFAULT NULL,"
                + "`Wachtwoord` varchar(45)  DEFAULT NULL,"
                + "PRIMARY KEY (`EmployeeID`)"
                + ");"
        );

        myJDBC.executeUpdateQuery("SHOW ENGINE INNODB STATUS;");

        //close the connection with the database 
        myJDBC.close();
    }

}
