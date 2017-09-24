package com.student.friendship.cache;

import java.util.concurrent.Future;

public interface FutureValueCache<K, V> {

    Future<V> get(K key);

    Future<V> update(K key);

}
