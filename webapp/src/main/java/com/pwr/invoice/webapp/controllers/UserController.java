package com.pwr.invoice.webapp.controllers;

import com.pwr.invoice.webapp.models.UserTO;
import com.pwr.invoice.webapp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping(path = "services/user")
@Transactional
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(path = "findUserByLogin", method = RequestMethod.POST)
    public UserTO findUserByLogin(UserTO userTO) {
        return iUserService.findUserByLogin(userTO);
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public void insertOrModifyUser(UserTO userTO) {
        iUserService.insertOrModifyUser(userTO);
    }
}
