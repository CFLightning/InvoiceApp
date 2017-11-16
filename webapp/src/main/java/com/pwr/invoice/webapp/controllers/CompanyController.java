package com.pwr.invoice.webapp.controllers;

import com.pwr.invoice.webapp.models.CompanyTO;
import com.pwr.invoice.webapp.services.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@CrossOrigin
@RequestMapping(path = "services/company")
@Transactional
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    @RequestMapping(path = "find", method = RequestMethod.POST)
    public CompanyTO findCompany(@RequestBody CompanyTO companyTO){
        return companyService.findCompany(companyTO);
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public void insertOrModifyCompany(@RequestBody CompanyTO companyTO) {
        companyService.insertOrModifyCompany(companyTO);
    }

    @RequestMapping(path = "exists", method = RequestMethod.POST)
    public CompanyTO checkIfCompanyExists(@RequestBody CompanyTO companyTO){
        return companyService.checkIfCompanyExists(companyTO);
    }
}
