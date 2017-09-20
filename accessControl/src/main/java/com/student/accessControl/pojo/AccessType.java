package com.student.accessControl.pojo;

public enum AccessType {

    NONE(false, false, false),
    READ_ONLY(true, false, false),
    READ_AND_WRITE_ONLY(true, true, false),
    READ_WRITE_DELETE(true, true, true);

    private final boolean readAccess;
    private final boolean writeAccess;
    private final boolean deleteAccess;

    AccessType(boolean readAccess, boolean writeAccess, boolean deleteAccess) {
        this.readAccess = readAccess;
        this.writeAccess = writeAccess;
        this.deleteAccess = deleteAccess;
    }

    public boolean isReadAccess() {
        return readAccess;
    }

    public boolean isWriteAccess() {
        return writeAccess;
    }

    public boolean isDeleteAccess() {
        return deleteAccess;
    }

}
