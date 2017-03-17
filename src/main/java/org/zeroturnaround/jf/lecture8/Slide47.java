package org.zeroturnaround.jf.lecture8;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Does the same thing as {@link Slide29}, but only allows the second thread to start when the first thread already filled in 10k elements.
 * To enforce waiting in the second thread, a {@link CountDownLatch} is used.
 */
@SuppressWarnings("InfiniteLoopStatement")
public class Slide47 {

  private static final Logger log = LoggerFactory.getLogger(Slide47.class);

  public static void main(String... args) {
    ConcurrentMap<Integer, Boolean> chm = new ConcurrentHashMap<>(100, 2);
    CountDownLatch latch = new CountDownLatch(1);

    Thread first = new Thread(() -> {
      for (int i = 0; i < 100_000; i++) {
        chm.put(i, true);

        if (i == 10_000) {
          latch.countDown();
        }
      }
    });

    Thread second = new Thread(() -> {
      try {
        latch.await();

        while (true) {
          int size = chm.size();
          int count = 0;

          for (int ignore : chm.keySet()) {
            count++;
          }

          log.info("size: {}, count: {}", size, count);
        }
      }
      catch (InterruptedException ignore) {
      }
    });

    first.start();
    second.setDaemon(true);
    second.start();
  }
}
