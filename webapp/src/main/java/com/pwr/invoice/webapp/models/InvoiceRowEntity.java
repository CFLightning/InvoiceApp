package com.pwr.invoice.webapp.models;

import javax.persistence.*;

@Entity
public class InvoiceRowEntity {

    @Id
    @GeneratedValue
    private Long rowNumber;
    @Column
    private String itemName;
    @Column
    private double nettoItemPrice;
    @Column
    private double bruttoItemPrice;
    @Column
    private String itemUnit;
    @Column
    private double itemAmount;
    @Column
    private double rowNettoTotal;
    @Column
    private double rowBruttoTotal;

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
}
