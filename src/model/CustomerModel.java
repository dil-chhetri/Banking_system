/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dil
 */
public class CustomerModel {
    private int CustomerID;
    private String FirstName;
    private String LastName;
    private String Email;
    private long PhoneNumber;
    private String Address;
    
    public int getCustomerID(){
        return CustomerID;
    }
    
    public void setCustomerID(int CustomerID){
        this.CustomerID = CustomerID;
    }
    
    
    public String getFirstName(){
        return FirstName;
    }
    
    
    public void setFirstName(String FirstName){
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(long PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    @Override
    public String toString() {
        return "CustomerModel{" + "CustomerID=" + CustomerID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + ", PhoneNumber=" + PhoneNumber + ", Address=" + Address + '}';
    }
    
    
    
}
