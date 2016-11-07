package com.zeroturnaround.concurrency;

import java.util.Collections;
import java.util.List;

/**
 * Sets up the required number of producer and consumer threads,
 * coordinates their information exchange,
 * keeps track of the discovered collisions (and only stores the FIRST one found!),
 * and takes care of a clean shutdown, once all passwords have a found collision.
 */
public class CollisionFinder {

  /**
   * Read the data provided by the "Salt" and "Hash" classes, and for each find a collision.
   * A collision happens when 2 different inputs generate the same hash.
   * This is dangerous in password-validation systems that use hash-codes (and in many other applications),
   * as the system will wrongfully assume the user to have supplied the correct password, allowing an attacker to login.
   *
   * N.B. 1: If by chance your randomly generate the actual original password, then this is fine too of course!
   * N.B. 2: As you by now, no doubt have seen, the elements in "Password", "Salt" and "Hash" are all in the same order,
   *         as in, the first password, with the first salt, results in the first hash.
   *         When returning from this method, make sure your password guesses are in the same order!
   */
  public List<String> findCollidingPasswords() {
    // TODO: implement this!
    return Collections.emptyList(); // Temporary placeholder
  }

}
