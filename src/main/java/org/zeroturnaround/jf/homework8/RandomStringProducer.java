package org.zeroturnaround.jf.homework8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Producer class, will keep generating new random words to serve as the input for the hashing algorithm.
 * The method {@link #run()} should never return, until a proper shutdown is initiated.
 */
@SuppressWarnings("unused")
public class RandomStringProducer implements Runnable {

  private static final Logger log = LoggerFactory.getLogger(RandomStringProducer.class);

  /**
   * This should contain the actual String generation logic.
   */
  @Override
  public void run() {
    // TODO: Implement this!
  }
}
