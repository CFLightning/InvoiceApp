package com.pwr.invoice.webapp.services;

import com.pwr.invoice.webapp.mappers.UserMapper;
import com.pwr.invoice.webapp.models.CompanyTO;
import com.pwr.invoice.webapp.models.UserEntity;
import com.pwr.invoice.webapp.models.UserTO;
import com.pwr.invoice.webapp.repositories.UserRepository;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    //private SessionFactory sessionFactory;

    @Override
    public UserTO findUserByLogin(UserTO userTO) {
        UserEntity userEntity = userRepository.findOne(userTO.getLogin()); //
        if(userEntity != null && userEntity.getPassword().equals(userTO.getPassword())) {
            return UserMapper.mapUserToTO(userEntity);
        }
        else
        {
            return null;
        }
    }

    @Override
    public void insertOrModifyUser(UserTO userTO) {
        UserEntity userEntity = UserMapper.mapUserToEntity(userTO);
        userRepository.save(userEntity);
    }

    @Override
    public UserTO checkIfUserExists(UserTO userTO) {
        UserEntity userEntity = userRepository.findOne(userTO.getLogin()); //
        if(userEntity != null && userEntity.getLogin().equals(userTO.getLogin())) {
            return UserMapper.mapUserToTO(userEntity);
        }
        else
        {
            UserTO empty = new UserTO();
            empty.setLogin("");
            return empty;
        }
    }

    @Override
    public List<UserTO> findCompanyEmployees(CompanyTO companyTO) {
        List<UserTO> userTOS = new ArrayList<>();
        userRepository.findAll().forEach(userEntity -> userTOS.add(UserMapper.mapUserToTO(userEntity)));
        return userTOS.stream().filter(head -> companyTO.getNip().equals(head.getCompany().getNip())).collect(Collectors.toList());
    }
}
