package com.student.cryptoworks.internal;

public interface CoderServiceFactory {

    CoderService createCoder(VersionType version);

}
