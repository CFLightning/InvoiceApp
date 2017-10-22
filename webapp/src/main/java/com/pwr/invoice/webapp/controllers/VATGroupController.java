package com.pwr.invoice.webapp.controllers;

import com.pwr.invoice.webapp.models.VATGroupTO;
import com.pwr.invoice.webapp.services.IVATGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "services/vatGroup")
@Transactional
public class VATGroupController {

    @Autowired
    private IVATGroupService ivatGroupService;

    @RequestMapping(path = "findGroups", method = RequestMethod.GET)
    public List<VATGroupTO> findAllGroups() {
        return ivatGroupService.findAllGroups();
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public void insertOrModifyGroup(VATGroupTO vatGroupTO){
        ivatGroupService.insertOrModifyGroup(vatGroupTO);
    }
}
