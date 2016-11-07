package com.zeroturnaround.concurrency;

/**
 * Producer class, will keep generating new random words to serve as the input for the hashing algorithm.
 * The method "run()" should never return, unless a proper shutdown is initiated.
 */
public class RandomStringProducer implements Runnable {

  /**
   * This should contain the actual String generation logic.
   */
  @Override
  public void run() {
    // TODO: Implement this!
  }

  /**
   * This should allow you to (thread-safely!) signal this producer to halt its operations,
   * and thus return from the run() method.
   * Implementation is NOT mandatory if you supply an equally thread-safe alternative.
   */
  public void shutdown() {
    // TODO: Implement this, IF needed
  }
}
