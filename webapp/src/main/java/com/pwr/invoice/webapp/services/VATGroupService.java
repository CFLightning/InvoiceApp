package com.pwr.invoice.webapp.services;

import com.pwr.invoice.webapp.mappers.VATGroupMapper;
import com.pwr.invoice.webapp.models.VATGroupTO;
import com.pwr.invoice.webapp.repositories.VATGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VATGroupService implements IVATGroupService {

    @Autowired
    private VATGroupRepository vatGroupRepository;

    @Override
    public List<VATGroupTO> findAllGroups(){
        List<VATGroupTO> vatGroupTOS = new ArrayList<>();
        vatGroupRepository.findAll().forEach(vatGroupEntity -> vatGroupTOS.add(VATGroupMapper.mapVATGroupToTO(vatGroupEntity)));
        return vatGroupTOS;
    }

    @Override
    public void insertOrModifyGroup(VATGroupTO vatGroupTO){
        vatGroupRepository.save(VATGroupMapper.mapVATGroupToEntity(vatGroupTO));
    }
}
