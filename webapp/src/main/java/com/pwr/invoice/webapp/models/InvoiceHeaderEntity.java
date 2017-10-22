package com.pwr.invoice.webapp.models;

import javax.persistence.*;
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
    private double VATTotal;
    @ManyToOne
    private UserEntity issuer;
    @OneToMany
    private List<InvoiceRowEntity> rows;

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

    public double getVATTotal() {
        return VATTotal;
    }

    public void setVATTotal(double VATTotal) {
        this.VATTotal = VATTotal;
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
