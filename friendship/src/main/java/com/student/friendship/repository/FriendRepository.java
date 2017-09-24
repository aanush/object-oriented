package com.student.friendship.repository;

import com.student.friendship.pojo.Friend;
import com.student.friendship.pojo.User;

import java.util.List;

public interface FriendRepository {

    void addFriend(Friend friend);

    void removeFriend(Friend friend);

    List<Friend> getFriendList(User user);

}
