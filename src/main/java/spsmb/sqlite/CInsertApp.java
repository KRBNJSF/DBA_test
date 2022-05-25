package spsmb.sqlite;

import java.sql.*;

public class CInsertApp {

    /**
     * Insert a new row into the warehouse table
     *
     * @param name
     * @param capacity
     */
    public void insert(String name, double capacity) {
        String sql = "INSERT INTO warehouse(name, capacity) VALUES(?, ?)";

        try (Connection conn = spsmb.sqlite.AMainDBConn.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Insert a new row into the warehouse table, it return new id creted during insert.
     *
     * @param name
     * @param capacity
     * @returns id
     */
    public long insertReturningId(String name, double capacity) {
        String sql = "INSERT INTO warehouse(name, capacity) VALUES(?, ?)";
        long returnValue = -1;
        try (Connection conn = spsmb.sqlite.AMainDBConn.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    returnValue = generatedKeys.getLong(1);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return returnValue;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CInsertApp app = new CInsertApp();
        // insert three new rows
        app.insert("Raw Materials", 3000);
        app.insert("Semifinished Goods", 4000);
        app.insert("Finished Goods", 5000);
        System.out.println("odpad ma id " + app.insertReturningId("Waste", 1000));
    }

}
