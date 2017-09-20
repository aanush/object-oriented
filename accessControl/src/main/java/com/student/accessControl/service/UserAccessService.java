package com.student.accessControl.service;

import com.student.accessControl.pojo.AccessType;
import com.student.accessControl.pojo.Resource;
import com.student.accessControl.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserAccessService {

    AccessType getUserAccessForResource(User user, Resource resource);

}
