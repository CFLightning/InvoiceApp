package com.pwr.invoice.webapp.services;

import com.pwr.invoice.webapp.mappers.InvoiceHeaderMapper;
import com.pwr.invoice.webapp.models.CompanyTO;
import com.pwr.invoice.webapp.models.InvoiceHeaderTO;
import com.pwr.invoice.webapp.repositories.InvoiceHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceHeaderService implements IInvoiceHeaderService {

    @Autowired
    private InvoiceHeaderRepository invoiceHeaderRepository;

    @Override
    public List<InvoiceHeaderTO> findCompanyHeaders(CompanyTO companyTO) {
        List<InvoiceHeaderTO> invoiceHeaderTOS = new ArrayList<>();
        invoiceHeaderRepository.findAll().forEach(invoiceHeaderEntity -> invoiceHeaderTOS.add(InvoiceHeaderMapper.mapInvoiceHeaderToTO(invoiceHeaderEntity)));
        return invoiceHeaderTOS.stream().filter(head -> head.getCompany().getNIP() == companyTO.getNIP()).collect(Collectors.toList());
    }

    @Override
    public void insertOrModifyHeader(InvoiceHeaderTO invoiceHeaderTO){
        invoiceHeaderRepository.save(InvoiceHeaderMapper.mapInvoiceHeaderToEntity(invoiceHeaderTO));
    }
}
