package com.pwr.invoice.webapp.services;

import com.pwr.invoice.webapp.mappers.CompanyMapper;
import com.pwr.invoice.webapp.models.CompanyEntity;
import com.pwr.invoice.webapp.models.CompanyTO;
import com.pwr.invoice.webapp.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyTO findCompany(CompanyTO companyTO) {
        CompanyEntity companyEntity = companyRepository.findOne(companyTO.getNIP());
        return CompanyMapper.mapCompanyToTO(companyEntity);
    }

    @Override
    public void insertOrModifyCompany(CompanyTO companyTO) {
        companyRepository.save(CompanyMapper.mapCompanyToEntity(companyTO));
    }
}
