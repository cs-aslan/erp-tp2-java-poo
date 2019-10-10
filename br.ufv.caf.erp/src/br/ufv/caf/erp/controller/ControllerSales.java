/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.erp.controller;

import br.ufv.caf.erp.model.entity.ProductSold;
import br.ufv.caf.erp.model.entity.Sale;
import br.ufv.caf.erp.model.enums.SaleStatus;
import br.ufv.caf.erp.model.persistence.DAOSale;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author aslan
 */
public class ControllerSales {
    private final DAOSale persistence;
    
    public ControllerSales(){
        persistence = new DAOSale();
    }
    
    public Sale sell(int sellCode, int customerCode, int addressCode, String password, LocalDate date, ArrayList<ProductSold> productList, ControllerCustomer customers, ControllerProduct products){
        if(!customers.isActive(customerCode) || !customers.checkPassword(customerCode, password)) return null;
        if(customers.searchAddress(customerCode, addressCode) == null) return null;
        
        for(ProductSold tryingBuy : productList){
            if(products.getQuantity(tryingBuy.getProductCode()) < tryingBuy.getQuantity() || !products.isSalable(tryingBuy.getProductCode())){
                return null;
            }
        }
        
        
        for(ProductSold buying : productList){
            products.setQuantity(buying.getProductCode(), (products.getQuantity(buying.getProductCode()) - buying.getQuantity()));
        }
        
        return persistence.insert(sellCode, customerCode, addressCode, date, productList);
    }
    
    public void setSaleStatus(int code, SaleStatus saleStatus){
        this.persistence.setSaleStatus(code, saleStatus);
    }
    
    public ArrayList<Sale> getAllSales(){
        return this.persistence.getAllSales();
    }
    
    public ArrayList<Sale> searchByDate(LocalDate date){
        return this.persistence.searchByDate(date);
    }
}
