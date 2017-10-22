package com.pwr.invoice.webapp.mappers;

import com.pwr.invoice.webapp.models.CompanyEntity;
import com.pwr.invoice.webapp.models.CompanyTO;

public final class CompanyMapper {

    private CompanyMapper() {

    }

    public static CompanyTO mapCompanyToTO(CompanyEntity companyEntity) {
        CompanyTO companyTO = new CompanyTO();
        companyTO.setNIP(companyEntity.getNIP());
        companyTO.setName(companyEntity.getName());
        companyTO.setAddress(companyEntity.getAddress());
        companyTO.setPostalCode(companyEntity.getPostalCode());
        companyTO.setCity(companyEntity.getCity());
        companyTO.setBankAccount(companyEntity.getBankAccount());
        return companyTO;
    }

    public static CompanyEntity mapCompanyToEntity(CompanyTO companyTO) {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setNIP(companyTO.getNIP());
        companyEntity.setName(companyTO.getName());
        companyEntity.setAddress(companyTO.getAddress());
        companyEntity.setPostalCode(companyTO.getPostalCode());
        companyEntity.setCity(companyTO.getCity());
        companyEntity.setBankAccount(companyTO.getBankAccount());
        return companyEntity;
    }
}