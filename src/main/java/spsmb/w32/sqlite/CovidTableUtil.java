package spsmb.w32.sqlite;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class CovidTableUtil {
    public static ObservableList<Covid> getCovidList() {
        ObservableList<Covid> ret = FXCollections.<Covid>observableArrayList();
        Connection c = AMainDBConn.connect();
        String sql = "SELECT * FROM Covid;";
        try (Statement st = c.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            int cnt = 0;
            while(rs.next()) {
                ret.add(new Covid(rs.getInt("id"),
                        rs.getString("id2"),
                        rs.getString("datum"),
                        rs.getInt("vek"),
                        rs.getString("pohlavi"),
                        rs.getString("kraj_nuts_kod"),
                        rs.getString("okres_lau_kod"),
                        rs.getBoolean("nakaza_v_zahranici"),
                        rs.getString("nakaza_zeme_csu_kod"),
                        rs.getBoolean("reportovano_khs")));
                System.out.format("id:%d, nakaza_v_zahranici:%b, nakaza_zeme_csu_kod:%s %n", rs.getInt("id"), rs.getBoolean("nakaza_v_zahranici"), rs.getString("nakaza_zeme_csu_kod"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Warehouse p1 = new Warehouse(0, "Sharan", 4000 );
        return ret; //FXCollections.<Warehouse>observableArrayList(p1);
    }

    public static TableColumn<Covid, Integer> getIdColumn() {
        TableColumn<Covid, Integer> personIdCol = new TableColumn<>("id");
        personIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        return personIdCol;
    }

    public static TableColumn<Covid, String> getId2Column() {
        TableColumn<Covid, String> fNameCol = new TableColumn<>("id2");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("id2"));
        return fNameCol;
    }

    public static TableColumn<Covid, String> getDatumColumn() {
        TableColumn<Covid, String> fNameCol = new TableColumn<>("datum");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("datum"));
        return fNameCol;
    }

    public static TableColumn<Covid, Integer> getVekColumn() {
        TableColumn<Covid, Integer> personIdCol = new TableColumn<>("vek");
        personIdCol.setCellValueFactory(new PropertyValueFactory<>("vek"));
        return personIdCol;
    }

    public static TableColumn<Covid, String> getPohlaviColumn() {
        TableColumn<Covid, String> fNameCol = new TableColumn<>("pohlavi");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("pohlavi"));
        return fNameCol;
    }

    public static TableColumn<Covid, String> getKraj_nuts_kodColumn() {
        TableColumn<Covid, String> fNameCol = new TableColumn<>("kraj_nuts_kod");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("kraj_nuts_kod"));
        return fNameCol;
    }

    public static TableColumn<Covid, String> getOkres_lau_kodColumn() {
        TableColumn<Covid, String> fNameCol = new TableColumn<>("okres_lau_kod");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("okres_lau_kod"));
        return fNameCol;
    }

    public static TableColumn<Covid, Boolean> getNakaza_v_zahraniciColumn() {
        TableColumn<Covid, Boolean> fNameCol = new TableColumn<>("nakaza_v_zahranici");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("nakaza_v_zahranici"));
        return fNameCol;
    }

    public static TableColumn<Covid, String> getNakaza_zeme_csu_kodColumn() {
        TableColumn<Covid, String> fNameCol = new TableColumn<>("nakaza_zeme_csu_kod");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("nakaza_zeme_csu_kod"));
        return fNameCol;
    }

    public static TableColumn<Covid, Boolean> getReportovano_khsColumn() {
        TableColumn<Covid, Boolean> fNameCol = new TableColumn<>("reportovano_khs");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("reportovano_khs"));
        return fNameCol;
    }


}
