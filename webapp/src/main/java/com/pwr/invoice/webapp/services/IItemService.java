package com.pwr.invoice.webapp.services;

import com.pwr.invoice.webapp.models.CompanyTO;
import com.pwr.invoice.webapp.models.ItemTO;

import java.util.List;

public interface IItemService {

    List<ItemTO> findCompanyItems(CompanyTO companyTO);
    void insertOrModifyItem(ItemTO itemTO);

}
