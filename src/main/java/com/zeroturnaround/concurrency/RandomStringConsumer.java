package com.zeroturnaround.concurrency;

/**
 * Consumer class, will keep reading in new random words, feeding them to the hashing algorithm,
 * and checking the result for collisions.
 * The method "run()" should never return, unless a proper shutdown is initiated.
 */
public class RandomStringConsumer implements Runnable {

  /**
   * This should contain the actual hash testing + result recording logic.
   */
  @Override
  public void run() {
    // TODO: Implement this!
  }

  /**
   * This should allow you to (thread-safely!) signal this consumer to halt its operations,
   * and thus return from the run() method.
   * Implementation is NOT mandatory if you supply an equally thread-safe alternative.
   */
  public void shutdown() {
    // TODO: Implement this, IF needed
  }
}
