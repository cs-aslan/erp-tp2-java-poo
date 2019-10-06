/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.erp;

import br.ufv.caf.erp.controller.ControllerCustomer;
import br.ufv.caf.erp.controller.ControllerProduct;

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
        
        products.insert(5, "Bola de futebol", "Redonda", 5, "Esportes", 35.20);
        customers.insert(3, "Mateus", "10631890637", "mateus.p.silva@ufv.br", "dovahkiin");
        customers.insertAddress(3, "Casinha", 3, 47, "Rua arthur", "Centro", "Sao Jose", 35694000);
        
        //products.setSalable(5, false);
        
        System.out.println(products.getAllSalableProducts());
        System.out.println(customers.searchByName("Mat"));
        System.out.println(customers.searchByName("Mat").get(0).getAllAddress());
    }
    
}
