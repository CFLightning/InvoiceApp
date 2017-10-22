package com.pwr.invoice.webapp.mappers;

import com.pwr.invoice.webapp.models.VATGroupEntity;
import com.pwr.invoice.webapp.models.VATGroupTO;

public class VATGroupMapper {

    private VATGroupMapper(){

    }

    public static VATGroupTO mapVATGroupToTO(VATGroupEntity vatGroupEntity){
        VATGroupTO vatGroupTO = new VATGroupTO();
        vatGroupTO.setName(vatGroupEntity.getName());
        vatGroupTO.setTaxRate(vatGroupEntity.getTaxRate());
        return vatGroupTO;
    }

    public static VATGroupEntity mapVATGroupToEntity(VATGroupTO vatGroupTO){
        VATGroupEntity vatGroupEntity = new VATGroupEntity();
        vatGroupEntity.setName(vatGroupTO.getName());
        vatGroupEntity.setTaxRate(vatGroupTO.getTaxRate());
        return vatGroupEntity;
    }
}
