/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.erp.model.entity;

/**
 *
 * @author aslan
 */
public class Product {

    private final int code;
    private String name;
    private String description;
    private int quantity;
    private String category;
    private double price;
    
    private boolean salable;
    
    /**
     *
     * @param code
     * @param name
     * @param description
     * @param quantity
     * @param category
     * @param price
     */
    public Product(int code, String name, String description, int quantity, String category, double price){
        this.code = code;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.category = category;
        this.price = price;
        
        this.salable = true;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * @return the active
     */
    public boolean isSalable() {
        return salable;
    }

    /**
     * @param salable
     */
    public void setSalable(boolean salable) {
        this.salable = salable;
    }
    
    public String toString(){
        return this.name;
    }
    
}
