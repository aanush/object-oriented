package com.student.cryptoworks;

import com.student.cryptoworks.internal.CoderServiceFactory;
import com.student.cryptoworks.internal.VersionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CryptoworksController {

    @Autowired
    private final CoderServiceFactory coderServiceFactory;

    public CryptoworksController(CoderServiceFactory coderServiceFactory) {
        this.coderServiceFactory = coderServiceFactory;
    }

    @RequestMapping(path = "/encode/string/{message}/{version}", method = RequestMethod.GET)
    public String encodeString(@PathVariable("message") String message, @PathVariable("version") VersionType version) {
        return coderServiceFactory.createCoder(version).encode(message);
    }

    @RequestMapping(path = "/decode/string/{message}/{version}", method = RequestMethod.GET)
    public String decodeString(@PathVariable("message") String message, @PathVariable("version") VersionType version) {
        return coderServiceFactory.createCoder(version).decode(message);
    }

    @RequestMapping(path = "/encode/integer/{message}/{version}", method = RequestMethod.GET)
    public Integer encodeInteger(@PathVariable("message") Integer message, @PathVariable("version") VersionType version) {
        return coderServiceFactory.createCoder(version).encode(message);
    }

    @RequestMapping(path = "/decode/integer/{message}/{version}", method = RequestMethod.GET)
    public Integer decodeInteger(@PathVariable("message") Integer message, @PathVariable("version") VersionType version) {
        return coderServiceFactory.createCoder(version).decode(message);
    }

}
