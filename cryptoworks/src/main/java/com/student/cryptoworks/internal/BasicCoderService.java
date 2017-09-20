package com.student.cryptoworks.internal;

public class BasicCoderService implements CoderService {

    @Override
    public String encode(String message) {
        //does some basic encode
        return message;
    }

    @Override
    public String decode(String message) {
        //does some basic decode
        return message;
    }

    @Override
    public int encode(int message) {
        //does some basic encode
        return message + 5;
    }

    @Override
    public int decode(int message) {
        //does some basic decode
        return message - 5;
    }

}
