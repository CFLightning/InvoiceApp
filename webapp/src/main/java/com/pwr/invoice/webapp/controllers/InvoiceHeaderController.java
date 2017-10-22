package com.pwr.invoice.webapp.controllers;

import com.pwr.invoice.webapp.models.CompanyTO;
import com.pwr.invoice.webapp.models.InvoiceHeaderTO;
import com.pwr.invoice.webapp.services.IInvoiceHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "services/invoiceHead")
@Transactional
public class InvoiceHeaderController {

    @Autowired
    private IInvoiceHeaderService iInvoiceHeaderService;

    @RequestMapping(path = "findCompanyHeaders", method = RequestMethod.POST)
    public List<InvoiceHeaderTO> findCompanyHeaders(CompanyTO companyTO){
        return iInvoiceHeaderService.findCompanyHeaders(companyTO);
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public void insertOrModifyHeader(InvoiceHeaderTO invoiceHeaderTO){
        iInvoiceHeaderService.insertOrModifyHeader(invoiceHeaderTO);
    }
}
