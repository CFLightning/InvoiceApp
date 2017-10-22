package com.pwr.invoice.webapp.services;

import com.pwr.invoice.webapp.models.UserTO;

public interface IUserService {

    UserTO findUserByLogin(UserTO userTO);
    void insertOrModifyUser(UserTO userTO);

}
