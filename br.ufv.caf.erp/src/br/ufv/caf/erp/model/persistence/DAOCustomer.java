/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.erp.model.persistence;

import br.ufv.caf.erp.model.entity.Address;
import br.ufv.caf.erp.model.entity.Customer;
import java.util.ArrayList;

/**
 *
 * @author aslan
 */
public class DAOCustomer {
    
    private final ArrayList<Customer> customers;
    
    public DAOCustomer(){
        customers = new ArrayList();
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
        Customer customer = new Customer(code, name, CPF, email, password);
        this.customers.add(customer);
        return customer;
    }
    
    /**
     *
     * @param code
     * @return
     */
    public Customer search(int code){
        for(Customer searched : customers){
            if(searched.getCode() == code){
                return searched;
            }
        }
        return null;
    }
    
    /**
     *
     * @param name
     * @return
     */
    public ArrayList<Customer> searchByName(String name){
        ArrayList<Customer> searched = new ArrayList();
        customers.stream().filter((p) -> (p.getName().startsWith(name))).forEachOrdered((p) -> {
            searched.add(p);
        });
        return searched;
    }
    
    /**
     * @return the products
     */
    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Customer> getAllActiveCustomers(){
        ArrayList<Customer> actives = new ArrayList();
        
        customers.stream().filter((p) -> (p.isActive())).forEachOrdered((p) -> {
            actives.add(p);
        });
            
        return actives;
    }
    
    
    /**
     *
     * @param code
     * @return
     */
    public Customer remove(int code){
        Customer removed;
        for(int i=0; i<customers.size(); i++){
            removed = customers.get(i);
            if(removed.getCode() == code){
                return customers.remove(i);
            }
        }
        return null;
    }
    
    /**
     *
     * @param customerCode
     * @param name
     * @param addressCode
     * @param number
     * @param street
     * @param neighborhood
     * @param city
     * @param CEP
     * @return
     */
    public Address insertAddress(int customerCode, String name, int addressCode, int number, String street, String neighborhood, String city, int CEP){
        Customer searched = search(customerCode);
        
        if(searched==null) return null;
        
        return searched.insertAddress(name, addressCode, number, street, neighborhood, city, CEP);
    }
    
    /**
     *
     * @param customerCode
     * @param addressCode
     * @return
     */
    public Address searchAddress(int customerCode, int addressCode){
        Customer searched = search(customerCode);
        
        if(searched==null) return null;
        
        return searched.searchAddress(addressCode);
    }
    
    /**
     *
     * @param customerCode
     * @return
     */
    public ArrayList<Address> getAllAddress(int customerCode){
        Customer searched = search(customerCode);
        
        if(searched==null) return null;
        
        return searched.getAllAddress();
    }
    
    /**
     *
     * @param customerCode
     * @param addressCode
     * @return
     */
    public Address removeAddress(int customerCode, int addressCode){
        Customer searched = search(customerCode);
        
        if(searched==null) return null;
        
        return searched.removeAddress(addressCode);
    }
    
    /**
     *
     * @param code
     * @param active
     * @return
     */
    public Customer setActive(int code, boolean active){
        Customer searched = search(code);
        
        if(searched==null) return null;
        
        searched.setActive(active);
        
        return searched;
    }
    
    /**
     *
     * @param code
     * @return
     */
    public boolean isActive(int code){
        Customer searched = search(code);
        
        if(searched==null) return false;
        
        return searched.isActive();
    }
    
    public boolean checkPassword(int code, String password){
        Customer searched = search(code);
        
        if(searched==null) return false;
        
        return searched.checkPassword(password);
    }
    
}
