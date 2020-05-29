/*
Question Link - 
*/
package Database;

import java.io.*;
import java.sql.*;
import java.util.*;

public class JDBCConnection {
    Connection connection;
    JDBCConnection() {
        String url= "jdbc:mysql://localhost:3306/ecommercedatabase";
        String username="root";
        String password="ishanr786";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection= DriverManager.getConnection(url, username, password);
            Statement statement= connection.createStatement();
            System.out.println("Connection Established !");
//            viewAllRecords(statement);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    private static void viewAllRecords(Statement statement) throws SQLException {
        displayRecords("users", statement);
        displayRecords("products", statement);
        displayRecords("orders", statement);
    }

    private static void displayRecords(String tableName, Statement statement) throws SQLException {
        System.out.println("Displaying contents of table: "+tableName);
        String sql= "Select * from "+tableName;
        ResultSet resultSet= statement.executeQuery(sql);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = resultSet.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
    }
}