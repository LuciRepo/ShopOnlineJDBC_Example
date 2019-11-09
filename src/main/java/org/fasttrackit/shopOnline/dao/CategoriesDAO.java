package org.fasttrackit.shopOnline.dao;

import org.fasttrackit.shopOnline.helper.DBHelper;
import org.fasttrackit.shopOnline.pojo.Categories;

import java.sql.*;
import java.util.ArrayList;

public class CategoriesDAO {
    public void createCategories(Categories categories) throws SQLException {
        Connection con = DBHelper.getConnection();
        String insertString = "INSERT INTO categories(id,category,subcategory,brand,measurementUnit) VALUES(?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(insertString);
        stmt.setInt(1, categories.getId());
        stmt.setString(2, categories.getCategory());
        stmt.setString(3, categories.getSubcategory());
        stmt.setString(4, categories.getBrand());
        stmt.setString(5, categories.getMeasurementUnit());
        stmt.executeUpdate();
        DBHelper.closeConnection(DBHelper.getConnection());
    }

    public ArrayList<Categories> getCategories() throws SQLException {
        Connection con = DBHelper.getConnection();
        String selectString = "SELECT * from categories";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(selectString);
        ArrayList<Categories> result = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String category = rs.getString("category");
            String subcategory = rs.getString("subcategory");
            String brand = rs.getString("brand");
            String measurementUnit = rs.getString("measurementUnit");
            Categories categories = new Categories(id, category, subcategory, brand, measurementUnit);
            result.add(categories);
        }
        DBHelper.closeConnection(con);
        return result;
    }

    public void updateCategories(Categories categories) throws SQLException {
        Connection con = DBHelper.getConnection();
        String updateString = "UPDATE categories SET category=?, subcategory=?, brand=?, measurementUnit=? WHERE id=?";
        PreparedStatement stmt=con.prepareStatement(updateString);
        stmt.setString(1,categories.getCategory());
        stmt.setString(2,categories.getSubcategory());
        stmt.setString(3,categories.getBrand());
        stmt.setString(4,categories.getMeasurementUnit());
        stmt.setInt(5,categories.getId());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }
    public void deleteCategories(Categories categories)throws SQLException{
        Connection con=DBHelper.getConnection();
        String deleteString="DELETE FROM categories WHERE id=?";
        PreparedStatement stmt=con.prepareStatement(deleteString);
        stmt.setInt(1,categories.getId());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }
}
