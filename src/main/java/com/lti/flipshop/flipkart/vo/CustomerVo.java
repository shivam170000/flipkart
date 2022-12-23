package com.lti.flipshop.flipkart.vo;



import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;

public class CustomerVo {



    @NotNull (message = "Enter customerID")
    int customerID;

    @NotNull(message = "Postal Code is required")
    @Min(value=100000, message = "Postal Code must be of 6 digits" )
    @Max(value = 999999, message = "Postal Code must be of 6 digits")
    int postalCode;

    @NotBlank(message = "Customer Name empty !")
    String customerName;

    @NotBlank(message = "Address empty!")
    String address;

    @NotBlank(message = "City empty !")
    String city;
    @NotBlank(message = "Country Invalid")
    String country;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
