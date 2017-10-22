package com.pwr.invoice.webapp.services;

import com.pwr.invoice.webapp.models.CompanyEntity;
import com.pwr.invoice.webapp.models.CompanyTO;

public interface ICompanyService {

    CompanyTO findCompany(CompanyTO companyTO);
    void insertOrModifyCompany(CompanyTO companyTO);

}
