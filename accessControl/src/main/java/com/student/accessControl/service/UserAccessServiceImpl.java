package com.student.accessControl.service;

import com.student.accessControl.cache.AccessCache;
import com.student.accessControl.pojo.AccessType;
import com.student.accessControl.pojo.Resource;
import com.student.accessControl.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserAccessServiceImpl implements UserAccessService {

    @Override
    public AccessType getUserAccessForResource(User user, Resource resource) {
        AccessType accessType = AccessCache.getInstance().getUserAccessForResource(user, resource);
        if (accessType == null) {
            accessType = AccessType.NONE;
        }
        return accessType;
    }

}
