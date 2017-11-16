package com.pwr.invoice.webapp.models;

import javax.persistence.*;

@Entity
public class CompanyEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nip;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String postalCode;
    @Column
    private String city;
    @Column
    private String bankAccount;

    public CompanyEntity(Long nip, String name, String address, String postalCode, String city, String bankAccount){
        this.nip = nip;
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.bankAccount = bankAccount;
    }

    public CompanyEntity() {}

    public Long getNip() {
        return nip;
    }

    public void setNip(Long nip) {
        this.nip = nip;
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

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
}
