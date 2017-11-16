package com.pwr.invoice.webapp.models;

import javax.persistence.*;

@Entity
public class ItemEntity {

    @Id
    private String name;
    @Column
    private double nettoPrice;
    @Column
    private double bruttoPrice;
    @Column
    private String unit; //jednostka miary
    @ManyToOne(cascade = CascadeType.ALL)
    private VATGroupEntity vatGroup;
    @ManyToOne(cascade = CascadeType.ALL)
    private CompanyEntity company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNettoPrice() {
        return nettoPrice;
    }

    public void setNettoPrice(double nettoPrice) {
        this.nettoPrice = nettoPrice;
    }

    public double getBruttoPrice() {
        return bruttoPrice;
    }

    public void setBruttoPrice(double bruttoPrice) {
        this.bruttoPrice = bruttoPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public VATGroupEntity getVatGroup() {
        return vatGroup;
    }

    public void setVatGroup(VATGroupEntity vatGroup) {
        this.vatGroup = vatGroup;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

}
