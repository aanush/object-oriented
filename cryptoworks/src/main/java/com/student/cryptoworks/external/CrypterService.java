package com.student.cryptoworks.external;

public interface CrypterService {

    String encrypt(String message);

    String decrypt(String message);

    int encrypt(int message);

    int decrypt(int message);

}
