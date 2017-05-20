/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Kathy
 */
public class SellingMaterials {
     private int sellingId;
    private int materialsId;
    private int  amount;
    
    public SellingMaterials(int sellingId,  int materialsId, int amount){
        this.sellingId = sellingId;
        this.materialsId = materialsId;
        this.amount = amount;
    }

    /**
     * @return the sellingId
     */
    public int getSellingId() {
        return sellingId;
    }

    /**
     * @param sellingId the sellingId to set
     */
    public void setSellingId(int sellingId) {
        this.sellingId = sellingId;
    }

    /**
     * @return the materialsId
     */
    public int getMaterialsId() {
        return materialsId;
    }

    /**
     * @param materialsId the materialsId to set
     */
    public void setMaterialsId(int materialsId) {
        this.materialsId = materialsId;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
