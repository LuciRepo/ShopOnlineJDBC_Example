package org.fasttrackit.shopOnline.pojo;

public class Categories {
    private int id;
    private String category;
    private String subcategory;
    private String brand;
    private String measurementUnit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public Categories(int id, String category, String subcategory, String brand, String measurementUnit) {
        this.id = id;
        this.category = category;
        this.subcategory = subcategory;
        this.brand = brand;
        this.measurementUnit = measurementUnit;
    }

    public Categories() {
    }
}
