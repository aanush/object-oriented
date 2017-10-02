package com.student.friendship.service;

import com.student.friendship.pojo.Friend;
import com.student.friendship.pojo.User;
import com.student.friendship.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private final FriendRepository friendRepository;

    public FriendServiceImpl(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @Override
    public void addFriend(Friend friend) {
        friendRepository.addFriend(friend);
    }

    @Override
    public void removeFriend(Friend friend) {
        friendRepository.removeFriend(friend);
    }

    @Override
    public List<Friend> getFriendList(User user) {
        return friendRepository.getFriendList(user);
    }

    @Override
    public List<User> getFriendUserList(User user) {
        return friendRepository.getFriendList(user).stream()
                .map(friend -> !user.equals(friend.getUserOne()) ? friend.getUserOne() : friend.getUserTwo())
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getMutualFriendUserList(User userOne, User userTwo) {
        List<User> userListOne = getFriendUserList(userOne);
        List<User> userListTwo = getFriendUserList(userTwo);
        List<User> userListAll = new ArrayList<>(userListOne.size() + userListTwo.size());
        userListAll.addAll(userListOne);
        userListAll.addAll(userListTwo);
        userListAll.sort(Comparator.comparing(user -> user.getUsername()));
        List<User> mutualFriendUserList = new ArrayList<>();
        int i = 0;
        while (i <= userListAll.size() - 2) {
            if (userListAll.get(i).equals(userListAll.get(i + 1))) {
                mutualFriendUserList.add(userListAll.get(i));
                i = i + 2;
            } else {
                i = i + 1;
            }
        }
        return mutualFriendUserList;
    }

}
