package com.pwr.invoice.webapp.controllers;

import com.pwr.invoice.webapp.models.CompanyTO;
import com.pwr.invoice.webapp.models.UserTO;
import com.pwr.invoice.webapp.services.ITokenService;
import com.pwr.invoice.webapp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "services/user")
@Transactional
public class UserController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ITokenService iTokenService;


    @RequestMapping(path = "findUserByLogin", method = RequestMethod.POST) //, @CookieValue("currentUser") String cookie
    public UserTO findUserByLogin(@RequestBody UserTO userTO) {
        return iUserService.findUserByLogin(userTO);
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public UserTO insertOrModifyUser(@RequestBody UserTO userTO) {
        String login = userTO.getLogin();
        userTO.setToken(iTokenService.generateToken(userTO.getLogin()));
        iUserService.insertOrModifyUser(userTO);
        return userTO;
    }

    @RequestMapping(path = "exists", method = RequestMethod.POST) //, @CookieValue("currentUser") String cookie
    public UserTO checkIfUserExists(@RequestBody UserTO userTO) {
        return iUserService.checkIfUserExists(userTO);
    }

    @RequestMapping(path = "findByCompany", method = RequestMethod.POST)
    public List<UserTO> findByCompany(@RequestBody CompanyTO companyTO) {
        return iUserService.findCompanyEmployees(companyTO);
    }
}
