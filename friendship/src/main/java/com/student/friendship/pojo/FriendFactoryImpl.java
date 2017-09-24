package com.student.friendship.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

@Component
public final class FriendFactoryImpl implements FriendFactory {

    @Override
    public Friend createFriend(User userOne, User userTwo) {
        return new FriendImpl(userOne, userTwo);
    }

    private final class FriendImpl implements Friend, Serializable {

        private static final long serialVersionUID = -1L;

        private final User userOne;
        private final User userTwo;

        private FriendImpl(User userOne, User userTwo) {
            if (userOne == null || userTwo == null) {
                throw new IllegalArgumentException();
            }
            User[] arrUser = new User[]{userOne, userTwo};
            Arrays.sort(arrUser, Comparator.comparing(User::getUsername));
            this.userOne = arrUser[0];
            this.userTwo = arrUser[1];
        }

        @Override
        public User getUserOne() {
            return userOne;
        }

        @Override
        public User getUserTwo() {
            return userTwo;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            FriendImpl that = (FriendImpl) object;
            return Objects.equals(getUserOne(), that.getUserOne()) && Objects.equals(getUserTwo(), that.getUserTwo());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getUserOne(), getUserTwo());
        }

    }

}
