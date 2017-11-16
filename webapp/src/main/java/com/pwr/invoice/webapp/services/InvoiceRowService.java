package com.pwr.invoice.webapp.services;

import com.pwr.invoice.webapp.mappers.InvoiceHeaderMapper;
import com.pwr.invoice.webapp.mappers.InvoiceRowMapper;
import com.pwr.invoice.webapp.models.InvoiceHeaderEntity;
import com.pwr.invoice.webapp.models.InvoiceHeaderTO;
import com.pwr.invoice.webapp.models.InvoiceRowEntity;
import com.pwr.invoice.webapp.models.InvoiceRowTO;
import com.pwr.invoice.webapp.repositories.InvoiceHeaderRepository;
import com.pwr.invoice.webapp.repositories.InvoiceRowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceRowService implements IInvoiceRowService{

    @Autowired
    private InvoiceRowRepository invoiceRowRepository;

    @Autowired
    private InvoiceHeaderRepository invoiceHeaderRepository;

    @Override
    public List<InvoiceRowTO> findInvoiceRows(InvoiceHeaderTO invoiceHeaderTO){
//        List<InvoiceRowTO> invoiceRowTOS = new ArrayList<>();
//        invoiceRowRepository.findAll().forEach(invoiceRowEntity -> invoiceRowTOS.add(InvoiceRowMapper.mapInvoiceRowToTO(invoiceRowEntity)));
//        return invoiceRowTOS.stream().filter(row -> invoiceHeaderTO.getRows().contains(row)).collect(Collectors.toList());

        InvoiceHeaderEntity invoiceHeaderEntity = invoiceHeaderRepository.findOne(invoiceHeaderTO.getId());
        List<InvoiceRowEntity> invoiceRowEntities = invoiceHeaderEntity.getRows();
        List<InvoiceRowTO> invoiceRowTOS = new ArrayList<>();

        for (InvoiceRowEntity invoiceRowEntity:invoiceRowEntities) {
            invoiceRowTOS.add(InvoiceRowMapper.mapInvoiceRowToTO(invoiceRowEntity));
        }

        return invoiceRowTOS;
    }

    @Override
    public void insertOrModifyRows(List<InvoiceRowTO> invoiceRowTOS){
        for (InvoiceRowTO invoiceRowTo : invoiceRowTOS) {
            invoiceRowRepository.save(InvoiceRowMapper.mapInvoiceRowToEntity(invoiceRowTo));
        }
    }
}
