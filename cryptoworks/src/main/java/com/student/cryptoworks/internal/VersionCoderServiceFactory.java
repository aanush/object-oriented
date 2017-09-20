package com.student.cryptoworks.internal;

import com.student.cryptoworks.external.ModernCrypterService;
import org.springframework.stereotype.Component;

@Component
public class VersionCoderServiceFactory implements CoderServiceFactory {

    @Override
    public CoderService createCoder(VersionType versionType) {
        return new LoggingCoderService(createCoderByVersion(versionType));
    }

    public CoderService createCoderByVersion(VersionType versionType) {
        if (VersionType.ADVANCED == versionType) {
            return new AdvancedCoderService(new BasicCoderService());
        }
        if (VersionType.MODERN == versionType) {
            return new AdvancedCoderService(new AdapterCoderService(new ModernCrypterService()));// ModernCrypterService is external (third party) one
        }
        return new BasicCoderService();
    }

}
