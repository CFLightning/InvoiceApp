package com.pwr.invoice.webapp.services;

import com.pwr.invoice.webapp.models.CompanyTO;
import com.pwr.invoice.webapp.models.InvoiceHeaderTO;

import java.util.List;

public interface IInvoiceHeaderService {

    List<InvoiceHeaderTO> findCompanyHeaders(CompanyTO companyTO);
    void insertOrModifyHeader(InvoiceHeaderTO invoiceHeaderTO);
}
