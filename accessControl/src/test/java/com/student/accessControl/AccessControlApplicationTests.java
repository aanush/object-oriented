package com.student.accessControl;

import com.student.accessControl.pojo.AccessType;
import com.student.accessControl.pojo.Resource;
import com.student.accessControl.pojo.Role;
import com.student.accessControl.pojo.User;
import com.student.accessControl.service.UserAccessService;
import com.student.accessControl.service.UserRoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccessControlApplicationTests {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserAccessService userAccessService;

    @Test
    public void testUpdateAndGet() {
        Runnable runnableA = () -> test(new User("user"), new Resource("A"), AccessType.READ_ONLY);
        Runnable runnableB = () -> test(new User("user"), new Resource("B"), AccessType.READ_AND_WRITE_ONLY);
        Runnable runnableC = () -> test(new User("user"), new Resource("C"), AccessType.READ_WRITE_DELETE);
        Runnable runnableD = () -> test(new User("user"), new Resource("D"), AccessType.NONE);
        new Thread(runnableA).start();
        new Thread(runnableB).start();
        new Thread(runnableC).start();
        new Thread(runnableD).start();
    }

    private void test(User user, Resource resource, AccessType expectedAccessType) {
        sleepForSecond();
        userRoleService.updateRoleForUser(new Role(resource, expectedAccessType), user);
        sleepForSecond();
        AccessType actualAccessType = userAccessService.getUserAccessForResource(user, resource);
        sleepForSecond();
        Assert.assertEquals(expectedAccessType, actualAccessType);
    }

    private void sleepForSecond() {
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
