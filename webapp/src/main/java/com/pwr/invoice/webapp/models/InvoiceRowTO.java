package com.pwr.invoice.webapp.models;

public class InvoiceRowTO {

    private Long rowNumber;
    private String itemName;
    private double nettoItemPrice;
    private double bruttoItemPrice;
    private String itemUnit;
    private double itemAmount;
    private double rowNettoTotal;
    private double rowBruttoTotal;
    private VATGroupEntity vatGroup;

    public Long getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Long rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getNettoItemPrice() {
        return nettoItemPrice;
    }

    public void setNettoItemPrice(double nettoItemPrice) {
        this.nettoItemPrice = nettoItemPrice;
    }

    public double getBruttoItemPrice() {
        return bruttoItemPrice;
    }

    public void setBruttoItemPrice(double bruttoItemPrice) {
        this.bruttoItemPrice = bruttoItemPrice;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public double getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(double itemAmount) {
        this.itemAmount = itemAmount;
    }

    public double getRowNettoTotal() {
        return rowNettoTotal;
    }

    public void setRowNettoTotal(double rowNettoTotal) {
        this.rowNettoTotal = rowNettoTotal;
    }

    public double getRowBruttoTotal() {
        return rowBruttoTotal;
    }

    public void setRowBruttoTotal(double rowBruttoTotal) {
        this.rowBruttoTotal = rowBruttoTotal;
    }

    public VATGroupEntity getVatGroup() {
        return vatGroup;
    }

    public void setVatGroup(VATGroupEntity vatGroup) {
        this.vatGroup = vatGroup;
    }
}
