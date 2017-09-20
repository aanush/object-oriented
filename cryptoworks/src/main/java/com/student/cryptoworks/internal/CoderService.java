package com.student.cryptoworks.internal;

public interface CoderService {

    String encode(String message);

    String decode(String message);

    int encode(int message);

    int decode(int message);

}
