package com.student.friendship;

import com.student.friendship.pojo.User;
import com.student.friendship.pojo.UserFactory;
import com.student.friendship.repository.UserRepositoryImpl;
import com.student.friendship.service.UserService;
import com.student.friendship.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FriendshipApplicationTests {

    @Autowired
    private UserFactory userFactory;

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testUserService() throws ExecutionException, InterruptedException {

        User[] arrUser = new User[UserServiceImpl.cacheSize];
        Future<User>[] arrFutureUser1 = new Future[UserServiceImpl.cacheSize];
        Future<User>[] arrFutureUser2 = new Future[UserServiceImpl.cacheSize];
        Future<User>[] arrFutureUser3 = new Future[UserServiceImpl.cacheSize];
        Future<User>[] arrFutureUser4 = new Future[UserServiceImpl.cacheSize];

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i <= arrUser.length - 1; i++) {
            arrUser[i] = userFactory.createUser("user" + i, i);
            userService.addUser(arrUser[i]);
        }

        for (int i = 0; i <= arrUser.length - 1; i++) {
            final int k = i;
            arrFutureUser1[i] = executorService.submit(() -> userService.getUser(arrUser[k].getUsername()));
            arrFutureUser2[i] = executorService.submit(() -> userService.getUser(arrUser[k].getUsername()));
            arrFutureUser3[i] = executorService.submit(() -> userService.getUser(arrUser[k].getUsername()));
            arrFutureUser4[i] = executorService.submit(() -> userService.getUser(arrUser[k].getUsername()));
        }

        for (int i = 0; i <= arrUser.length - 1; i++) {
            Assert.assertEquals(arrUser[i], arrFutureUser1[i].get());
            Assert.assertEquals(arrUser[i], arrFutureUser2[i].get());
            Assert.assertEquals(arrUser[i], arrFutureUser3[i].get());
            Assert.assertEquals(arrUser[i], arrFutureUser4[i].get());
        }

        Assert.assertEquals(UserServiceImpl.cacheSize, UserRepositoryImpl.getUserInvokeCount.get());

    }

}
