package com.pwr.invoice.webapp.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class InvoiceHeaderEntity {


    @Id
    @GeneratedValue
    private Long Id;
    @Column
    private String invoiceNumber;
    @ManyToOne
    private CompanyEntity company;
    @Column
    private String issueDate;
    @Column
    private String buyerName;
    @Column
    private String buyerAddress;
    @Column
    private String buyerPostalCode;
    @Column
    private String buyerCity;
    @Column
    private Long buyerNIP;
    @Column
    private double nettoTotal;
    @Column
    private double bruttoTotal;
    @Column
    private double vatTotal;
    @ManyToOne
    private UserEntity issuer;
    @OneToMany(cascade = CascadeType.ALL)
    private List<InvoiceRowEntity> rows = new ArrayList<>();

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
    @JsonManagedReference
    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerPostalCode() {
        return buyerPostalCode;
    }

    public void setBuyerPostalCode(String buyerPostalCode) {
        this.buyerPostalCode = buyerPostalCode;
    }

    public String getBuyerCity() {
        return buyerCity;
    }

    public void setBuyerCity(String buyerCity) {
        this.buyerCity = buyerCity;
    }

    public Long getBuyerNIP() {
        return buyerNIP;
    }

    public void setBuyerNIP(Long buyerNIP) {
        this.buyerNIP = buyerNIP;
    }

    public double getNettoTotal() {
        return nettoTotal;
    }

    public void setNettoTotal(double nettoTotal) {
        this.nettoTotal = nettoTotal;
    }

    public double getBruttoTotal() {
        return bruttoTotal;
    }

    public void setBruttoTotal(double bruttoTotal) {
        this.bruttoTotal = bruttoTotal;
    }

    public double getVatTotal() {
        return vatTotal;
    }

    public void setVatTotal(double vatTotal) {
        this.vatTotal = vatTotal;
    }

    public UserEntity getIssuer() {
        return issuer;
    }

    public void setIssuer(UserEntity issuer) {
        this.issuer = issuer;
    }

    public List<InvoiceRowEntity> getRows() {
        return rows;
    }

    public void setRows(List<InvoiceRowEntity> rows) {
        this.rows = rows;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
