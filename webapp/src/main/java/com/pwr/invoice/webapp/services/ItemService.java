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
        itemRepository.findAll().forEach(itemEntity -> ItemMapper.mapItemToTO(itemEntity));
        return itemTOS.stream().filter(item -> item.getCompany().getNIP() == companyTO.getNIP()).collect(Collectors.toList());
    }

    @Override
    public void insertOrModifyItem(ItemTO itemTO) {
        itemRepository.save(ItemMapper.mapItemToEntity(itemTO));
    }
}
