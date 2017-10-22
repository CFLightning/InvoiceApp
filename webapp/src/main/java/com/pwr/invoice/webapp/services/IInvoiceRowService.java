package com.pwr.invoice.webapp.services;

import com.pwr.invoice.webapp.models.InvoiceHeaderTO;
import com.pwr.invoice.webapp.models.InvoiceRowTO;

import java.util.List;

public interface IInvoiceRowService {

    List<InvoiceRowTO> findInvoiceRows(InvoiceHeaderTO invoiceHeaderTO);
    void insertOrModifyRows(List<InvoiceRowTO> invoiceRowTOS);
}
