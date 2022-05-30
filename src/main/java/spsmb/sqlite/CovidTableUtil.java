package spsmb.sqlite;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CovidTableUtil {
    public static ObservableList<Covid> getCovidList() {
        ObservableList<Covid> ret = FXCollections.<Covid>observableArrayList();
        Connection c = AMainDBConn.connect();
        String sql = "SELECT datum, AVG(vek) AS prumerny_vek," +
                " (SELECT COUNT(*) FROM Covid AS c2 WHERE pohlavi LIKE 'M' AND c2.datum = c1.datum) AS pocet_muzi," +
                " (SELECT COUNT(*) FROM Covid AS c2 WHERE pohlavi LIKE 'Z' AND c2.datum = c1.datum) AS pocet_zeny," +
                " COUNT(*) AS celkovy_pocet" +
                " FROM Covid AS c1 GROUP BY datum;";
        try (Statement st = c.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            int cnt = 0;
            while (rs.next()) {
                ret.add(new Covid(rs.getString("datum"),
                        rs.getDouble("prumerny_vek"),
                        rs.getInt("pocet_muzi"),
                        rs.getInt("pocet_zeny"),
                        rs.getInt("celkovy_pocet")));
                //System.out.format("id:%d, nakaza_v_zahranici:%b, nakaza_zeme_csu_kod:%s %n", rs.getInt("id"), rs.getBoolean("nakaza_v_zahranici"), rs.getString("nakaza_zeme_csu_kod"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Warehouse p1 = new Warehouse(0, "Sharan", 4000 );
        return ret; //FXCollections.<Warehouse>observableArrayList(p1);
    }

    public static TableColumn<Covid, String> getDatum() {
        TableColumn<Covid, String> personIdCol = new TableColumn<>("datum");
        personIdCol.setCellValueFactory(new PropertyValueFactory<>("datum"));
        return personIdCol;
    }

    public static TableColumn<Covid, Double> getPrumer() {
        TableColumn<Covid, Double> personIdCol = new TableColumn<>("prumer_vek");
        personIdCol.setCellValueFactory(new PropertyValueFactory<>("prumer_vek"));
        return personIdCol;
    }

    public static TableColumn<Covid, Integer> getMuzi() {
        TableColumn<Covid, Integer> personIdCol = new TableColumn<>("pocet_muzi");
        personIdCol.setCellValueFactory(new PropertyValueFactory<>("pocet_muzi"));
        return personIdCol;
    }

    public static TableColumn<Covid, Integer> getZeny() {
        TableColumn<Covid, Integer> personIdCol = new TableColumn<>("pocet_zeny");
        personIdCol.setCellValueFactory(new PropertyValueFactory<>("pocet_zeny"));
        return personIdCol;
    }

    public static TableColumn<Covid, Integer> getCelkem() {
        TableColumn<Covid, Integer> personIdCol = new TableColumn<>("celkovy_pocet");
        personIdCol.setCellValueFactory(new PropertyValueFactory<>("celkovy_pocet"));
        return personIdCol;
    }


}
