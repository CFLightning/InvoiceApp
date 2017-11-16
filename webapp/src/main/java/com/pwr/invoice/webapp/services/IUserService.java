package com.pwr.invoice.webapp.services;

import com.pwr.invoice.webapp.models.CompanyTO;
import com.pwr.invoice.webapp.models.UserTO;

import java.util.List;

public interface IUserService {

    UserTO findUserByLogin(UserTO userTO);
    void insertOrModifyUser(UserTO userTO);
    UserTO checkIfUserExists(UserTO userTO);
    List<UserTO> findCompanyEmployees(CompanyTO companyTO);
}
