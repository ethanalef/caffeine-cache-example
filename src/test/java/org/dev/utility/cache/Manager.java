package org.dev.utility.cache;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class Manager {
  public final CacheHelper cacheHelper;
  public Set<Worker> workers;
  public ScheduledExecutorService scheduler;

  @PostConstruct
  public void init() {
    workers = new HashSet<>();
    Worker w1 = new Worker(cacheHelper);
    Worker w2 = new Worker(cacheHelper);
    Worker w3 = new Worker(cacheHelper);
    workers.add(w1);
    workers.add(w2);
    workers.add(w3);
    scheduler = Executors.newScheduledThreadPool(workers.size());
  }

  public void startSchedulers() {
    for (Worker worker : workers) {
      scheduler.scheduleAtFixedRate(worker::work, 0, 5000L, TimeUnit.MILLISECONDS);
    }
  }
}
