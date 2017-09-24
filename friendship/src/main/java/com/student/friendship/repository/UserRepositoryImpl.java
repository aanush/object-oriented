package com.student.friendship.repository;

import com.student.friendship.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepositoryImpl implements UserRepository {

    public static final AtomicInteger getUserInvokeCount = new AtomicInteger(0);

    private final ConcurrentMap<String, User> userMap;

    public UserRepositoryImpl() {
        this.userMap = new ConcurrentHashMap<>();
    }

    @Override
    public void addUser(User user) {
        userMap.putIfAbsent(user.getUsername(), user);
    }

    @Override
    public void updateUser(User user) {
        userMap.put(user.getUsername(), user);
    }

    @Override
    public User getUser(String username) {
        try {
            Thread.sleep(10000);
            System.out.println("get " + username + " from repository");
            getUserInvokeCount.incrementAndGet();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e.getCause());
        }
        return userMap.get(username);
    }

}
