package com.student.friendship.service;

import com.student.friendship.pojo.Friend;
import com.student.friendship.pojo.User;
import com.student.friendship.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
