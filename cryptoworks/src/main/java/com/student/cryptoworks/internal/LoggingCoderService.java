package com.student.cryptoworks.internal;

public class LoggingCoderService implements CoderService {

    private final CoderService coderService;

    public LoggingCoderService(CoderService coderService) {
        this.coderService = coderService;
    }

    @Override
    public String encode(String message) {
        //does some logging
        String code = null;
        System.out.println("encode start");
        code = coderService.encode(message);
        System.out.println("encode end");
        return code;
    }

    @Override
    public String decode(String message) {
        //does some logging
        String code = null;
        System.out.println("decode start");
        code = coderService.decode(message);
        System.out.println("decode end");
        return code;
    }

    @Override
    public int encode(int message) {
        //does some logging
        int code = 0;
        System.out.println("encode start");
        code = coderService.encode(message);
        System.out.println("encode end");
        return code;
    }

    @Override
    public int decode(int message) {
        //does some logging
        int code = 0;
        System.out.println("decode start");
        code = coderService.decode(message);
        System.out.println("decode end");
        return code;
    }

}
