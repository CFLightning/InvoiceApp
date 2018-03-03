package com.pwr.invoice.webapp.services;

import com.pwr.invoice.webapp.mappers.ItemMapper;
import com.pwr.invoice.webapp.models.CompanyTO;
import com.pwr.invoice.webapp.models.ItemTO;
import com.pwr.invoice.webapp.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<ItemTO> findCompanyItems(CompanyTO companyTO){
        List<ItemTO> itemTOS = new ArrayList<>();
        itemRepository.findAll().forEach(itemEntity -> itemTOS.add(ItemMapper.mapItemToTO(itemEntity)));
        return itemTOS.stream().filter(item -> item.getCompany().getNip().equals(companyTO.getNip())).collect(Collectors.toList());
    }

    @Override
    public void insertOrModifyItem(ItemTO itemTO) {
        double brutto = itemTO.getNettoPrice() + (itemTO.getNettoPrice() * (itemTO.getVatGroup().getTaxRate() / 100));
        double roundOff = Math.round(brutto * 100.0) / 100.0;
        itemTO.setBruttoPrice(roundOff);
        itemRepository.save(ItemMapper.mapItemToEntity(itemTO));
    }
}
