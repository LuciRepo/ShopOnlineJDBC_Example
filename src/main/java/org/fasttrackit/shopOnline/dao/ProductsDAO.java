package org.fasttrackit.shopOnline.dao;

import org.fasttrackit.shopOnline.helper.DBHelper;
import org.fasttrackit.shopOnline.pojo.Products;

import java.sql.*;
import java.util.ArrayList;

public class ProductsDAO {
    public void createProducts(Products products)throws SQLException {
        Connection con= DBHelper.getConnection();
        String insertString="INSERT INTO products(id,name,measurementUnit,stock,price,termOfDeliveryDays) VALUES(?,?,?,?,?,?)";
        PreparedStatement stmt=con.prepareStatement(insertString);
        stmt.setInt(1,products.getId());
        stmt.setString(2,products.getName());
        stmt.setString(3,products.getMeasurementUnit());
        stmt.setDouble(4,products.getStock());
        stmt.setDouble(5,products.getPrice());
        stmt.setInt(6,products.getTermOfDeliveryDays());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }
    public ArrayList<Products> getProducts() throws SQLException{
        Connection con=DBHelper.getConnection();
        String selectString="select * from products";
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(selectString);
        ArrayList<Products> result=new ArrayList<>();
        while(rs.next()){
            int id=rs.getInt("id");
            String name=rs.getString("name");
            String measurementUnit=rs.getString("measurementUnit");
            double stock=rs.getDouble("stock");
            double price=rs.getDouble("price");
            int termOfDeliveryDays=rs.getInt("termOfDeliveryDays");
            Products products=new Products(id,name,measurementUnit,stock,price,termOfDeliveryDays);
            result.add(products);
        }
        DBHelper.closeConnection(con);
        return result;
    }
    public void updateProducts(Products products) throws SQLException{
        Connection con=DBHelper.getConnection();
        String updateString=" UPDATE products SET name=?,measurementUnit=?,stock=?,price=?,termOfDeliveryDays=? WHERE id=?";
        PreparedStatement stmt=con.prepareStatement(updateString);
        stmt.setString(1,products.getName());
        stmt.setString(2,products.getMeasurementUnit());
        stmt.setDouble(3,products.getStock());
        stmt.setDouble(4,products.getPrice());
        stmt.setInt(5,products.getTermOfDeliveryDays());
        stmt.setInt(6,products.getId());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }
    public void deleteProducts(Products products)throws SQLException{
        Connection con=DBHelper.getConnection();
        String deleteString="DELETE FROM products WHERE id=?";
        PreparedStatement stmt=con.prepareStatement(deleteString);
        stmt.setInt(1,products.getId());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }
}
