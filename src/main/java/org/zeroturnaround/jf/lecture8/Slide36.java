package org.zeroturnaround.jf.lecture8;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates the life of a {@link Thread}, how to interrupt it, and how its state changes.
 */
public class Slide36 implements Runnable {

  private static final Logger log = LoggerFactory.getLogger(Slide36.class);

  public static void main(String args[]) {
    Thread thread = new Thread(new Slide36());
    thread.setName("spawned");
    log.info("\"spawned\" is going to start...");
    thread.start();

    try {
      TimeUnit.MILLISECONDS.sleep(200);

      log.info("interrupting spawned...");
      thread.interrupt();

      TimeUnit.MILLISECONDS.sleep(10);

      log.info("is \"spawned\" interrupted? " + thread.isInterrupted() + ", alive? " + thread.isAlive());
      log.info("joining \"spawned\"");
      thread.join();
      log.info("join completed");
      log.info("is \"spawned\" interrupted? " + thread.isInterrupted() + ", alive? " + thread.isAlive());
    }
    catch (InterruptedException ignore) {
    }
  }

  public void run() {
    try {
      log.info("started!");
      TimeUnit.DAYS.sleep(Long.MAX_VALUE); // Sleep for a very long time
    }
    catch (InterruptedException ignore) {
      Thread.currentThread().interrupt();
      log.info("interrupted!");
    }

    // Active wait, cannot use Thread.sleep(), as interrupted status is still true!
    // Do not use this in real life.
    int count = 100_000_000;
    for (int i = 0; i <= count; i++) {
      if (i == count / 2) {
        log.info("still alive!");
      }
    }
    
    log.info("finished");
  }
}
