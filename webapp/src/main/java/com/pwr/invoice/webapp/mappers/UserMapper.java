package com.pwr.invoice.webapp.mappers;

import com.pwr.invoice.webapp.models.UserEntity;
import com.pwr.invoice.webapp.models.UserTO;

public class UserMapper {

    private UserMapper() {

    }

    public static UserTO mapUserToTO(UserEntity userEntity){
        UserTO userTO = new UserTO();
        userTO.setName(userEntity.getName());
        userTO.setSurname(userEntity.getSurname());
        userTO.setCompany(userEntity.getCompany());
        userTO.setAccountType(userEntity.getAccountType());
        userTO.setLogin(userEntity.getLogin());
        userTO.setPassword(userEntity.getPassword());
        userTO.setToken(userEntity.getToken());
        return userTO;
    }

    public static UserEntity mapUserToEntity(UserTO userTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userTO.getName());
        userEntity.setSurname(userTO.getSurname());
        userEntity.setCompany(userTO.getCompany());
        userEntity.setAccountType(userTO.getAccountType());
        userEntity.setLogin(userTO.getLogin());
        userEntity.setPassword(userTO.getPassword());
        userEntity.setToken(userTO.getToken());
        return userEntity;
    }
}
