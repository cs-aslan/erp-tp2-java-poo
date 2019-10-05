/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.erp.controller;

import br.ufv.caf.erp.model.entity.Product;
import br.ufv.caf.erp.model.persistence.DAOProduct;
import java.util.ArrayList;

/**
 *
 * @author aslan
 */
public class ControllerProduct {
    private final DAOProduct persistence;
    
    public ControllerProduct(){
        persistence = new DAOProduct();
    }
    
    /**
     *
     * @param code
     * @param name
     * @param description
     * @param quantity
     * @param category
     * @param price
     * @return
     */
    public Product insert(int code, String name, String description, int quantity, String category, double price){
        if(persistence.search(code)!=null) return null;
        
        return persistence.insert(code, name, description, quantity, category, price);
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Product> getProducts(){
        return persistence.getProducts();
    }
    
    /**
     *
     * @param name
     * @return
     */
    public ArrayList<Product> searchByName(String name){
        return persistence.searchByName(name);
    }
    
    /**
     *
     * @param code
     * @return
     */
    public Product remove(int code){
        return persistence.remove(code);
    }
    
    /**
     *
     * @param code
     * @param quantity
     * @return
     */
    public Product changeQuantity(int code, int quantity){
        return persistence.changeQuantity(code, quantity);
    }
    
}
