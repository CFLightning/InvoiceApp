package com.pwr.invoice.webapp.services;

import com.pwr.invoice.webapp.mappers.InvoiceRowMapper;
import com.pwr.invoice.webapp.models.InvoiceHeaderTO;
import com.pwr.invoice.webapp.models.InvoiceRowTO;
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

    @Override
    public List<InvoiceRowTO> findInvoiceRows(InvoiceHeaderTO invoiceHeaderTO){
        List<InvoiceRowTO> invoiceRowTOS = new ArrayList<>();
        invoiceRowRepository.findAll().forEach(invoiceRowEntity -> invoiceRowTOS.add(InvoiceRowMapper.mapInvoiceRowToTO(invoiceRowEntity)));
        return invoiceRowTOS.stream().filter(row -> invoiceHeaderTO.getRows().contains(row)).collect(Collectors.toList());
    }

    @Override
    public void insertOrModifyRows(List<InvoiceRowTO> invoiceRowTOS){
        for (InvoiceRowTO invoiceRowTo : invoiceRowTOS) {
            invoiceRowRepository.save(InvoiceRowMapper.mapInvoiceRowToEntity(invoiceRowTo));
        }
    }
}
