package com.student.accessControl.service;

import com.student.accessControl.cache.AccessCache;
import com.student.accessControl.pojo.Role;
import com.student.accessControl.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Override
    public void updateRoleForUser(Role role, User user) {
        if (role == null || user == null) {
            throw new IllegalArgumentException();
        }
        AccessCache.getInstance().updateUserToAccessTheResource(user, role.getAccessType(), role.getResource());
    }

}
