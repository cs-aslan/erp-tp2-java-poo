/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.erp.model.persistence;

import br.ufv.caf.erp.model.entity.Address;
import java.util.ArrayList;

/**
 *
 * @author aslan
 */
public class DAOAddress {
    private final ArrayList<Address> addresses;
    
    public DAOAddress(){
        addresses = new ArrayList();
    }
    
    /**
     *
     * @param name
     * @param code
     * @param number
     * @param street
     * @param neighborhood
     * @param city
     * @param CEP
     * @return
     */
    public Address insert(String name, int code, int number, String street, String neighborhood, String city, int CEP){
        Address address = new Address(name, code, number, street, neighborhood, city, CEP);
        this.addresses.add(address);
        return address;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Address> getAllAddress(){
        return this.addresses;
    }
    
    /**
     *
     * @param code
     * @return
     */
    public Address remove(int code){
        Address address;
        for(int i=0; i<addresses.size(); i++){
            address = addresses.get(i);
            if(address.getCode() == code){
                return addresses.remove(i);
            }
        }
        return null;
    }
    
    /**
     *
     * @param code
     * @return
     */
    public Address search(int code){
        for(Address a : addresses){
            if(a.getCode() == code){
                return a;
            }
        }
        return null;
    }
    
    /**
     *
     * @param name
     * @return
     */
    public ArrayList<Address> searchByName(String name){
        ArrayList<Address> searched = new ArrayList();
        addresses.stream().filter((p) -> (p.getName().startsWith(name))).forEachOrdered((p) -> {
            searched.add(p);
        });
        return searched;
    }
}
