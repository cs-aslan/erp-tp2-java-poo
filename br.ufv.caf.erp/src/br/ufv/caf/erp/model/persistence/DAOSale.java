/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.erp.model.persistence;

import br.ufv.caf.erp.model.entity.ProductSold;
import br.ufv.caf.erp.model.entity.Sale;
import br.ufv.caf.erp.model.enums.SaleStatus;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author aslan
 */
public class DAOSale {
    private final ArrayList<Sale> sales;
    
    public DAOSale(){
        sales = new ArrayList();
    }
    
    /**
     *
     * @param code
     * @param clientCode
     * @param addressCode
     * @param date
     * @param products
     * @return
     */
    public Sale insert(int code, int clientCode, int addressCode, LocalDate date, ArrayList<ProductSold> products){
        Sale sale = new Sale(code, clientCode, addressCode, date, products);
        
        sales.add(sale);
        
        return sale;
    }
    
    /**
     *
     * @param code
     * @return
     */
    public Sale search(int code){
        for(Sale s : sales){
            if(s.getCode() == code){
                return s;
            }
        }
        return null;
    }
    
    public ArrayList<Sale> searchByDate(LocalDate date){
        ArrayList<Sale> sales=new ArrayList();
        for(Sale sale: this.sales){
            if(sale.getDate().compareTo(date)==0){
                sales.add(sale);
            }
        }
        return sales;
    }
    
    /**
     *
     * @param code
     * @param saleStatus
     * @return
     */
    public Sale setSaleStatus(int code, SaleStatus saleStatus){
        Sale sale = search(code);
        
        if(sale==null) return null;
        
        sale.setSaleStatus(saleStatus);
        return sale;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Sale> getAllSales(){
        return sales;
    }
}
