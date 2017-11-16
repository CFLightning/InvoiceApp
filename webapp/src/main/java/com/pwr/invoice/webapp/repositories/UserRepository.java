package com.pwr.invoice.webapp.repositories;

import com.pwr.invoice.webapp.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
