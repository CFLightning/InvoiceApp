package com.pwr.invoice.webapp.mappers;

import com.pwr.invoice.webapp.models.ItemEntity;
import com.pwr.invoice.webapp.models.ItemTO;

public final class ItemMapper {

    private ItemMapper() {

    }

    public static ItemTO mapItemToTO(ItemEntity itemEntity) {
        ItemTO itemTO = new ItemTO();
        itemTO.setName(itemEntity.getName());
        itemTO.setNettoPrice(itemEntity.getNettoPrice());
        itemTO.setBruttoPrice(itemEntity.getBruttoPrice());
        itemTO.setUnit(itemEntity.getUnit());
        itemTO.setVatGroup(itemEntity.getVatGroup());
        itemTO.setCompany(itemEntity.getCompany());
        return itemTO;
    }

    public static ItemEntity mapItemToEntity(ItemTO itemTO) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setName(itemTO.getName());
        itemEntity.setNettoPrice(itemTO.getNettoPrice());
        itemEntity.setBruttoPrice(itemTO.getBruttoPrice());
        itemEntity.setUnit(itemTO.getUnit());
        itemEntity.setVatGroup(itemTO.getVatGroup());
        itemEntity.setCompany(itemTO.getCompany());
        return itemEntity;
    }
}
