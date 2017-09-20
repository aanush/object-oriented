package com.student.cryptoworks.internal;

public class AdvancedCoderService implements CoderService {

    private final CoderService coderService;

    public AdvancedCoderService(CoderService coderService) {
        this.coderService = coderService;
    }

    @Override
    public String encode(String message) {
        //does some advanced encode
        return coderService.encode(message);
    }

    @Override
    public String decode(String message) {
        //does some advanced decode
        return coderService.decode(message);
    }

    @Override
    public int encode(int message) {
        //does some advanced encode
        return (int) 2 * coderService.encode(message);
    }

    @Override
    public int decode(int message) {
        //does some advanced decode
        return (int) coderService.decode(message / 2);
    }

}
