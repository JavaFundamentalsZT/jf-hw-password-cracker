package org.zeroturnaround.jf.lecture8;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * At first sight this looks threadsafe: there are no compound operations and both {@link #add(int)} and {@link #remove(int)} are synchronised.
 * Unfortunately {@link #addTenThings()} has an {@link Iterator} hidden away in the logging call.
 * If the collection is changed while the iteration is running, a {@link ConcurrentModificationException} may be thrown.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Slide16 {

  private static final Logger log = LoggerFactory.getLogger(Slide16.class);
  private final Set<Integer> set = new HashSet<>();


  public synchronized void add(int i) {
    set.add(i);
  }

  public synchronized void remove(int i) {
    set.remove(i);
  }

  public void addTenThings() {
    Random r = new Random();
    for (int i = 0; i < 10; i++) {
      add(r.nextInt());
    }

    log.info("Added: {}", set);
  }
}
