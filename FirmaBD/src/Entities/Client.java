/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kathy
 */
public class Client {
    private int id;
    private int DataPId;
     private Connection c;
    
    public  Client(int id, int dataPId){
        this.id = id;
        this.DataPId = dataPId;
        
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
     * @return the DataPId
     */
    public int getDataPId() {
        return DataPId;
    }

    /**
     * @param DataPId the DataPId to set
     */
    public void setDataPId(int DataPId) {
        this.DataPId = DataPId;
    }
    
    
}
