/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.erp;

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
        
        products.insert(5, "Bola de futebol", "Redonda", 5, "Esportes", 35.20);
        
        System.out.println(products.getProducts());
    }
    
}
