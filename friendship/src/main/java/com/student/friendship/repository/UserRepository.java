package com.student.friendship.repository;

import com.student.friendship.pojo.User;

public interface UserRepository {

    void addUser(User user);

    void updateUser(User user);

    User getUser(String username);

}
