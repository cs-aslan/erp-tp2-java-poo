/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.erp.controller;

import br.ufv.caf.erp.model.entity.Address;
import br.ufv.caf.erp.model.persistence.DAOAddress;
import java.util.ArrayList;

/**
 *
 * @author aslan
 */
public class ControllerAddress {
    private final DAOAddress persistence;
    
    public ControllerAddress(){
        persistence = new DAOAddress();
    }
    
     /**
     *
     * @param code
     * @param name
     * @param number
     * @param street
     * @param neighborhood
     * @param city
     * @param CEP
     * @return
     */
    public Address insert(String name, int code, int number, String street, String neighborhood, String city, int CEP){
        if(persistence.search(code)!=null) return null;
        
        return persistence.insert(name, code, number, street, neighborhood, city, CEP);
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Address> getAllAddress(){
        return persistence.getAllAddress();
    }
    
    /**
     *
     * @param name
     * @return
     */
    public ArrayList<Address> searchByName(String name){
        return persistence.searchByName(name);
    }
    
    /**
     *
     * @param code
     * @return
     */
    public Address search(int code){
        return persistence.search(code);
    }
    
    /**
     *
     * @param code
     * @return
     */
    public Address remove(int code){
        return persistence.remove(code);
    }
}
