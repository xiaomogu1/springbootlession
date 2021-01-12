package com.staxrt.tutorial.dao;

import com.staxrt.tutorial.model.User;
import com.staxrt.tutorial.model.UserFromUrl;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserFromUrl mapFromUrl(User remoteUser) {
        UserFromUrl user = new UserFromUrl();
        user.setId(remoteUser.getId());
        user.setEmail(remoteUser.getEmail());
        user.setCreatedAt(remoteUser.getCreatedAt());
        user.setFirstName(remoteUser.getFirstName());
        user.setLastName(remoteUser.getLastName());
        user.setCreatedBy(remoteUser.getCreatedBy());
        user.setUpdatedAt(remoteUser.getUpdatedAt());
        user.setUpdatedBy(remoteUser.getUpdatedBy());
        user.setUrl(null);

        return user;
    }
}
