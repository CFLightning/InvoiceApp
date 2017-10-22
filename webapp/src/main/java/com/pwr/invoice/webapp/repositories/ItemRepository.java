package com.pwr.invoice.webapp.repositories;

import com.pwr.invoice.webapp.models.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

}
