package org.fasttrackit.shopOnline.pojo;

public class Products {
    private int id;
    private String name;
    private String measurementUnit;
    private double stock;
    private double price;
    private int termOfDeliveryDays;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTermOfDeliveryDays() {
        return termOfDeliveryDays;
    }

    public void setTermOfDeliveryDays(int termOfDeliveryDays) {
        this.termOfDeliveryDays = termOfDeliveryDays;
    }

    public Products(int id, String name,  String measurementUnit,double stock, double price, int termOfDeliveryDays) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.measurementUnit = measurementUnit;
        this.price = price;
        this.termOfDeliveryDays = termOfDeliveryDays;
    }

    public Products() {
    }
}
