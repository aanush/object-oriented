package com.student.friendship.repository;

import com.student.friendship.pojo.Friend;
import com.student.friendship.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class FriendRepositoryImpl implements FriendRepository {

    private final ConcurrentMap<User, ConcurrentMap<Friend, Friend>> friendMap;

    public FriendRepositoryImpl() {
        friendMap = new ConcurrentHashMap<>();
    }

    @Override
    public void addFriend(Friend friend) {
        friendMap.putIfAbsent(friend.getUserOne(), new ConcurrentHashMap<>());
        friendMap.putIfAbsent(friend.getUserTwo(), new ConcurrentHashMap<>());
        friendMap.get(friend.getUserOne()).putIfAbsent(friend, friend);
        friendMap.get(friend.getUserTwo()).putIfAbsent(friend, friend);
    }

    @Override
    public void removeFriend(Friend friend) {
        Set<Friend> userOneFriendSet = friendMap.get(friend.getUserOne()).keySet();
        if (userOneFriendSet != null) {
            userOneFriendSet.remove(friend);
        }
        Set<Friend> userTwoFriendSet = friendMap.get(friend.getUserTwo()).keySet();
        if (userTwoFriendSet != null) {
            userTwoFriendSet.remove(friend);
        }
    }

    @Override
    public List<Friend> getFriendList(User user) {
        return new ArrayList<>(friendMap.get(user).keySet());
    }

}
