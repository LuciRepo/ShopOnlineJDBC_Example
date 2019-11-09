package org.fasttrackit.shopOnline.main;

import org.fasttrackit.shopOnline.dao.SellersDAO;
import org.fasttrackit.shopOnline.dao.SuppliersDAO;
import org.fasttrackit.shopOnline.pojo.Sellers;
import org.fasttrackit.shopOnline.pojo.Suppliers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class SellersMain {
    public static void main(String[] args) throws SQLException {
        Random random = new Random();
        Sellers sellers = new Sellers(random.nextInt(1000), "Yoyo", "Oradea", "0359034305", "info@yoyo.ro");
        SellersDAO seldao = new SellersDAO();
        seldao.createSellers(sellers);
        ArrayList<Sellers> sellersCreated = seldao.getSellers();
        for (Sellers sel : sellersCreated) {
            System.out.println(sel.getId() + " " + sel.getName() + " " + sel.getAddress() + " " + sel.getPhone() + " " + sel.getEmail());
        }
        seldao.updateSellers(sellers);
        ArrayList<Sellers> sellersUpdated = seldao.getSellers();
        for (Sellers sel : sellersUpdated) {
            System.out.println(sel.getId() + " " + sel.getName() + " " + sel.getAddress() + " " + sel.getPhone() + " " + sel.getEmail());
        }
        try {
            seldao.deleteSellers(sellers);
            ArrayList<Sellers> sellersDeleted = seldao.getSellers();
            for (Sellers sel : sellersDeleted) {
                System.out.println(sel.getId() + " " + sel.getName() + " " + sel.getAddress() + " " + sel.getPhone() + " " + sel.getEmail());
            }
        } catch (Exception e) {
            System.out.println("Nu a fost gasit id -ul in baza de date");
            e.printStackTrace();
        }
    }
}


