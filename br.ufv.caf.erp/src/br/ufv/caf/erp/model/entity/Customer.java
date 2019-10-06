/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.erp.model.entity;

import br.ufv.caf.erp.controller.ControllerAddress;
import java.util.ArrayList;

/**
 *
 * @author aslan
 */
public class Customer {
    private int code;
    private String name;
    private String CPF;
    private String email;
    private String password;
    private final ControllerAddress addresses;
    
    private boolean active;
    
    /**
     *
     * @param code
     * @param name
     * @param CPF
     * @param email
     * @param password
     */
    public Customer(int code, String name, String CPF, String email, String password){
        addresses = new ControllerAddress();
        this.code = code;
        this.name = name;
        this.CPF = CPF;
        this.email = email;
        this.password = password;
        this.active = true;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     *
     * @param password
     * @return
     */
    public boolean checkPassword(String password){
        return password.equals(this.password);
    }

    /**
     * @return the addresses
     */
    public ArrayList<Address> getAllAddress() {
        return addresses.getAllAddress();
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
    public Address insertAddress(String name, int code, int number, String street, String neighborhood, String city, int CEP){
        return addresses.insert(name, code, number, street, neighborhood, city, CEP);
    }
    
    /**
     *
     * @param code
     * @return
     */
    public Address searchAddress(int code){
        return addresses.search(code);
    }
    
    /**
     *
     * @param name
     * @return
     */
    public ArrayList<Address> searchAddress(String name){
        return addresses.searchByName(name);
    }
    
    public Address removeAddress(int code){
        return addresses.remove(code);
    }
    
    /**
     *
     * @param active
     */
    public void setActive(boolean active){
        this.active = active;
    }
    
    /**
     *
     * @return
     */
    public boolean isActive(){
        return active;
    }
}
