package com.student.friendship.service;

import com.student.friendship.cache.FutureValueCache;
import com.student.friendship.cache.FutureValueCacheFactory;
import com.student.friendship.pojo.User;
import com.student.friendship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserServiceImpl implements UserService {

    public static final int cacheSize = 10;

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final FutureValueCacheFactory<String, User> userCacheFactory;
    private final FutureValueCache<String, User> userCache;

    public UserServiceImpl(UserRepository userRepository, FutureValueCacheFactory<String, User> userCacheFactory) {
        this.userRepository = userRepository;
        this.userCacheFactory = userCacheFactory;
        this.userCache = userCacheFactory.createFutureValueCache(cacheSize, username -> userRepository.getUser(username));
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
        userCache.update(user.getUsername());
    }

    @Override
    public User getUser(String username) {
        try {
            return userCache.get(username).get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e.getCause());
        }
    }

}
