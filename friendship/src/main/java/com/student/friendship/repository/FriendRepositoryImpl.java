package com.student.friendship.repository;

import com.student.friendship.pojo.Friend;
import com.student.friendship.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;

@Repository
public class FriendRepositoryImpl implements FriendRepository {

    private final ConcurrentMap<User, Set<Friend>> friendMap;

    public FriendRepositoryImpl() {
        friendMap = new ConcurrentHashMap<>();
    }

    @Override
    public void addFriend(Friend friend) {
        friendMap.putIfAbsent(friend.getUserOne(), new ConcurrentSkipListSet<>());
        friendMap.putIfAbsent(friend.getUserTwo(), new ConcurrentSkipListSet<>());
        friendMap.get(friend.getUserOne()).add(friend);
        friendMap.get(friend.getUserTwo()).add(friend);
    }

    @Override
    public void removeFriend(Friend friend) {
        Set<Friend> userOneFriendSet = friendMap.get(friend.getUserOne());
        if (userOneFriendSet != null) {
            userOneFriendSet.remove(friend);
        }
        Set<Friend> userTwoFriendSet = friendMap.get(friend.getUserTwo());
        if (userTwoFriendSet != null) {
            userTwoFriendSet.remove(friend);
        }
    }

    @Override
    public List<Friend> getFriendList(User user) {
        return new ArrayList<>(friendMap.get(user));
    }

}
