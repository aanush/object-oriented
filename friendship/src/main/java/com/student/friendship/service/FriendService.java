package com.student.friendship.service;

import com.student.friendship.pojo.Friend;
import com.student.friendship.pojo.User;

import java.util.List;

public interface FriendService {

    void addFriend(Friend friend);

    void removeFriend(Friend friend);

    List<Friend> getFriendList(User user);

    List<User> getFriendUserList(User user);

    List<User> getMutualFriendUserList(User userOne, User userTwo);

}
