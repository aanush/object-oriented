package com.student.friendship.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
public final class UserFactoryImpl implements UserFactory {

    @Override
    public User createUser(String username, int id) {
        return new UserImpl(username, id);
    }

    private final class UserImpl implements User, Serializable {

        private static final long serialVersionUID = -1L;

        private final String username;
        private final int id;

        private UserImpl(String username, int id) {
            if (username == null || username.isEmpty() || id < 0) {
                throw new IllegalArgumentException();
            }
            this.username = username;
            this.id = id;
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public int getId() {
            return id;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            UserImpl that = (UserImpl) object;
            return getId() == that.getId() && Objects.equals(getUsername(), that.getUsername());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getUsername(), getId());
        }

    }

}
