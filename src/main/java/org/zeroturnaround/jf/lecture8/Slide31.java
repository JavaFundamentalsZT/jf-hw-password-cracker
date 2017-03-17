package org.zeroturnaround.jf.lecture8;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Different ways of Thread-safely incrementing an integer number.
 */
@SuppressWarnings("unused")
public class Slide31 {

  private int i = 0;
  private AtomicInteger ai = new AtomicInteger(0);

  /**
   * Simplest code, but if two threads arrive at the same time, one will go to sleep, which involves a very costly context switch + time lost sleeping.
   */
  public synchronized void incrementSynchronised() {
    i++;
  }

  /**
   * A bit more complex code, which will keep an (active) spin lock, meaning the calling thread remains active / keeps using CPU.
   * Intuition would say these are wasted processor cycles, but real life shows that even under contention the while loop never runs more than a handful of times.
   * The end-result is that the Thread almost always completes his job without delays, and does not need to sleep and context switch.
   * <p>
   * N.B. Internally {@link AtomicInteger#incrementAndGet()} uses similar code, which translates to a single opcode on supported CPUs.
   */
  public void incrementSpinLock() {
    int oldVal;
    do {
      oldVal = ai.get();
    }
    while (!ai.compareAndSet(oldVal, oldVal + 1));
  }
}
