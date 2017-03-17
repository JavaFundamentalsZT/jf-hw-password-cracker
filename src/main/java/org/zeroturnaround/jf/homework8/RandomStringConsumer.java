package org.zeroturnaround.jf.homework8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Consumer class, will keep reading in new random words, feeding them to the hashing algorithm,
 * and checking the result for collisions with any of the given hashes.
 * The method {@link #run()} should never return, until a proper shutdown is initiated.
 */
@SuppressWarnings("unused")
public class RandomStringConsumer implements Runnable {

  private static final Logger log = LoggerFactory.getLogger(RandomStringConsumer.class);

  /**
   * This should contain the actual hash testing + result recording logic.
   */
  @Override
  public void run() {
    // TODO: Implement this!
  }
}
