package com.student.friendship.cache;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public final class FutureValueCacheFactoryImpl<K, V> implements FutureValueCacheFactory<K, V> {

    @Override
    public FutureValueCache<K, V> createFutureValueCache(int cacheSize, Function<K, V> cacheFunction) {
        return new SynchronizedFutureValueCache<>(cacheSize, cacheFunction);
    }

}
