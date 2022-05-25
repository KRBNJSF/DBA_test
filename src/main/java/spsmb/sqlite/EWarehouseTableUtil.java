package spsmb.sqlite;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import spsmb.Warehouse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EWarehouseTableUtil {
    /* Returns an observable list of persons */
    public static ObservableList<Warehouse> getWarehouseList() {
        ObservableList<Warehouse> ret = FXCollections.<Warehouse>observableArrayList();
        Connection c = AMainDBConn.connect();
        String sql = "SELECT * FROM warehouse;";
        try (Statement st = c.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            int cnt = 0;
            while(rs.next()) {
                System.out.println(cnt++);
                //System.out.format("id:%d, name: %s, c:%d%n", rs.getInt("id"), rs.getString("name"), rs.getInt("capacity"));
                //System.out.println(new Warehouse(rs.getInt("id"), rs.getString("name"), rs.getInt("capacity")).toString());
                ret.add(new Warehouse(rs.getInt("id"), rs.getString("name"), rs.getInt("capacity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Warehouse p1 = new Warehouse(0, "Sharan", 4000 );
        return ret; //FXCollections.<Warehouse>observableArrayList(p1);
    }

    /* Returns Id TableColumn */
    public static TableColumn<Warehouse, Integer> getIdColumn() {
        TableColumn<Warehouse, Integer> personIdCol = new TableColumn<>("id");
        personIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        return personIdCol;
    }

    /* Returns Name TableColumn */
    public static TableColumn<Warehouse, String> getNameColumn() {
        TableColumn<Warehouse, String> fNameCol = new TableColumn<>("name");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        return fNameCol;
    }

    /* Returns Last Name TableColumn */
    public static TableColumn<Warehouse, String> getCapacityColumn() {
        TableColumn<Warehouse, String> lastNameCol = new TableColumn<>("capacity");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        return lastNameCol;
    }

}
