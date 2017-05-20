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
public class Materials {
    
    private int id;
    private String name_materials;
    private int amount_materials;
    private int price_materials;
    private int  providersId;
    
    public Materials(int id, String name_materials, int amount_materials,
            int price_materials, int providersId){
        this.id = id;
        this.name_materials = name_materials;
        this.amount_materials = amount_materials;
        this.price_materials = price_materials;
        this.providersId = providersId;
       
        
    
    }
@Override
    public String toString() {
        return getName_materials()+ " Cost:  " + getPrice_materials();
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
     * @return the name_materials
     */
    public String getName_materials() {
        return name_materials;
    }

    /**
     * @param name_materials the name_materials to set
     */
    public void setName_materials(String name_materials) {
        this.name_materials = name_materials;
    }

    /**
     * @return the amount_materials
     */
    public int getAmount_materials() {
        return amount_materials;
    }

    /**
     * @param amount_materials the amount_materials to set
     */
    public void setAmount_materials(int amount_materials) {
        this.amount_materials = amount_materials;
    }

    /**
     * @return the price_materials
     */
    public int getPrice_materials() {
        return price_materials;
    }

    /**
     * @param price_materials the price_materials to set
     */
    public void setPrice_materials(int price_materials) {
        this.price_materials = price_materials;
    }

    /**
     * @return the providersId
     */
    public int getProvidersId() {
        return providersId;
    }

    /**
     * @param providersId the providersId to set
     */
    public void setProvidersId(int providersId) {
        this.providersId = providersId;
    }
    
}
