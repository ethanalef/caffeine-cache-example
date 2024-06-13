package org.dev.utility.cache;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = UtilityCacheApplication.class)
public class CacheTest {
  @Autowired
  Manager manager;

  @Test
  public void threadedTest() throws InterruptedException {
    System.out.println("Start manager");
    manager.startSchedulers();
    Thread.sleep(60000L);
  }
}