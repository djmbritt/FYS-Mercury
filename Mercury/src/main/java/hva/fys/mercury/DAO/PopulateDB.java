/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hva.fys.mercury.DAO;

import hva.fys.mercury.MainApp;

/**
 *
 * @author djmbritt
 */
public class PopulateDB {

    static DatabaseManager myJDBC = new DatabaseManager(MainApp.DATABASE_NAME);

    public static void insertExamplesIntoDB() {
        PopulateDB.insertBagageTypes();
        PopulateDB.insertKleuren();
        PopulateDB.insertLocaties();
        PopulateDB.insertLuchthaven();
        PopulateDB.insertVluchten();
        PopulateDB.insertBagage();
        PopulateDB.insertGebruiker();
        PopulateDB.insertReiziger();
    }

    public static void insertBagage() {
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201623700, 'AYT', '17-Jun-2016', '19:25', 'Box', '', '', '1153481443', '', 'Cream', '', '', '', 'Curie, Versaille', '', 'Verloren')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201625439, 'AYT', '7-Sep-2016', '10:04', 'Suitcase', 'Perry Mackin', '', '1297047756', 'departure hall', 'Bluegreen', 'Violet', '80x60x40', '', 'Hauer, Bussum', 'holywood sticker', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201623923, 'AYT', '4-Jul-2016', '20:05', 'Business Case', 'Eastsport', 'CAI020', '1321391290', 'belt-05', 'Pink', 'Darkbrown', '', '', 'Verstappen, Monaco', 'red-bull sticker', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201626269, 'AYT', '9-Sep-2016', '13:18', 'Sports Bag', 'Baggallini', 'CAI724', '1557534916', 'belt-05', 'Olive', 'Darkred', '60x30x30', '15kg', 'Appelmans, De Panne', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201622445, 'AYT', '25-Nov-2015', '12:00', 'Bag', 'Baggallini', 'CAI1828', '1688722916', 'belt-04', 'Black', 'Blue', '60x30x30', '15kg', 'van Buren, Wassenaar', 'Orange stripes', 'Verloren')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201627004, 'AYT', '10-Sep-2016', '16:30', 'Suitcase', 'Ivy', '', '1957629307', 'arrival hall', 'Orange', '', '70x50x20', '', 'Kuyt, Rotterdam', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201626092, 'AYT', '9-Sep-2016', '11:56', 'Suitcase', 'Nautica', '', '1963627893', 'arrival hall', 'Yellow', 'Lightgreen', '80x60x30', '20kg', 'van Houten, Naarden', 'many scratches', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201622309, 'AYT', '20-Oct-2015', '11:50', 'Business Case', 'Ivy', 'TK2414', '2771896151', 'belt-06', 'Blue', '', '50x40x15', '10kg', 'Messi, Barcelona', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201625766, 'AYT', '8-Sep-2016', '11:29', 'Box', '', 'HV799', '2973839061', 'belt-06', 'Violet', '', '60x40x30', '15kg', 'Bonaparte, Paris', 'chain lock', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201624729, 'AYT', '23-Aug-2016', '7:30', 'Suitcase', 'Travel Gear', '', '3217712035', '', 'Lightbrown', 'Yellow', '100x60x40', '30kg', 'van Basten, Alkmaar', 'ajax stickers', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201622909, 'AYT', '13-Mar-2016', '19:23', 'Bagpack', 'Hedgren', 'TK2430', '3260024106', 'belt-05', 'Red', 'Cream', '', '', 'van der Elst, Brussel', 'football stickers', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201625105, 'AYT', '2-Sep-2016', '9:25', 'Sports Bag', 'Fjallraven', 'HV799', '3299609395', 'belt-04', 'Lightbrown', '', '60x30x30', '', '', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201622713, 'AYT', '17-Jan-2016', '14:13', 'Suitcase', 'Glove It', 'CAI724', '3794786696', 'belt-01', 'Violet', 'White', '80x60x30', '15kg', 'van Persie, Rotterdam', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201625293, 'AYT', '4-Sep-2016', '9:40', 'Business Case', 'Glove It', 'CAI1828', '4497537549', 'belt-06', 'Purple', '', '50x40x15', '10kg', 'Rutte, den Haag', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201624845, 'AYT', '24-Aug-2016', '8:10', 'Bag', 'Fjallraven', 'HV649', '4811246270', 'belt-03', 'Gray', '', '50x40x15', '10kg', 'van Buren, Wassenaar', 'Orange stripes', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201624988, 'AYT', '31-Aug-2016', '8:11', 'Bagpack', 'Travel Gear', '', '5364334705', '', 'White', '', '60x30x30', '15kg', '', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201624230, 'AYT', '19-Jul-2016', '21:05', 'Bag', 'Samsonite', '', '5703242384', 'toilet', 'Brown', '', '', '', '', 'Bicycle stickers', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201624544, 'AYT', '11-Aug-2016', '23:00', 'Business Case', 'Baggallini', 'CAI040', '5877130095', 'belt-06', 'Darkblue', '', '', '', 'Verstappen, Oss', 'red-bull sticker', 'Verloren')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201624318, 'AYT', '25-Jul-2016', '22:00', 'Box', '', 'CAI806', '5941005772', 'belt-02', 'Lightgreen', '', '', '', '', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201624133, 'AYT', '15-Jul-2016', '20:35', 'Suitcase', 'Everest', 'TK2430', '5955243509', 'belt-01', 'Lightblue', '', '60x40x20', '15kg', 'Gerritse, Ilpendam', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201624422, 'AYT', '6-Aug-2016', '22:15', 'Sports Bag', 'Samsonite', '', '6175011250', 'toilet', 'Darkbrown', '', '', '', 'de Munck, Amsterdam', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201625677, 'AYT', '8-Sep-2016', '10:17', 'Bagpack', 'Perry Mackin', '', '6327958189', 'departure hall', 'Green', '', '60x30x30', '10kg', '', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201626923, 'AYT', '10-Sep-2016', '16:00', 'Business Case', 'Everest', 'CAI806', '6377992003', 'belt-06', 'Lightblue', 'Pink', '50x40x15', '10kg', 'de Boer, Southhampton', '', 'Verloren')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201623844, 'AYT', '18-Jun-2016', '19:40', 'Sports Bag', 'Briggs', 'HV649', '6895742082', 'belt-05', 'Darkred', '', '', '', '', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201623561, 'AYT', '24-May-2016', '18:44', 'Suitcase', 'Hedgren', 'CAI806', '7620963089', 'belt-04', 'Cream', '', '70x50x20', '10kg', 'Kramer, Heerenveen', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201626563, 'AYT', '10-Sep-2016', '14:28', 'Bag', 'AmeriLeather', 'HV799', '7686938228', 'belt-02', 'Darkblue', 'Gray', '60x30x30', '10kg', '', 'Olympic rings', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201623033, 'AYT', '13-Apr-2016', '17:17', 'Bag', 'Delsey', 'CAI524', '7975308223', 'belt-01', 'Blue', 'Black', '', '', 'de Bruijn, Leiden', 'Olympic rings', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201626833, 'AYT', '10-Sep-2016', '15:50', 'Sports Bag', 'AmeriLeather', 'CAI524', '9896064347', 'belt-03', 'Darkbrown', 'Bluegreen', '60x30x30', '10kg', '', 'BRT television sticker', 'Verloren')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201625028, 'AYT', '1-Sep-2016', '9:10', 'Box', '', 'HV649', '', 'belt-01', 'Pink', '', '60x40x30', '15kg', '', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201625365, 'AYT', '6-Sep-2016', '9:58', 'Case', '', '', '', 'toilet', 'Lightgreen', 'Purple', '100x60x40', '30kg', '', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201625559, 'AYT', '7-Sep-2016', '10:13', 'Bag', 'Eastsport', 'CAI724', '', 'belt-03', 'Darkgray', 'Olive', '50x40x15', '', 'van Buren, Wassenaar', 'Orange stripes', 'Verloren')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201625897, 'AYT', '8-Sep-2016', '11:43', 'Sports Bag', 'Eastsport', 'CAI040', '', 'belt-04', 'White', '', '60x30x30', '10kg', 'Gruyaert, Antwerpen', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201625934, 'AYT', '9-Sep-2016', '11:54', 'Case', '', '', '', 'toilet', 'Gray', 'Darkgreen', '80x60x40', '25kg', '', 'red name tag', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201626139, 'AYT', '9-Sep-2016', '12:01', 'Bagpack', 'Nautica', '', '', 'arrival hall', 'Olive', 'Orange', '60x30x30', '', 'Hollande, Paris', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201622587, 'AYT', '25-Dec-2015', '12:04', 'Box', '', 'TK2430', '', 'belt-03', 'Lightgray', 'Red', '60x40x30', '', 'desting, Paris', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201626397, 'AYT', '9-Sep-2016', '13:21', 'Business Case', 'Hedgren', 'CAI020', '', 'belt-03', 'Brown', '', '50x40x15', '10kg', 'de Boer, Amsterdam', 'ajax stickers', 'Verloren')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201626438, 'AYT', '10-Sep-2016', '13:37', 'Case', '', 'CAI020', '', 'belt-01', 'Purple', 'Lightbrown', '80x60x30', '', '', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201626638, 'AYT', '10-Sep-2016', '15:31', 'Bagpack', 'Glove It', 'CAI040', '', 'belt-02', 'Bluegreen', 'Lightblue', '60x30x30', '10kg', 'Zoetemelk, Lyon', '', 'Verloren')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201626755, 'AYT', '10-Sep-2016', '15:40', 'Box', '', '', '', 'toilet', 'Darkgray', 'Darkblue', '', '', 'Mitterand, Paris', 'frech national flag sticker', 'Verloren')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201622860, 'AYT', '10-Feb-2016', '16:22', 'Case', '', '', '', 'toilet', 'Lightgray', '', '80x60x30', '15kg', '', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201623177, 'AYT', '27-Apr-2016', '17:34', 'Bagpack', 'Ivy', '', '', 'arrival hall', 'Red', 'Darkgray', '', '', 'Van Moortsel, Breda', '', 'Verloren')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201623278, 'AYT', '30-Apr-2016', '17:44', 'Box', '', '', '', '', 'Black', 'Lightgray', '', '', '', 'broken lock', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201622638, 'AYT', '25-Dec-2015', '18:09', 'Sports Bag', 'Delsey', 'CAI1828', '', 'belt-02', 'Green', 'Brown', '', '', 'Leyers, Turnhout', '', 'Verloren')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201623320, 'AYT', '3-May-2016', '18:10', 'Business Case', 'Fjallraven', 'CAI524', '', 'belt-05', 'Orange', 'Green', '', '', '', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201623455, 'AYT', '14-May-2016', '18:37', 'Case', '', '', '', 'departure hall', 'Darkgreen', '', '70x50x20', '20kg', '', 'duvel sticker', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201623632, 'AYT', '4-Jun-2016', '19:20', 'Bag', 'Briggs', 'TK2414', '', 'belt-04', 'Yellow', '', '', '', 'van den Hoogenband, Eindhoven', 'Olympic rings', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201624064, 'AYT', '9-Jul-2016', '20:18', 'Case', '', '', '', 'arrival hall', 'Darkred', '', '70x50x20', '10kg', 'de Munck, Brugge', '', 'Gevonden')");
        myJDBC.executeUpdateQuery("INSERT INTO Bagage VALUES(201624665, 'AYT', '17-Aug-2016', '21:45', 'Bagpack', 'Everest', 'TK2414', '', 'belt-02', 'Darkgreen', '', '', '', 'van der Sande, Wuustwezel', '', 'Gevonden')");
    }

    public static void insertReiziger() {
        myJDBC.executeUpdateQuery("INSERT INTO Reizigers VALUES(1623700, 'Frank', 'de Boer', 'Southhampton', 'Pos Chikito 53', 'Aruba', '5964004', 'bomamasuemail@gmail.com', 'AMS', 201624665)");
        myJDBC.executeUpdateQuery("INSERT INTO Reizigers VALUES(1234123, 'Josephine', 'van der Sande', 'Wuustwezelsc', 'Pos Chikito 53', 'Aruba', '5964004', 'bomamasuemail@gmail.com', 'AMS', 1234)");
        myJDBC.executeUpdateQuery("INSERT INTO Reizigers VALUES(2141234, 'Yvonne', 'van den Hoogenband', 'Eindhoven', 'Pos Chikito 53', 'Aruba', '5964004', 'bomamasuemail@gmail.com', 'AMS', 5432)");
        myJDBC.executeUpdateQuery("INSERT INTO Reizigers VALUES(52345, 'Geraldine', 'Van Moortsel', 'Breda', 'Pos Chikito 53', 'Aruba', '5964004', 'bomamasuemail@gmail.com', 'AMS', 2345)");
        myJDBC.executeUpdateQuery("INSERT INTO Reizigers VALUES(2354245, 'Danny', 'de Munck', 'Brugge', 'Pos Chikito 53', 'Aruba', '5964004', 'bomamasuemail@gmail.com', 'AMS', 7467)");
        myJDBC.executeUpdateQuery("INSERT INTO Reizigers VALUES(453532, 'Josephine', 'Kendrata', 'Amsterdam', 'Pos Chikito 53', 'Aruba', '5964004', 'bomamasuemail@gmail.com', 'AMS', 76576)");
        myJDBC.executeUpdateQuery("INSERT INTO Reizigers VALUES(2354234, 'Josephine', 'Kendrata', 'Amsterdam', 'Pos Chikito 53', 'Aruba', '5964004', 'bomamasuemail@gmail.com', 'AMS', 3321564)");
    }

    public static void insertGebruiker() {
        myJDBC.executeUpdateQuery("INSERT INTO Gebruikers VALUES(123456789, 'A. F. G', 'Anouk', 'Klouw', 'Muller', '10-07-1990', '01-01-2015', 'thisemail@email.com', 'Amsterdam', 'Working', null, 'thatemail@email.com', '0645188667', null, 'Manager', 'Rooi Bosal 49', '4513 BJ')");
        myJDBC.executeUpdateQuery("INSERT INTO Gebruikers VALUES(21123432, 'H. F. G', 'Regina', 'Plop', 'Croes', '19-05-1970', '01-01-2015', 'thisemail@email.com', 'Den Haag', 'Working', '', 'thatemail@email.com', '0645188667', '', 'Balie Medewerker', 'Perikweg 3', '4513 BJ')");
        myJDBC.executeUpdateQuery("INSERT INTO Gebruikers VALUES(45646545, 'S. J. J', 'Butchi', '', 'Britt', '10-07-1980', '01-01-2015', 'thisemail@email.com', 'Santa Cruz', 'Working', '', 'thatemail@email.com', '0645188667', '', 'Admin', 'Cleynderweg 6', '4513 BJ')");
        myJDBC.executeUpdateQuery("INSERT INTO Gebruikers VALUES(67853445, 'Q. G. D', 'Barbara', 'Diest', 'Delaquest', '10-05-1996', '01-01-2015', 'thisemail@email.com', 'Urataka', 'Working', '', 'thatemail@email.com', '0645188667', '', 'Balie Medewerker', 'Cas Ariba 14', '4513 BJ')");
    }

    public static void insertBagageTypes() {
        myJDBC.executeUpdateQuery("INSERT INTO BagageTypes VALUES(1, 'Suitcase', 'Koffer', 'Maleta', 'Bavul')");
        myJDBC.executeUpdateQuery("INSERT INTO BagageTypes VALUES(2, 'Bag', 'Tas', 'Bolsa', 'Canta')");
        myJDBC.executeUpdateQuery("INSERT INTO BagageTypes VALUES(3, 'Bagpack', 'Rugzak', 'Mochila', 'Sırt çantası')");
        myJDBC.executeUpdateQuery("INSERT INTO BagageTypes VALUES(4, 'Box', 'Doos', 'Caja', 'Kutu')");
        myJDBC.executeUpdateQuery("INSERT INTO BagageTypes VALUES(5, 'Sports Bag', 'Sporttas', 'Bolsa Deportiva', 'Spor çantası')");
        myJDBC.executeUpdateQuery("INSERT INTO BagageTypes VALUES(6, 'Business Case', 'Zakenkoffer', 'Maletín', 'Iş çantası')");
        myJDBC.executeUpdateQuery("INSERT INTO BagageTypes VALUES(7, 'Case', 'Kist', 'Pecho', 'Göğüs')");
        myJDBC.executeUpdateQuery("INSERT INTO BagageTypes VALUES(8, 'Other', 'Anders', 'Otro', 'Diğer')");
    }

    public static void insertLocaties() {
        myJDBC.executeUpdateQuery("INSERT INTO Locaties VALUES(1, 'belt-06', 'belt-06', 'correa-06', 'kayışı-06')");
        myJDBC.executeUpdateQuery("INSERT INTO Locaties VALUES(2, 'belt-05', 'belt-05', 'correa-05', 'kayışı-05')");
        myJDBC.executeUpdateQuery("INSERT INTO Locaties VALUES(3, 'belt-04', 'belt-04', 'correa-04', 'kayışı-04')");
        myJDBC.executeUpdateQuery("INSERT INTO Locaties VALUES(4, 'belt-03', 'belt-03', 'correa-03', 'kayışı-03')");
        myJDBC.executeUpdateQuery("INSERT INTO Locaties VALUES(5, 'belt-02', 'belt-02', 'correa-02', 'kayışı-02')");
        myJDBC.executeUpdateQuery("INSERT INTO Locaties VALUES(6, 'belt-01', 'belt-01', 'correa-01', 'kayışı-01')");
        myJDBC.executeUpdateQuery("INSERT INTO Locaties VALUES(7, 'departure hall', 'departure hall', 'sala de salida', 'kalkış salonu')");
        myJDBC.executeUpdateQuery("INSERT INTO Locaties VALUES(8, 'arrival hall', 'arrival hall', 'sala de llegada', 'varış salonu')");
        myJDBC.executeUpdateQuery("INSERT INTO Locaties VALUES(9, 'toilet', 'toilet', 'baño', 'tuvalet')");
    }

    public static void insertKleuren() {
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(1003, 'Yellow', 'Geel', 'Amarillo', 'Sarı')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(1024, 'Olive', 'Olijf', 'Verde oliva', 'Zeytin yeşili')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(2004, 'Orange', 'Oranje', 'Naranja', 'Turuncu')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(3000, 'Red', 'Rood', 'Rojo  ', 'Kırmızı')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(3005, 'Darkred', 'Donkerrood', 'Rojo oscuro', 'Koyu kırmızı')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(3017, 'Pink', 'Roze', 'Rosa', 'Pembe')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(4005, 'Purple', 'Paars', 'Morado', 'Mor')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(4010, 'Violet', 'Violet', 'Violeta', 'Menekşe')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(5002, 'Blue', 'Blauw', 'Azul', 'Mavi')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(5015, 'Lightblue', 'Lichtblauw', 'Azul claro', 'Açık  mavi')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(5022, 'Darkblue', 'Donkerblauw', 'Azul oscuro', 'Koyu mavi')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(6004, 'Bluegreen', 'Blauwgroen', 'Azul verde', 'çamurcun')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(6002, 'Green', 'Groen', 'Verde', 'Yeşil')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(6022, 'Darkgreen', 'Donkergroen', 'Verde oscuro', 'Koyu yeşil')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(6038, 'Lightgreen', 'Lichtgroen', 'Verde claro', 'Açık  yeşil')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(7015, 'Gray', 'Grijs', 'Gris', 'Gri')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(9011, 'Darkgray', 'Donkergrijs', 'Gris oscuro', 'Koyu gri')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(7000, 'Lightgray', 'Lichtgrijs', 'Gris claro', 'Açık gri')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(8002, 'Brown', 'Bruin', 'Marrón', 'Kahverengi')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(8011, 'Darkbrown', 'Donkerbruin', 'Marrón oscuro', 'Koyu kahverengi')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(8023, 'Lightbrown', 'Lichtbruin', 'Marrón claro', 'Açık kahverengi')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(9001, 'White', 'Wit', 'Blanco', 'Beyaz')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(9005, 'Black', 'Zwart', 'Negro', 'Siyah')");
        myJDBC.executeUpdateQuery("INSERT INTO Kleuren VALUES(1015, 'Cream', 'Crème', 'Crema', 'Krem')");
    }

    public static void insertVluchten() {
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(1, 'Transavia', 'HV649', 'Amsterdam', 'Antalya')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(2, 'Transavia', 'HV799', 'Amsterdam', 'Antalya')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(3, 'Transavia', 'HV740', 'Antalya', 'Amsterdam')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(4, 'Transavia', 'HV650', 'Antalya', 'Amsterdam')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(5, 'Pegasus', 'PC5665', 'Antalya', 'Amsterdam')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(6, 'Corendon', 'CAI524', 'Brussels', 'Antalya')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(7, 'Corendon', 'CAI1827', 'Antalya', 'Brussels')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(8, 'Corendon', 'CAI1828', 'Brussels', 'Antalya')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(9, 'Corendon', 'CAI421', 'Antalya', 'Brussels')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(10, 'Corendon', 'CAI724', 'Brussels', 'Antalya')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(11, 'Corendon', 'CAI723', 'Antalya', 'Brussels')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(12, 'Corendon', 'CAI040', 'Eindhoven', 'Antalya')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(13, 'Corendon', 'CAI041', 'Antalya', 'Eindhoven')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(14, 'Transavia', 'HV6115', 'Amsterdam', 'Malaga')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(15, 'Transavia', 'HV6224', 'Malaga', 'Amsterdam')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(16, 'Transavia', 'TO3160', 'Paris', 'Malaga')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(17, 'Transavia', 'TO3163', 'Malaga', 'Paris')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(18, 'Transavia', 'TO3002', 'Paris', 'Agadir')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(19, 'Transavia', 'TO3005', 'Agadir', 'Paris')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(20, 'Transavia', 'HV355', 'Amsterdam', 'Bodrum')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(21, 'Transavia', 'HV356', 'Bodrum', 'Amsterdam')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(22, 'Corendon', 'CND513', 'Amsterdam', 'Heraklion')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(23, 'Corendon', 'CND593', 'Amsterdam', 'Malaga')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(24, 'Corendon', 'CND117', 'Amsterdam', 'Malaga')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(25, 'Corendon', 'CAI020', 'Amsterdam', 'Antalya')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(26, 'Corendon', 'CAI806', 'Amsterdam', 'Antalya')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(27, 'Corendon', 'CND513', 'Amsterdam', 'Heraklion')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(28, 'Corendon', 'CND712', 'Heraklion ', 'Amsterdam')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(29, 'Corendon', 'CND118', 'Malaga', 'Amsterdam')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(30, 'Corendon', 'CND594', 'Malaga', 'Amsterdam')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(31, 'Corendon', 'CAI023', 'Antalya', 'Amsterdam')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(32, 'Corendon', 'CAI805', 'Antalya', 'Amsterdam')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(33, 'Corendon', 'CAI021', 'Antalya', 'Amsterdam')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(34, 'Vueling', 'VY2151', 'Brussels', 'Malaga')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(35, 'Vueling', 'VY2150', 'Malaga', 'Brussels')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(36, 'KLM', 'KL1039', 'Amsterdam', 'Malaga')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(37, 'KLM', 'KL1040', 'Malaga', 'Amsterdam')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(38, 'KLM', 'KL1041', 'Amsterdam', 'Malaga')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(39, 'KLM', 'KL1042', 'Malaga', 'Amsterdam')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(40, 'Corendon', 'CAI202', 'Amsterdam', 'Bodrum')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(41, 'Corendon', 'CAI201', 'Bodrum', 'Amsterdam')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(42, 'Turkish Airlines', 'TK1942', 'Brussels', 'Istanbul')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(43, 'Turkish Airlines', 'TK1943', 'Istanbul', 'Brussels')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(44, 'Turkish Airlines', 'TK1938', 'Brussels', 'Istanbul')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(45, 'Turkish Airlines', 'TK1939', 'Istanbul', 'Brussels')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(46, 'Turkish Airlines', 'TK1952', 'Amsterdam', 'Istanbul')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(47, 'Turkish Airlines', 'TK1951', 'Istanbul', 'Amsterdam')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(48, 'Turkish Airlines', 'TK1958', 'Amsterdam', 'Istanbul')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(49, 'Turkish Airlines', 'TK1955', 'Istanbul', 'Amsterdam')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(50, 'Turkish Airlines', 'TK1830', 'Paris', 'Istanbul')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(51, 'Turkish Airlines', 'TK1823', 'Istanbul', 'Paris')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(52, 'Turkish Airlines', 'TK1824', 'Paris', 'Istanbul')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(53, 'Turkish Airlines', 'TK1827', 'Istanbul', 'Paris')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(54, 'Turkish Airlines', 'TK2430', 'Istanbul', 'Antalya')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(55, 'Turkish Airlines', 'TK2414', 'Istanbul', 'Antalya')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(56, 'Turkish Airlines', 'TK2425', 'Antalya', 'Istanbul')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(57, 'Turkish Airlines', 'TK2409', 'Antalya', 'Istanbul')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(58, 'Turkish Airlines', 'TK2510', 'Istanbul', 'Bodrum')");
        myJDBC.executeUpdateQuery("INSERT INTO Vluchten VALUES(59, 'Turkish Airlines', 'TK2505', 'Bodrum', 'Instanbul')");
    }

    public static void insertLuchthaven() {
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('AMS', 'Amsterdam', 'The Netherlands', 1, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('AYT', 'Amsterdam', 'Turkey', 3, 'FALSE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('IST', 'Amsterdam', 'Turkey', 3, 'FALSE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('BJV', 'Amsterdam', 'Turkey', 3, 'FALSE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('DLM', 'Amsterdam', 'Turkey', 3, 'FALSE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('ADB', 'Amsterdam', 'Turkey', 3, 'FALSE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('GZP', 'Amsterdam', 'Turkey', 3, 'FALSE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('ECN', 'Amsterdam', 'Cyprus (North)', 2, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('RAK', 'Amsterdam', 'Morocco', 0, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('HER', 'Amsterdam', 'Greece', 2, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('KGS', 'Amsterdam', 'Greece', 2, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('RHO', 'Amsterdam', 'Greece', 2, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('ZTH', 'Amsterdam', 'Greece', 2, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('CFU', 'Amsterdam', 'Greece', 2, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('MJT', 'Amsterdam', 'Greece', 2, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('OHD', 'Amsterdam', 'Macedonia', 1, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('SMI', 'Amsterdam', 'Greece', 2, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('LPA', 'Amsterdam', 'Spain', 0, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('TFO', 'Amsterdam', 'Spain', 0, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('PMI', 'Amsterdam', 'Spain', 0, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('AGP', 'Amsterdam', 'Spain', 0, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('FUE', 'Amsterdam', 'Spain', 0, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('FAO', 'Amsterdam', 'Portugal', 0, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('ACE', 'Amsterdam', 'Spain', 0, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('HRG', 'Amsterdam', 'Egypt', 2, 'FALSE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('NBE', 'Amsterdam', 'Tunesië', 1, 'FALSE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('DXB', 'Amsterdam', 'United Arab Emirates', 4, 'FALSE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('BOJ', 'Amsterdam', 'Bulgaria', 2, 'TRUE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('BJL', 'Amsterdam', 'Gambia', 0, 'FALSE')");
        myJDBC.executeUpdateQuery("INSERT INTO LuchtHaven VALUES('CTA', 'Amsterdam', 'Italy', 1, 'TRUE')");
    }

}
