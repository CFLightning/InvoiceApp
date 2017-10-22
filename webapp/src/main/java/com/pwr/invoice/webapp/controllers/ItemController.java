package com.pwr.invoice.webapp.controllers;

import com.pwr.invoice.webapp.models.CompanyTO;
import com.pwr.invoice.webapp.models.ItemTO;
import com.pwr.invoice.webapp.services.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "services/item")
@Transactional
public class ItemController {

    @Autowired
    private IItemService iItemService;

    @RequestMapping(path = "findCompanyItems", method = RequestMethod.POST)
    public List<ItemTO> findCompanyItems(CompanyTO companyTO){
        return iItemService.findCompanyItems(companyTO);
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public void insertOrModifyItem(ItemTO itemTO){
        iItemService.insertOrModifyItem(itemTO);
    }
}
