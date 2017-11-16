package com.pwr.invoice.webapp.controllers;

import com.pwr.invoice.webapp.models.InvoiceHeaderTO;
import com.pwr.invoice.webapp.models.InvoiceRowTO;
import com.pwr.invoice.webapp.services.IInvoiceRowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "services/invoiceRow")
@CrossOrigin
@Transactional
public class InvoiceRowController {

    @Autowired
    private IInvoiceRowService iInvoiceRowService;

    @RequestMapping(path = "findInvoiceRows", method = RequestMethod.POST)
    public List<InvoiceRowTO> findInvoiceRows(@RequestBody InvoiceHeaderTO invoiceHeaderTO){
        return iInvoiceRowService.findInvoiceRows(invoiceHeaderTO);
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public void insertOrModifyRow(@RequestBody List<InvoiceRowTO> invoiceRowTOS){
        iInvoiceRowService.insertOrModifyRows(invoiceRowTOS);
    }
}
