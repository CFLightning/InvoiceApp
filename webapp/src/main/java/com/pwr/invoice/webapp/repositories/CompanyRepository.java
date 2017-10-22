package com.pwr.invoice.webapp.repositories;

import com.pwr.invoice.webapp.models.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long>{

}
