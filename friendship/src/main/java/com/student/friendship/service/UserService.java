package com.student.friendship.service;

import com.student.friendship.pojo.User;

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    User getUser(String username);

}
