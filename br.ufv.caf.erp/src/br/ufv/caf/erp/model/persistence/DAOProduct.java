/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.erp.model.persistence;

import br.ufv.caf.erp.model.entity.Product;
import java.util.ArrayList;


/**
 *
 * @author aslan
 */
public class DAOProduct {

    private final ArrayList<Product> products;
    
    public DAOProduct(){
        products = new ArrayList();
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
        Product product = new Product(code, name, description, quantity, category, price);
        this.products.add(product);
        return product;
    }
    
    /**
     *
     * @param code
     * @return
     */
    public Product search(int code){
        for(Product p : products){
            if(p.getCode() == code){
                return p;
            }
        }
        return null;
    }
    
    /**
     *
     * @param name
     * @return
     */
    public ArrayList<Product> searchByName(String name){
        ArrayList<Product> searched = new ArrayList();
        products.stream().filter((p) -> (p.getName().startsWith(name))).forEachOrdered((p) -> {
            searched.add(p);
        });
        return searched;
    }
    
    /**
     * @return the products
     */
    public ArrayList<Product> get() {
        return products;
    }
    
    public Product changeQuantity(int code, int quantity){
        Product product = search(code);
        
        if(product==null) return null;
        
        product.setQuantity(quantity);
        return product;
    }
    
    /**
     *
     * @param code
     * @return
     */
    public Product remove(int code){
        Product product;
        for(int i=0; i<products.size(); i++){
            product = products.get(i);
            if(product.getCode() == code){
                return products.remove(i);
            }
        }
        return null;
    }
    
    
}
