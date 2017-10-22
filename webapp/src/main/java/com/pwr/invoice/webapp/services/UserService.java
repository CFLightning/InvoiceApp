package com.pwr.invoice.webapp.services;

import com.pwr.invoice.webapp.mappers.UserMapper;
import com.pwr.invoice.webapp.models.UserTO;
import com.pwr.invoice.webapp.repositories.UserRepository;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    private SessionFactory sessionFactory;

    @Override
    public UserTO findUserByLogin(UserTO userTO) {
        Query query = sessionFactory.getCurrentSession().createQuery("from UserEntity where login=:login");
        query.setParameter("login", userTO.getLogin());
        return (UserTO) query.uniqueResult();
    }

    @Override
    public void insertOrModifyUser(UserTO userTO) {
        userRepository.save(UserMapper.mapUserToEntity(userTO));
    }
}
