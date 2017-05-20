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
public class co_worker {
 
    private int id;
    private int DataPId;
    private String post;
    private int salary;
    
    public  co_worker (int id, int dataPId, String post, int salary){
        this.id = id;
        this.DataPId = dataPId;
        this.post = post;
        this.salary = salary;
        
        
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

    /**
     * @return the post
     */
    public String getPost() {
        return post;
    }

    /**
     * @param post the post to set
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    


}
