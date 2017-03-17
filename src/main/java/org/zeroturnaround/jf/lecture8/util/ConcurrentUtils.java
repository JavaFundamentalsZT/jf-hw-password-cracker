package org.zeroturnaround.jf.lecture8.util;

import java.util.concurrent.TimeUnit;

public final class ConcurrentUtils {

  private ConcurrentUtils() {
    throw new RuntimeException("Should not create instances of this Util class");
  }

  public static void sleepSilently(int timeout, TimeUnit timeUnit) {
    try {
      timeUnit.sleep(timeout);
    }
    catch (InterruptedException ignore) {
    }
  }
}
