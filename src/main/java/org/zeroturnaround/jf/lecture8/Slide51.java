package org.zeroturnaround.jf.lecture8;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

@SuppressWarnings("unused")
public class Slide51<T> {

  private final Set<T> set;
  private final Semaphore semaphore;

  public Slide51(int bound) {
    set = Collections.synchronizedSet(new HashSet<T>());
    semaphore = new Semaphore(bound);
  }

  public boolean add(T o) throws InterruptedException {
    semaphore.acquire();
    boolean wasAdded = false;
    try {
      return wasAdded = set.add(o);
    }
    finally {
      if (!wasAdded) {
        semaphore.release();
      }
    }
  }

  public boolean remove(T o) {
    boolean wasRemoved;
    if (wasRemoved = set.remove(o)) {
      semaphore.release();
    }
    return wasRemoved;
  }
}
