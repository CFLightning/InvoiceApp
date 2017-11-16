package com.pwr.invoice.webapp.mappers;

import com.pwr.invoice.webapp.models.InvoiceHeaderEntity;
import com.pwr.invoice.webapp.models.InvoiceHeaderTO;

public final class InvoiceHeaderMapper {

    private InvoiceHeaderMapper() {

    }

    public static InvoiceHeaderTO mapInvoiceHeaderToTO(InvoiceHeaderEntity invoiceHeaderEntity){
        InvoiceHeaderTO invoiceHeaderTO = new InvoiceHeaderTO();
        invoiceHeaderTO.setId(invoiceHeaderEntity.getId());
        invoiceHeaderTO.setInvoiceNumber(invoiceHeaderEntity.getInvoiceNumber());
        invoiceHeaderTO.setCompany(invoiceHeaderEntity.getCompany());
        invoiceHeaderTO.setIssueDate(invoiceHeaderEntity.getIssueDate());
        invoiceHeaderTO.setBuyerName(invoiceHeaderEntity.getBuyerName());
        invoiceHeaderTO.setBuyerAddress(invoiceHeaderEntity.getBuyerAddress());
        invoiceHeaderTO.setBuyerPostalCode(invoiceHeaderEntity.getBuyerPostalCode());
        invoiceHeaderTO.setBuyerCity(invoiceHeaderEntity.getBuyerCity());
        invoiceHeaderTO.setBuyerNIP(invoiceHeaderEntity.getBuyerNIP());
        invoiceHeaderTO.setNettoTotal(invoiceHeaderEntity.getNettoTotal());
        invoiceHeaderTO.setBruttoTotal(invoiceHeaderEntity.getBruttoTotal());
        invoiceHeaderTO.setVATTotal(invoiceHeaderEntity.getVATTotal());
        invoiceHeaderTO.setIssuer(invoiceHeaderEntity.getIssuer());
        invoiceHeaderTO.setRows(invoiceHeaderEntity.getRows());
        return  invoiceHeaderTO;
    }

    public static InvoiceHeaderEntity mapInvoiceHeaderToEntity(InvoiceHeaderTO invoiceHeaderTO){
        InvoiceHeaderEntity invoiceHeaderEntity = new InvoiceHeaderEntity();
        invoiceHeaderEntity.setId(invoiceHeaderTO.getId());
        invoiceHeaderEntity.setInvoiceNumber(invoiceHeaderTO.getInvoiceNumber());
        invoiceHeaderEntity.setCompany(invoiceHeaderTO.getCompany());
        invoiceHeaderEntity.setIssueDate(invoiceHeaderTO.getIssueDate());
        invoiceHeaderEntity.setBuyerName(invoiceHeaderTO.getBuyerName());
        invoiceHeaderEntity.setBuyerAddress(invoiceHeaderTO.getBuyerAddress());
        invoiceHeaderEntity.setBuyerPostalCode(invoiceHeaderTO.getBuyerPostalCode());
        invoiceHeaderEntity.setBuyerCity(invoiceHeaderTO.getBuyerCity());
        invoiceHeaderEntity.setBuyerNIP(invoiceHeaderTO.getBuyerNIP());
        invoiceHeaderEntity.setNettoTotal(invoiceHeaderTO.getNettoTotal());
        invoiceHeaderEntity.setBruttoTotal(invoiceHeaderTO.getBruttoTotal());
        invoiceHeaderEntity.setVATTotal(invoiceHeaderTO.getVATTotal());
        invoiceHeaderEntity.setIssuer(invoiceHeaderTO.getIssuer());
        invoiceHeaderEntity.setRows(invoiceHeaderTO.getRows());
        return  invoiceHeaderEntity;
    }
}
