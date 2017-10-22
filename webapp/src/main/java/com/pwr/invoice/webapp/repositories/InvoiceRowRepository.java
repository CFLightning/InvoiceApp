package com.pwr.invoice.webapp.repositories;

import com.pwr.invoice.webapp.models.InvoiceRowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRowRepository extends JpaRepository<InvoiceRowEntity, Long> {

}
