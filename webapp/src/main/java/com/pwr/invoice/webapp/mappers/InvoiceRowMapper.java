package com.pwr.invoice.webapp.mappers;

import com.pwr.invoice.webapp.models.InvoiceHeaderTO;
import com.pwr.invoice.webapp.models.InvoiceRowEntity;
import com.pwr.invoice.webapp.models.InvoiceRowTO;

public final class InvoiceRowMapper {

    private InvoiceRowMapper() {

    }

    public static InvoiceRowTO mapInvoiceRowToTO(InvoiceRowEntity invoiceRowEntity){
        InvoiceRowTO invoiceRowTO = new InvoiceRowTO();
        invoiceRowTO.setRowNumber(invoiceRowEntity.getRowNumber());
        invoiceRowTO.setItemName(invoiceRowEntity.getItemName());
        invoiceRowTO.setNettoItemPrice(invoiceRowEntity.getNettoItemPrice());
        invoiceRowTO.setBruttoItemPrice(invoiceRowEntity.getBruttoItemPrice());
        invoiceRowTO.setItemUnit(invoiceRowEntity.getItemUnit());
        invoiceRowTO.setItemAmount(invoiceRowEntity.getItemAmount());
        invoiceRowTO.setRowNettoTotal(invoiceRowEntity.getRowNettoTotal());
        invoiceRowTO.setRowBruttoTotal(invoiceRowEntity.getRowBruttoTotal());
        return invoiceRowTO;
    }

    public static InvoiceRowEntity mapInvoiceRowToEntity(InvoiceRowTO invoiceRowTO){
        InvoiceRowEntity invoiceRowEntity = new InvoiceRowEntity();
        invoiceRowEntity.setRowNumber(invoiceRowTO.getRowNumber());
        invoiceRowEntity.setItemName(invoiceRowTO.getItemName());
        invoiceRowEntity.setNettoItemPrice(invoiceRowTO.getNettoItemPrice());
        invoiceRowEntity.setBruttoItemPrice(invoiceRowTO.getBruttoItemPrice());
        invoiceRowEntity.setItemUnit(invoiceRowTO.getItemUnit());
        invoiceRowEntity.setItemAmount(invoiceRowTO.getItemAmount());
        invoiceRowEntity.setRowNettoTotal(invoiceRowTO.getRowNettoTotal());
        invoiceRowEntity.setRowBruttoTotal(invoiceRowTO.getRowBruttoTotal());
        return invoiceRowEntity;
    }
}
