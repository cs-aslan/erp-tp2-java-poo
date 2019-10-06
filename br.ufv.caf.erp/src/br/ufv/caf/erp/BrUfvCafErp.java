/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.erp;

import br.ufv.caf.erp.controller.ControllerCustomer;
import br.ufv.caf.erp.controller.ControllerProduct;
import br.ufv.caf.erp.controller.ControllerSales;
import br.ufv.caf.erp.model.entity.ProductSold;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author aslan
 */
public class BrUfvCafErp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ControllerProduct products = new ControllerProduct();
        ControllerCustomer customers = new ControllerCustomer();
        ControllerSales sales = new ControllerSales();
        ArrayList<ProductSold> shopList = new ArrayList();
        LocalDate date = LocalDate.parse( "2016-09-20" );
        
        products.insert(5, "Bola de futebol", "Redonda", 5, "Esportes", 35.20);
        customers.insert(3, "Mateus", "10631890637", "mateus.p.silva@ufv.br", "dovahkiin");
        customers.insertAddress(3, "Casinha", 3, 47, "Rua arthur", "Centro", "Sao Jose", 35694000);
        
        shopList.add(new ProductSold(5, 1));
        
        //products.setSalable(5, false);
        
        System.out.println(sales.sell(0, 3, 3, "dovahkiin", date, shopList, customers, products));
    }
    
}
