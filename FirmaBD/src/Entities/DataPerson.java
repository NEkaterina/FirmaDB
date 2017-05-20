/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Kathy
 */
public class DataPerson {
    private int id;
    private String surname;
    private String firstname;
    private String otchestvo;
    private String passport;
    private Date birthday;
    private String address;
    private String phone;
    
    public DataPerson(int id, String surname, String firstname,String otchestvo, 
            String passport, Date birthday, String address,String phone){
        this.id = id;
        this.surname = surname;
        this.firstname = firstname;
        this.otchestvo = otchestvo;
        this.passport = passport;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        
    
    }

    @Override
    public String toString() {
        return getSurname()+ getFirstname();
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
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the otchestvo
     */
    public String getOtchestvo() {
        return otchestvo;
    }

    /**
     * @param otchestvo the otchestvo to set
     */
    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    /**
     * @return the passport
     */
    public String getPassport() {
        return passport;
    }

    /**
     * @param passport the passport to set
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
