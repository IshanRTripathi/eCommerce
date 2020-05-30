/*
Question Link - 
*/
package Models;

import java.io.*;
import java.util.*;

public class Product {
    private int productID;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int units;
    private String category;

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }


    public Product(int productID, String productName, String productDescription, int units, String category, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.units = units;
        this.category = category;
        this.productPrice= productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", units=" + units +
                ", category='" + category + '\'' +
                '}';
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}