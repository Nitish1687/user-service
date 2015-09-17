package com.nitish.service;

import com.nitish.bean.User;
import com.nitish.domain.UserDomain;
import com.nitish.mapper.UserMapper;
import com.nitish.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

import static java.lang.String.valueOf;

/**
 * Created by nsm1211 on 16-09-2015.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper mapper;

    public User getUserFor(int userId) {
        User user = null;
        try {
            List<UserDomain> userDomainFor = userRepository.getUserDomainFor(valueOf(userId));
            if (null != userDomainFor) {
                user= mapper.mapToBean(userDomainFor.get(0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User saveUser(User user) {
        User tempUser = null;
        try {
            tempUser = mapper.mapToBean(userRepository.addUser(mapper.mapToModel(user)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  tempUser;
    }
}
