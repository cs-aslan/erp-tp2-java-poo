/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.caf.erp.controller;

import br.ufv.caf.erp.model.persistence.DAOAddress;

/**
 *
 * @author aslan
 */
public class ControllerAddress {
    private final DAOAddress persistence;
    
    public ControllerAddress(){
        persistence = new DAOAddress();
    }
}
