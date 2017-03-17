package org.zeroturnaround.jf;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeroturnaround.jf.homework8.CollisionFinder;

/**
 * Main entry point for the application.
 */
public class Main {

  private static final Logger log = LoggerFactory.getLogger(Main.class);

  public static void main(String... args) {
    List<String> collisions = new CollisionFinder().findCollidingPasswords();
    log.info("Completed with results: {}", collisions);
  }
}
