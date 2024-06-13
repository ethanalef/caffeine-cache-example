package org.dev.utility.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CacheHelper {
  private AtomicInteger atomicInteger = new AtomicInteger(0);

  @Cacheable(cacheNames = "cached-key-in-300-seconds", cacheManager = "L1CacheManager")
  public BigInteger getCachedValue() {
    System.out.println("cache miss");
    return BigInteger.valueOf(atomicInteger.getAndIncrement());
  }
}
