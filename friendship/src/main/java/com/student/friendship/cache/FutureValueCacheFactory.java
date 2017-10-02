package com.student.friendship.cache;

import java.util.function.Function;

public interface FutureValueCacheFactory<K, V> {

    FutureValueCache<K, V> createSynchronizedFutureValueCache(int cacheSize, Function<K, V> cacheFunction);

}
