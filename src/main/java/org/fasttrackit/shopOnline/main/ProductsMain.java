package org.fasttrackit.shopOnline.main;

import org.fasttrackit.shopOnline.dao.ProductsDAO;
import org.fasttrackit.shopOnline.pojo.Products;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class ProductsMain {
    public static void main(String[] args) throws SQLException {
        Random random = new Random();
        Products products = new Products(random.nextInt(100), "Apa", "litru", random.nextInt(500), random.nextInt(5), 1);
        ProductsDAO pdao = new ProductsDAO();
        pdao.createProducts(products);
        ArrayList<Products> productsCreated = pdao.getProducts();
        for (Products prod : productsCreated) {
            System.out.println(prod.getId() + " " + prod.getName() + " " + prod.getMeasurementUnit() + " " + prod.getStock() + " " + prod.getPrice() + " " + prod.getTermOfDeliveryDays());
        }
        pdao.updateProducts(products);
        ArrayList<Products> productsUpdated = pdao.getProducts();
        for (Products prod : productsUpdated) {
            System.out.println(prod.getId() + " " + prod.getName() + " " + prod.getMeasurementUnit() + " " + prod.getStock() + " " + prod.getPrice() + " " + prod.getTermOfDeliveryDays());
        }
        try {
            pdao.deleteProducts(products);
            ArrayList<Products> productsDeleted = pdao.getProducts();
            for (Products prod : productsDeleted) {
                System.out.println(prod.getId() + " " + prod.getName() + " " + prod.getMeasurementUnit() + " " + prod.getStock() + " " + prod.getPrice() + " " + prod.getTermOfDeliveryDays());
            }
        } catch (Exception e) {
            System.out.println("Nu a fost gasit id -ul in baza de date");
            e.printStackTrace();
        }
    }
}
