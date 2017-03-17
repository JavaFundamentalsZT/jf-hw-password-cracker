package org.zeroturnaround.jf.lecture8;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeroturnaround.jf.lecture8.util.ConcurrentUtils;

/**
 * Interleaving of {@link #getLast(Vector)} and {@link #deleteLast(Vector)} operations is now not possible anymore,
 * as both lock down on the collection (client-side locking).
 */
@SuppressWarnings({"SynchronizationOnLocalVariableOrMethodParameter", "Duplicates"})
public class Slide12 {

  private static final Logger log = LoggerFactory.getLogger(Slide12.class);

  private static <T> T getLast(Vector<T> list) {
    synchronized (list) {
      int lastIndex = list.size() - 1;
      return list.get(lastIndex);
    }
  }

  private static int deleteLast(Vector list) {
    synchronized (list) {
      int lastIndex = list.size() - 1;
      list.remove(lastIndex);
      return lastIndex;
    }
  }

  public static void main(String... args) {
    final Vector<Integer> vector = prepare();

    Thread first = new Thread(() -> {
      while (!vector.isEmpty()) {
        log.info("Get Last: {}", getLast(vector));
        ConcurrentUtils.sleepSilently(10, TimeUnit.MILLISECONDS);
      }
    });

    Thread second = new Thread(() -> {
      while (!vector.isEmpty()) {
        log.info("Delete Last: {}", deleteLast(vector));
        ConcurrentUtils.sleepSilently(10, TimeUnit.MILLISECONDS);
      }
    });

    first.start();
    second.start();
  }

  private static Vector<Integer> prepare() {
    Vector<Integer> vector = new Vector<>();
    for (int i = 0; i < 50; i++) {
      vector.add(i);
    }
    return vector;
  }
}
