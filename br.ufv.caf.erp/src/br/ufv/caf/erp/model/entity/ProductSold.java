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
public class ProductSold {
    private final int productCode;
    private final int quantity;
    
    /**
     *
     * @param productCode
     * @param quantity
     */
    public ProductSold(int productCode, int quantity){
        this.productCode = productCode;
        this.quantity = quantity;
    }

    /**
     * @return the productCode
     */
    public int getProductCode() {
        return productCode;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }
}
