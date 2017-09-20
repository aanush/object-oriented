package com.student.accessControl.pojo;

import java.util.Objects;

public final class Role {

    private final Resource resource;
    private final AccessType accessType;

    public Role(Resource resource, AccessType accessType) {
        if (resource == null || accessType == null) {
            throw new IllegalArgumentException();
        }
        this.resource = resource;
        this.accessType = accessType;
    }

    public Resource getResource() {
        return resource;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Role that = (Role) object;
        return Objects.equals(getResource(), that.getResource()) &&
                getAccessType() == that.getAccessType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResource(), getAccessType());
    }

}
