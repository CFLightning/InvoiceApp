package com.pwr.invoice.webapp.controllers;

import com.pwr.invoice.webapp.models.CompanyTO;
import com.pwr.invoice.webapp.models.InvoiceHeaderTO;
import com.pwr.invoice.webapp.services.IInvoiceHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "services/invoiceHead")
@CrossOrigin
@Transactional
public class InvoiceHeaderController {

    @Autowired
    private IInvoiceHeaderService iInvoiceHeaderService;

    @RequestMapping(path = "findCompanyHeaders", method = RequestMethod.POST)
    public List<InvoiceHeaderTO> findCompanyHeaders(@RequestBody CompanyTO companyTO){
        return iInvoiceHeaderService.findCompanyHeaders(companyTO);
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public void insertOrModifyHeader(@RequestBody InvoiceHeaderTO invoiceHeaderTO){
        iInvoiceHeaderService.insertOrModifyHeader(invoiceHeaderTO);
    }
}
