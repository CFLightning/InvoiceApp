package com.pwr.invoice.webapp.models;


public class CompanyTO {


    private Long NIP;
    private String name;
    private String address;
    private String postalCode;
    private String city;
    private Long bankAccount;

    public Long getNIP() {
        return NIP;
    }

    public void setNIP(Long NIP) {
        this.NIP = NIP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Long bankAccount) {
        this.bankAccount = bankAccount;
    }
}
