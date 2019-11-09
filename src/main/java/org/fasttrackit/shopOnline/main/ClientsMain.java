package org.fasttrackit.shopOnline.main;

import com.mysql.cj.xdevapi.Client;
import org.fasttrackit.shopOnline.dao.ClientsDAO;
import org.fasttrackit.shopOnline.helper.DBHelper;
import org.fasttrackit.shopOnline.pojo.Clients;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class ClientsMain {
    public static void main(String[] args) throws SQLException {
        Random id = new Random();
        Clients clients = new Clients(1, "PF", "Alex Pantea Marian", "Oradea", "03597808987", "alex@yahoo.com");
        ClientsDAO cdao = new ClientsDAO();
        //cdao.createClients(clients);
        ArrayList<Clients> clientsCreated = cdao.getClients();
        for (Clients c : clientsCreated) {
            System.out.println(c.getId() + " " + c.getType() + " " + c.getName() + " " + c.getAddress() + " " + c.getPhone() + " " + c.getEmail());
        }
        //cdao.updateClients(clients);
        ArrayList<Clients> clientsUpdated = cdao.getClients();
        for (Clients c : clientsUpdated) {
            System.out.println(c.getId() + " " + c.getType() + " " + c.getName() + " " + c.getAddress() + " " + c.getPhone() + " " + c.getEmail());
        }
        cdao.deleteClients(clients);
        ArrayList<Clients> clientsDeleted = cdao.getClients();
        for (Clients c : clientsDeleted) {
            System.out.println(c.getId() + " " + c.getType() + " " + c.getName() + " " + c.getAddress() + " " + c.getPhone() + " " + c.getEmail());

        }
    }
}
