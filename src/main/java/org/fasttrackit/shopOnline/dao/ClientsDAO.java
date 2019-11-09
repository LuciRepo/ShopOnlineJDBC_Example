package org.fasttrackit.shopOnline.dao;

import org.fasttrackit.shopOnline.helper.DBHelper;
import org.fasttrackit.shopOnline.pojo.Clients;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class ClientsDAO {
    public void createClients(Clients clients) throws SQLException {
        Connection con = DBHelper.getConnection();
        String insertString = "INSERT INTO clients(id, type,name,address,phone,email) VALUES(?,?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(insertString);
        stmt.setInt(1, clients.getId());
        stmt.setString(2, clients.getType());
        stmt.setString(3, clients.getName());
        stmt.setString(4, clients.getAddress());
        stmt.setString(5, clients.getPhone());
        stmt.setString(6, clients.getEmail());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }

    public ArrayList<Clients> getClients() throws SQLException {
        Connection con = DBHelper.getConnection();
        String selectString = "select * from clients";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(selectString);
        ArrayList<Clients> result = new ArrayList<Clients>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String type = rs.getString("type");
            String name = rs.getString("name");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            Clients clients = new Clients(id, type, name, address, phone, email);
            result.add(clients);
        }


        DBHelper.closeConnection(con);
        return result;
    }

    public void updateClients(Clients clients) throws SQLException {
        Connection con = DBHelper.getConnection();
        String updateString = "UPDATE clients SET type=?,name=?,address=?,phone=?,email=? WHERE id=?";
        PreparedStatement stmt = con.prepareStatement(updateString);
        stmt.setString(1, clients.getType());
        stmt.setString(2, clients.getName());
        stmt.setString(3, clients.getAddress());
        stmt.setString(4, clients.getPhone());
        stmt.setString(5, clients.getEmail());
        stmt.setInt(6, clients.getId());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }
    public void deleteClients(Clients clients) throws SQLException{
        Connection con=DBHelper.getConnection();
        String deleteString="DELETE FROM clients WHERE id=?";
        PreparedStatement stmt=con.prepareStatement(deleteString);
        stmt.setInt(1,clients.getId());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }
}
