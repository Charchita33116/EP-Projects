package com.klu.jdbcApp;

import java.sql.*;

public class App1 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "Chand1807#";

        Connection con = null;
        PreparedStatement pstmtInsert = null;
        PreparedStatement pstmtDelete = null;

        try {
            // Establish the connection
            con = DriverManager.getConnection(url, username, password);

            // Create a prepared statement for insertion
            String queryInsert = "INSERT INTO klustudents (sid, sname) VALUES (?, ?)";
            pstmtInsert = con.prepareStatement(queryInsert);

            // Set the parameters for insertion
            pstmtInsert.setInt(1, 200);
            pstmtInsert.setString(2, "Manish");

            // Execute the prepared statement for insertion
            int rowsAffectedInsert = pstmtInsert.executeUpdate();
            System.out.println("Rows affected by insertion: " + rowsAffectedInsert);

            // Create a prepared statement for deletion
            String queryDelete = "DELETE FROM klustudents WHERE sid = ?";
            pstmtDelete = con.prepareStatement(queryDelete);

            // Set the parameter for deletion
            pstmtDelete.setInt(1, 1011);

            // Execute the prepared statement for deletion
            int rowsAffectedDelete = pstmtDelete.executeUpdate();
            System.out.println("Rows affected by deletion: " + rowsAffectedDelete);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close the resources
            try {
                if (pstmtInsert != null) pstmtInsert.close();
                if (pstmtDelete != null) pstmtDelete.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
