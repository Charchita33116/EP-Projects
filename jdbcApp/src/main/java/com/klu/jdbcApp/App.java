package com.klu.jdbcApp;

import java.sql.*;

public class App 
{
    public static void main( String[] args )
    {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "Chand1807#";
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            // Load and register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            con = DriverManager.getConnection(url, username, password);
            
            // Create statement
            stmt = con.createStatement();
            
            // Execute query
            rs = stmt.executeQuery("SELECT * FROM klustudents");
            
            // Process result set
            while(rs.next()) {
                System.out.println("Student ID: " + rs.getInt(1));
                System.out.println("Student Name: " + rs.getString(2));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
