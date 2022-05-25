package spsmb.sqlite;
// Převeďte data z https://onemocneni-aktualne.mzcr.cz/api/v2/covid-19
// (COVID-19: Přehled osob s prokázanou nákazou dle hlášení krajských
// hygienických stanic (v2)).
// K nalezení zde: X:\stemberk\verejne_zaci\osoby.csv
// do databáze (můžete si vybrat mezi SQLite, či MySQL).
// Totéž proveďte pro soubor X:\stemberk\verejne_zaci\staty.csv a zobrazte
// v TableView, případně v nějakém grafu JavaFX.

// Vytvořte další TableView, které bude ze stejných dat zobrazovat následující souhrn
// po dnech: datum, průměrný věk, počet mužů, počet žen, celkový počet

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Struktura tabulky:
 * id,datum,vek,pohlavi,kraj_nuts_kod,okres_lau_kod,nakaza_v_zahranici,nakaza_zeme_csu_kod,reportovano_khs
 * 1ea976a2-896a-40b2-b617-b780a713323d,2020-03-01,43,M,CZ042,CZ0421,1,IT,1
 */
public class FUkol {
    public static void main(String[] args) throws IOException {
        FileReader fr = null;
        String radka;
        int cnt = 0;
        fr = new FileReader("Y:\\stemberk\\verejne_zaci\\osoby.csv");
        BufferedReader br = new BufferedReader(fr);
        br.readLine(); // prvni radku zahodime;

        while((radka = br.readLine()) != null) {
            String id = "";
            String datum = "";
            int vek = 0;
            String mf = "";
            String kraj = "";
            String okres = "";
            Boolean vZahranici = false;
            String stat = "";
            Boolean reportovanoKhs = false;

            String[] hodnoty = radka.split(",");
            if(hodnoty.length > 0 ) id = hodnoty[0];
            if(hodnoty.length > 1 ) datum = hodnoty[1];
            if(hodnoty.length > 2 ) vek = Integer.parseInt(hodnoty[2]);
            if(hodnoty.length > 3 ) mf = hodnoty[3];
            if(hodnoty.length > 4 ) kraj = hodnoty[4];
            if(hodnoty.length > 5 ) okres = hodnoty[5];
            if(hodnoty.length > 6 ) vZahranici = Boolean.parseBoolean(hodnoty[6]);
            if(hodnoty.length > 7 ) stat = hodnoty[7];
            if(hodnoty.length > 8 ) reportovanoKhs = Boolean.parseBoolean(hodnoty[8]);
            System.out.format("%s, %s, %d, %s, %s, %s, %b, %s, %b%n",
                    id, datum, vek, mf, kraj, okres, vZahranici, stat, reportovanoKhs);
            if (cnt++ > 10) break;
        }
    }
}
