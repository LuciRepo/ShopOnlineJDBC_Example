package org.fasttrackit.shopOnline.dao;

import org.fasttrackit.shopOnline.helper.DBHelper;
import org.fasttrackit.shopOnline.pojo.Sellers;
import org.fasttrackit.shopOnline.pojo.Suppliers;
import java.sql.*;
import java.util.ArrayList;

public class SellersDAO {
    public void createSellers(Sellers sellers) throws SQLException {
        Connection con = DBHelper.getConnection();
        String insertString = "INSERT INTO sellers(id,name,address,phone,email) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(insertString);
        stmt.setInt(1, sellers.getId());
        stmt.setString(2, sellers.getName());
        stmt.setString(3, sellers.getAddress());
        stmt.setString(4, sellers.getPhone());
        stmt.setString(5, sellers.getEmail());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }

    public ArrayList<Sellers> getSellers() throws SQLException {
        Connection con = DBHelper.getConnection();
        String selectString = "select * from sellers";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(selectString);
        ArrayList<Sellers> result = new ArrayList<Sellers>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            Sellers sellers = new Sellers(id, name, address, phone, email);
            result.add(sellers);
        }
        DBHelper.closeConnection(con);
        return result;
    }

    public void updateSellers(Sellers sellers) throws SQLException {
        Connection con = DBHelper.getConnection();
        String updateString = "UPDATE sellers SET name=?,address=?,phone=?,email=? WHERE id=?";
        PreparedStatement stmt = con.prepareStatement(updateString);
        stmt.setString(1, sellers.getName());
        stmt.setString(2, sellers.getAddress());
        stmt.setString(3, sellers.getPhone());
        stmt.setString(4, sellers.getEmail());
        stmt.setInt(5, sellers.getId());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }
    public void deleteSellers(Sellers sellers) throws SQLException{
        Connection con=DBHelper.getConnection();
        String deleteString="DELETE FROM sellers WHERE id=?";
        PreparedStatement stmt=con.prepareStatement(deleteString);
        stmt.setInt(1,sellers.getId());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }
}

