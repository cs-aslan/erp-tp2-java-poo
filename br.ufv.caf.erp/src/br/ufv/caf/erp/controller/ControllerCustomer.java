/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.erp.controller;

import br.ufv.caf.erp.model.entity.Address;
import br.ufv.caf.erp.model.entity.Customer;
import br.ufv.caf.erp.model.persistence.DAOCustomer;
import java.util.ArrayList;

/**
 *
 * @author aslan
 */
public class ControllerCustomer {
    
    private final DAOCustomer persistence;
    
    public ControllerCustomer(){
        persistence = new DAOCustomer();
    }
    
    /**
     *
     * @param code
     * @param name
     * @param CPF
     * @param email
     * @param password
     * @return
     */
    public Customer insert(int code, String name, String CPF, String email, String password){
        if(persistence.search(code)!=null) return null;
        
        return persistence.insert(code, name, CPF, email, password);
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Customer> getAllProducts(){
        return persistence.getAllCustomers();
    }
    
    /**
     *
     * @param name
     * @return
     */
    public ArrayList<Customer> searchByName(String name){
        return persistence.searchByName(name);
    }
    
//    /**
//     *
//     * @param code
//     * @return
//     */
//    public Customer remove(int code){
//        return persistence.remove(code);
//    }
    
    /**
     *
     * @param code
     * @param active
     * @return
     */
    public Customer setActive(int code, boolean active){
        return persistence.setActive(code, active);
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Customer> getAllActiveCustomers(){
        return persistence.getAllActiveCustomers();
    }
    
    /**
     *
     * @param code
     * @return
     */
    public boolean isActive(int code){
        return persistence.isActive(code);
    }
    
    /**
     *
     * @param customerCode
     * @return
     */
    public ArrayList<Address> getAllAddress(int customerCode){
        return persistence.getAllAddress(customerCode);
    }
    
    /**
     *
     * @param customerCode
     * @param addressName
     * @param addressCode
     * @param number
     * @param street
     * @param neighborhood
     * @param city
     * @param CEP
     * @return
     */
    public Address insertAddress(int customerCode, String addressName, int addressCode, int number, String street, String neighborhood, String city, int CEP){
        return persistence.insertAddress(customerCode, addressName, addressCode, number, street, neighborhood, city, CEP);
    }
    
    /**
     *
     * @param customerCode
     * @param addressCode
     * @return
     */
    public Address searchAddress(int customerCode, int addressCode){
        return persistence.searchAddress(customerCode, addressCode);
    }
    
    public boolean checkPassword(int customerCode, String password){
        return persistence.checkPassword(customerCode, password);
    }
    
}
