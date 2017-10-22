package com.pwr.invoice.webapp.models;

import java.util.List;

public class InvoiceHeaderTO {

    private String invoiceNumber;
    private CompanyEntity company;
    private String issueDate;
    private String buyerName;
    private String buyerAddress;
    private String buyerPostalCode;
    private String buyerCity;
    private Long buyerNIP;
    private double nettoTotal;
    private double bruttoTotal;
    private double VATTotal;
    private UserEntity issuer;
    private List<InvoiceRowEntity> rows;

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
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
}
