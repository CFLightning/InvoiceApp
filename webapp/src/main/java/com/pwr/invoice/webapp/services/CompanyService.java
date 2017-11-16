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
        CompanyEntity companyEntity = companyRepository.findOne(companyTO.getNip());
        if(companyEntity != null && companyEntity.getNip().equals(companyTO.getNip())){
            return CompanyMapper.mapCompanyToTO(companyEntity);
        }
        else
        {
            return null;
        }
    }

    @Override
    public void insertOrModifyCompany(CompanyTO companyTO) {
        CompanyEntity companyEntity = CompanyMapper.mapCompanyToEntity(companyTO);
        companyRepository.save(companyEntity);
    }

    @Override
    public CompanyTO checkIfCompanyExists(CompanyTO companyTO) {
        CompanyEntity companyEntity = companyRepository.findOne(companyTO.getNip());
        if(companyEntity != null && companyEntity.getNip().equals(companyTO.getNip())){
            return CompanyMapper.mapCompanyToTO(companyEntity);
        }
        else
        {
            CompanyTO empty = new CompanyTO();
            empty.setNip(0L);
            return empty;
        }
    }
}
