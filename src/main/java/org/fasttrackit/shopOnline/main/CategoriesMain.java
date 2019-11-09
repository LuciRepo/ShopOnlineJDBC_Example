package org.fasttrackit.shopOnline.main;

import org.fasttrackit.shopOnline.dao.CategoriesDAO;
import org.fasttrackit.shopOnline.pojo.Categories;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class CategoriesMain {
    public static void main(String[] args) throws SQLException {
        Random random = new Random();
        Categories categories = new Categories(random.nextInt(100), "Alimente", "Carne", "Selgros", "kg");
        CategoriesDAO categdao = new CategoriesDAO();
        categdao.createCategories(categories);
        ArrayList<Categories> categoriesCreated = categdao.getCategories();
        for (Categories categ : categoriesCreated) {
            System.out.println(categ.getId() + " " + categ.getCategory() + " " + categ.getSubcategory() + " " + categ.getBrand() + " " + categ.getMeasurementUnit());
        }
        categdao.updateCategories(categories);
        ArrayList<Categories> categoriesUpdated = categdao.getCategories();
        for (Categories categ : categoriesUpdated) {
            System.out.println(categ.getId() + " " + categ.getCategory() + " " + categ.getSubcategory() + " " + categ.getBrand() + " " + categ.getMeasurementUnit());
        }
        try {
            categdao.deleteCategories(categories);
            ArrayList<Categories> categoriesDeleted = categdao.getCategories();
            for (Categories categ : categoriesDeleted) {
                System.out.println(categ.getId() + " " + categ.getCategory() + " " + categ.getSubcategory() + " " + categ.getBrand() + " " + categ.getMeasurementUnit());
            }
        } catch (Exception e) {
            System.out.println("Nu a fost gasit id -ul in baza de date");
            e.printStackTrace();
        }
    }
}

