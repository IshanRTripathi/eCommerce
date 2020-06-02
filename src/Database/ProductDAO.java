/*
Question Link - 
*/
package Database;

import Models.Product;

import java.io.*;
import java.sql.*;
import java.util.*;

public class ProductDAO {
    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;
    private List<Product> products;
    public ProductDAO() {
        String url= "jdbc:mysql://localhost:3306/ecommercedatabase";
        String username="root";
        String password="ishanr786";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection= DriverManager.getConnection(url, username, password);
//            this.statement= connection.prepareStatement("SELECT * from products");
            System.out.println("Database Connection Established !");
//            viewAllRecords(statement);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public int addToCart(int productID) {
        int i = 0;
        try {
            this.statement = this.connection.prepareStatement("Insert into cart(productid, customerid) values(?,?)");
            this.statement.setInt(1, productID);
            this.statement.setInt(2, 1);
            i=statement.executeUpdate();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return i;
    }
    public List<Product> getItemsFromCart()
    {
        List<Product> res= new ArrayList<>();
        try{
            /*this.statement= this.connection.prepareStatement("SELECT * from cart where customerID =1");
            this.resultSet= statement.executeQuery();
            while(resultSet.next())
                res.add(resultSet.getInt(1));*/

            this.statement= this.connection.prepareStatement("Select * from products\n" +
                    "inner join cart\n" +
                    "where products.productid = cart.productid");
            this.resultSet= statement.executeQuery();
            while (resultSet.next())
            {
                res.add(new Product(resultSet.getInt("products.productid"),
                        resultSet.getString("productname"),resultSet.getString("productdescription"),
                        resultSet.getInt("units"), resultSet.getString("category"),
                        resultSet.getDouble("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<Product> getAllProducts(){
        this.products= new ArrayList<>();
        try{
            this.statement= this.connection.prepareStatement("SELECT * from products");
            this.resultSet= this.statement.executeQuery();
            while(resultSet.next())
            {
                products.add(new Product(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4),resultSet.getString(5), resultSet.getDouble(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
/*

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
*/

    public int findCartSize() {
        int size = 0;
        try {

            this.statement = this.connection.prepareStatement("SELECT count(*) from cart WHERE customerID = 1");

            this.resultSet = this.statement.executeQuery();

            if(resultSet.next()) {
                size = resultSet.getInt(1);
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return size;
    }

    public int removeFromCart(int orderID) {
        int i = 0;
        System.out.println("Removing "+orderID);
        try {
            this.statement = this.connection.prepareStatement("DELETE from cart where productid = "+orderID);
            i=statement.executeUpdate();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return i;
    }

    public int getProductID(Product p) {
        try {
            System.out.println("Getting details for \n"+p);
            this.statement= this.connection.prepareStatement("Select productid from products where productname ='"+p.getProductName()+"' and price = "+p.getProductPrice());
            this.resultSet= statement.executeQuery();
            if(resultSet.next())
            {
                int x=resultSet.getInt(1);
                System.out.println("ID of product is: "+x);
                return x;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public double getTotalPrice()
    {
        try{
            this.statement= this.connection.prepareStatement("select sum(price) from products inner join\n" +
                                                                "cart c on products.productid = c.productid");
            this.resultSet= statement.executeQuery();
            if(resultSet.next())
                return resultSet.getInt(1);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}