package com.student.accessControl.cache;

import com.student.accessControl.pojo.AccessType;
import com.student.accessControl.pojo.Resource;
import com.student.accessControl.pojo.User;

import java.util.concurrent.ConcurrentHashMap;

//@Singleton
public final class AccessCache {

    private final ConcurrentHashMap<User, ConcurrentHashMap<Resource, AccessType>> userResourceAccessMap;

    private AccessCache() {
        this.userResourceAccessMap = new ConcurrentHashMap<>();
    }

    public static final AccessCache getInstance() {
        return AccessCacheHolder.accessCache;
    }

    public void updateUserToAccessTheResource(User user, AccessType accessType, Resource resource) {
        if (user == null || accessType == null || resource == null) {
            throw new IllegalArgumentException();
        }
        userResourceAccessMap.putIfAbsent(user, new ConcurrentHashMap<>());
        ConcurrentHashMap<Resource, AccessType> resourceAccessMap = userResourceAccessMap.get(user);
        resourceAccessMap.put(resource, accessType);
    }

    public AccessType getUserAccessForResource(User user, Resource resource) {
        if (user == null || resource == null) {
            throw new IllegalArgumentException();
        }
        userResourceAccessMap.putIfAbsent(user, new ConcurrentHashMap<>());
        ConcurrentHashMap<Resource, AccessType> resourceAccessMap = userResourceAccessMap.get(user);
        return resourceAccessMap.get(resource);
    }

    private static final class AccessCacheHolder {
        private static final AccessCache accessCache = new AccessCache();
    }

}
