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
public class Providers {
     private int id;
    private String company_name;
    private String address_company;
    private String phone_company;
    
    
    public Providers(int id, String company_name, String address_company,
            String phone_company){
        this.id = id;
        this.company_name = company_name;
        this.address_company = address_company;
        this.phone_company = phone_company;   
    }
@Override
    public String toString() {
        return getCompany_name();
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
     * @return the company_name
     */
    public String getCompany_name() {
        return company_name;
    }

    /**
     * @param company_name the company_name to set
     */
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    /**
     * @return the address_company
     */
    public String getAddress_company() {
        return address_company;
    }

    /**
     * @param address_company the address_company to set
     */
    public void setAddress_company(String address_company) {
        this.address_company = address_company;
    }

    /**
     * @return the phone_company
     */
    public String getPhone_company() {
        return phone_company;
    }

    /**
     * @param phone_company the phone_company to set
     */
    public void setPhone_company(String phone_company) {
        this.phone_company = phone_company;
    }
    
}
