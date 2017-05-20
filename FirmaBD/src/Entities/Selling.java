/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author Kathy
 */
public class Selling {
     private int id;
    private String number_contract;
    private Date date_selling;
    private int cwId;
    private int  clientId;
    
    public Selling(int id, String number_contract, Date date_selling,
            int cwId, int providersId){
        this.id = id;
        this.number_contract = number_contract;
        this.date_selling = date_selling;
        this.cwId = cwId;
        this.clientId = clientId;
       
        
    
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the number_contract
     */
    public String getNumber_contract() {
        return number_contract;
    }

    /**
     * @param number_contract the number_contract to set
     */
    public void setNumber_contract(String number_contract) {
        this.number_contract = number_contract;
    }

    /**
     * @return the date_selling
     */
    public Date getDate_selling() {
        return date_selling;
    }

    /**
     * @param date_selling the date_selling to set
     */
    public void setDate_selling(Date date_selling) {
        this.date_selling = date_selling;
    }

    /**
     * @return the cwId
     */
    public int getCwId() {
        return cwId;
    }

    /**
     * @param cwId the cwId to set
     */
    public void setCwId(int cwId) {
        this.cwId = cwId;
    }

    /**
     * @return the clientId
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    
}
