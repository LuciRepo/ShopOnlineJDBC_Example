package org.fasttrackit.shopOnline.dao;

import org.fasttrackit.shopOnline.helper.DBHelper;
import org.fasttrackit.shopOnline.pojo.Suppliers;
import java.sql.*;
import java.util.ArrayList;

public class SuppliersDAO {
    public void createSuppliers(Suppliers suppliers) throws SQLException {
        Connection con = DBHelper.getConnection();
        String insertString = "INSERT INTO suppliers(id,name,address,phone,email) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(insertString);
        stmt.setInt(1, suppliers.getId());
        stmt.setString(2, suppliers.getName());
        stmt.setString(3, suppliers.getAddress());
        stmt.setString(4, suppliers.getPhone());
        stmt.setString(5, suppliers.getEmail());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }

    public ArrayList<Suppliers> getSuppliers() throws SQLException {
        Connection con = DBHelper.getConnection();
        String selectString = "select * from suppliers";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(selectString);
        ArrayList<Suppliers> result = new ArrayList<Suppliers>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            Suppliers suppliers = new Suppliers(id, name, address, phone, email);
            result.add(suppliers);
        }
        DBHelper.closeConnection(con);
        return result;
    }

    public void updateSuppliers(Suppliers suppliers) throws SQLException {
        Connection con = DBHelper.getConnection();
        String updateString = "UPDATE suppliers SET name=?,address=?,phone=?,email=? WHERE id=?";
        PreparedStatement stmt = con.prepareStatement(updateString);
        stmt.setString(1, suppliers.getName());
        stmt.setString(2, suppliers.getAddress());
        stmt.setString(3, suppliers.getPhone());
        stmt.setString(4, suppliers.getEmail());
        stmt.setInt(5, suppliers.getId());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }
    public void deleteSuppliers(Suppliers suppliers) throws SQLException{
        Connection con=DBHelper.getConnection();
        String deleteString="DELETE FROM suppliers WHERE id=?";
        PreparedStatement stmt=con.prepareStatement(deleteString);
        stmt.setInt(1,suppliers.getId());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }
}

