package com.pwr.invoice.webapp.repositories;

import com.pwr.invoice.webapp.models.InvoiceHeaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceHeaderRepository extends JpaRepository<InvoiceHeaderEntity, String> {

}
