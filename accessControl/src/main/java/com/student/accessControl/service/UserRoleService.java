package com.student.accessControl.service;

import com.student.accessControl.pojo.Role;
import com.student.accessControl.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserRoleService {

    void updateRoleForUser(Role role, User user);

}
