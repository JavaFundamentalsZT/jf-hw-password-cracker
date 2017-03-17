package org.zeroturnaround.jf.lecture8;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeroturnaround.jf.lecture8.util.ConcurrentUtils;

/**
 * Demonstrates the usage of a {@link FutureTask}, how to start a unit of work asynchronously in the background, and later retrieve its result.
 */
public class Slide48 {

  private static final Logger log = LoggerFactory.getLogger(Slide48.class);

  public static void main(String... args) throws InterruptedException {
    Preloader preloader = new Preloader();
    preloader.start();

    // Simulate doing some other stuff
    log.info("Going to sleep");
    ConcurrentUtils.sleepSilently(20, TimeUnit.MILLISECONDS);
    log.info("Waking and ready to get Future");

    // Now that other stuff is gone it is time to check if our background calculation finished
    int fib = preloader.get();

    log.info("Fibonacci 30th number: " + fib);
  }

  // Costly operation
  private static int calculateNthFibonacciNumber(int n) {
    if (n < 1) {
      return 0;
    }
    else if (n == 1) {
      return 1;
    }

    return calculateNthFibonacciNumber(n - 2) + calculateNthFibonacciNumber(n - 1);
  }

  /**
   * Asynchronous pre-loading using a {@link FutureTask}.
   */
  private static class Preloader {

    private final FutureTask<Integer> future;
    private final Thread thread;

    private Preloader() {
      future = new FutureTask<>(() -> {
        log.info("Future task started");
        int result = calculateNthFibonacciNumber(30);
        log.info("Future task finished");
        return result;
      });

      thread = new Thread(future);
      thread.setName("preloader");
    }

    private void start() {
      thread.start();
    }

    private int get() throws InterruptedException {
      try {
        return future.get();
      }
      catch (ExecutionException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
