package com.pwr.invoice.webapp.controllers;

import com.pwr.invoice.webapp.models.CompanyTO;
import com.pwr.invoice.webapp.services.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
//@CrossOrigin - moze sie przydac potem
@RequestMapping(path = "services/company")
@Transactional
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    @RequestMapping(path = "find", method = RequestMethod.POST)
    public CompanyTO findCompany(CompanyTO companyTO){
        return companyService.findCompany(companyTO);
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public void insertOrModifyCompany(CompanyTO companyTO) {
        companyService.insertOrModifyCompany(companyTO);
    }
}
