package com.pwr.invoice.webapp.services;

import com.pwr.invoice.webapp.models.VATGroupTO;

import java.util.List;

public interface IVATGroupService {

    List<VATGroupTO> findAllGroups();
    VATGroupTO insertOrModifyGroup(VATGroupTO vatGroupTO);

}
