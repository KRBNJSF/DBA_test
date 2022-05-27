package spsmb.w32.sqlite;
// Převeďte data z https://onemocneni-aktualne.mzcr.cz/api/v2/covid-19
// (COVID-19: Přehled osob s prokázanou nákazou dle hlášení krajských
// hygienických stanic (v2)).
// K nalezení zde: X:\stemberk\verejne_zaci\osoby.csv
// do databáze (můžete si vybrat mezi SQLite, či MySQL).
// Totéž proveďte pro soubor C:\stemberk\verejne_zaci\staty.csv a zobrazte
// v TableView, případně v nějakém grafu JavaFX.

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Struktura tabulky:
 * id,datum,vek,pohlavi,kraj_nuts_kod,okres_lau_kod,nakaza_v_zahranici,nakaza_zeme_csu_kod,reportovano_khs
 * 1ea976a2-896a-40b2-b617-b780a713323d,2020-03-01,43,M,CZ042,CZ0421,1,IT,1
 */
public class FUkol {
    public static void createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            //Class.forName("org.w32.sqlite.JDBC");
            //c = DriverManager.getConnection("jdbc:w32.sqlite:SqliteJavaDB.db");
            c = AMainDBConn.connect();
            System.out.println("Database Opened...\n");
            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Covid " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " id2 varchar(50), " +
                    " datum varchar (50), " +
                    " vek int, " +
                    " pohlavi varchar (25), " +
                    " kraj_nuts_kod varchar (10), " +
                    " okres_lau_kod varchar (20), " +
                    " nakaza_v_zahranici bit , " +
                    " nakaza_zeme_csu_kod varchar(10) , " +
                    " reportovano_khs bit)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table Product Created Successfully!!!");
    }
    public static  void insert(String id2, String datum, Integer vek, String pohlavi, String kraj_nuts_kod, String okres_lau_kod, Boolean nakaza_v_zahranici, String nakaza_zeme_csu_kod, Boolean reportovano_khs) {
        String sql = "INSERT INTO Covid(id2, datum, vek, pohlavi, kraj_nuts_kod, okres_lau_kod, nakaza_v_zahranici, nakaza_v_zahranici, reportovano_khs)" +
                " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = AMainDBConn.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id2);
            pstmt.setString(2, datum);
            pstmt.setInt(3, vek);
            pstmt.setString(4, pohlavi);
            pstmt.setString(5, kraj_nuts_kod);
            pstmt.setString(6, okres_lau_kod);
            pstmt.setBoolean(7, nakaza_v_zahranici);
            pstmt.setString(8, nakaza_zeme_csu_kod);
            pstmt.setBoolean(9, reportovano_khs);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) throws IOException {
        FUkol.createTable();
        FileReader fr = null;
        String radka;
        int cnt = 0;
        fr = new FileReader("C:\\Users\\anoni\\OneDrive\\Dokumenty\\Do_Školy\\programko-stembi\\DB_test\\src\\main\\java\\spsmb\\w32\\osoby.csv");
        BufferedReader br = new BufferedReader(fr);
        while ((radka = br.readLine()) != null){

            String[] hodnoty = radka.split(",");
            System.out.println(radka);
            System.out.format("%s -- %s %s %d %n", hodnoty[0], hodnoty[1], hodnoty[2], hodnoty.length);
            if (cnt++ > 0) {
                if (hodnoty.length > 6){
                    FUkol.insert(hodnoty[0], hodnoty[1], Integer.parseInt(hodnoty[2]), hodnoty[3], hodnoty[4], hodnoty[5], Boolean.parseBoolean(hodnoty[6]), hodnoty[7], Boolean.parseBoolean(hodnoty[8]));
                } else if(hodnoty.length < 6) {
                    FUkol.insert(hodnoty[0], hodnoty[1], Integer.parseInt(hodnoty[2]), hodnoty[3], null, null, Boolean.FALSE, null, Boolean.FALSE);
                }
                else {
                    FUkol.insert(hodnoty[0], hodnoty[1], Integer.parseInt(hodnoty[2]), hodnoty[3], hodnoty[4], hodnoty[5], Boolean.FALSE, null, Boolean.FALSE);
                }
            }
            if (cnt > 150) break;
        }

    }
}
