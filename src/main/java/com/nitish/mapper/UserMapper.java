package com.nitish.mapper;

import com.nitish.bean.User;
import com.nitish.domain.UserDomain;
import org.springframework.stereotype.Component;

/**
 * Created by nsm1211 on 11-09-2015.
 */
@Component
public class UserMapper implements BasicMapper<User, UserDomain> {

    @Override
    public UserDomain mapToModel(User bean) {
        User userBean = bean;
        return new UserDomain().builder()
                .userId(userBean.getUserId())
                .name(userBean.getName())
                .emailId(userBean.getEmailId())
                .build();
    }

    @Override
    public User mapToBean( UserDomain model) {
        UserDomain userModel = model;
        return new User().builder()
                .userId(userModel.getUserId())
                .name(userModel.getName())
                .emailId(userModel.getEmailId()).build();
    }
}
