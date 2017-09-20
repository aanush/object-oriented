package com.student.cryptoworks.internal;


import com.student.cryptoworks.external.CrypterService;

public class AdapterCoderService implements CoderService {

    private final CrypterService crypterService;

    public AdapterCoderService(CrypterService crypterService) {
        this.crypterService = crypterService;
    }

    @Override
    public String encode(String message) {
        return crypterService.encrypt(message);
    }

    @Override
    public String decode(String message) {
        return crypterService.decrypt(message);
    }

    @Override
    public int encode(int message) {
        return crypterService.encrypt(message);
    }

    @Override
    public int decode(int message) {
        return crypterService.decrypt(message);
    }

}
