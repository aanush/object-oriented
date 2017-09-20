package com.student.cryptoworks.external;

public class ModernCrypterService implements CrypterService {

    @Override
    public String encrypt(String message) {
        // does modern encrypt
        return message;
    }

    @Override
    public String decrypt(String message) {
        // does modern decrypt
        return message;
    }

    @Override
    public int encrypt(int message) {
        // does modern encrypt
        return (int) Math.sin(message);
    }

    @Override
    public int decrypt(int message) {
        // does modern decrypt
        return (int) Math.asin(message);
    }

}
