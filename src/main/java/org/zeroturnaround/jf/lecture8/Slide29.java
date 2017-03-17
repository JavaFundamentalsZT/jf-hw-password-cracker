package org.zeroturnaround.jf.lecture8;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Iteration is safe to perform on a changing collection.
 * The possible difference in "size" and "count" demonstrates how changes may be visible to the current {@link Iterator}.
 */
@SuppressWarnings("InfiniteLoopStatement")
public class Slide29 {

  private static final Logger log = LoggerFactory.getLogger(Slide29.class);

  public static void main(String... args) {
    ConcurrentMap<Integer, Boolean> chm = new ConcurrentHashMap<>(100, 2);

    Thread first = new Thread(() -> {
      for (int i = 0; i < 1_000_000; i++) {
        chm.put(i, true);
      }
    });

    Thread second = new Thread(() -> {
      while (true) {
        Iterator<Integer> it = chm.keySet().iterator();

        int size = chm.size();
        int count = 0;

        while (it.hasNext()) {
          it.next();
          count++;
        }

        log.info("size: {}, count: {}", size, count);
      }
    });

    first.start();
    second.setDaemon(true);
    second.start();
  }
}
