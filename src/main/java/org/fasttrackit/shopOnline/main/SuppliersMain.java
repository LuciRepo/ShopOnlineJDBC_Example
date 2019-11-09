package org.fasttrackit.shopOnline.main;

import org.fasttrackit.shopOnline.dao.SuppliersDAO;
import org.fasttrackit.shopOnline.pojo.Suppliers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class SuppliersMain {
    public static void main(String[] args) throws SQLException {
        Random random = new Random();
        Suppliers suppliers = new Suppliers(random.nextInt(1000), "Ravenol", "Oradea,Parc Industrial", "0359030405", "info@ravenol.ro");
        SuppliersDAO sdao = new SuppliersDAO();
        sdao.createSuppliers(suppliers);
        ArrayList<Suppliers> suppliersCreated = sdao.getSuppliers();
        for (Suppliers supp : suppliersCreated) {
            System.out.println(supp.getId() + " " + supp.getName() + " " + supp.getAddress() + " " + supp.getPhone() + " " + supp.getEmail());
        }
        sdao.updateSuppliers(suppliers);
        ArrayList<Suppliers> suppliersUpdated = sdao.getSuppliers();
        for (Suppliers supp : suppliersUpdated) {
            System.out.println(supp.getId() + " " + supp.getName() + " " + supp.getAddress() + " " + supp.getPhone() + " " + supp.getEmail());
        }
        try {
            sdao.deleteSuppliers(suppliers);
            ArrayList<Suppliers> suppliersDeleted = sdao.getSuppliers();
            for (Suppliers supp : suppliersDeleted) {
                System.out.println(supp.getId() + " " + supp.getName() + " " + supp.getAddress() + " " + supp.getPhone() + " " + supp.getEmail());
            }
        } catch (Exception e) {
            System.out.println("Nu a fost gasit id -ul in baza de date");
            e.printStackTrace();
        }
    }
}


