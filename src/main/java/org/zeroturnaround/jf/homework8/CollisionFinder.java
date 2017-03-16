package org.zeroturnaround.jf.homework8;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sets up the required number of producer and consumer threads,
 * coordinates their information exchange,
 * keeps track of the discovered collisions (and only stores the first one found),
 * and takes care of a **clean** shutdown once all passwords have a found collision.
 */
public class CollisionFinder {

  private static final Logger log = LoggerFactory.getLogger(CollisionFinder.class);

  /**
   * Read the data provided by the "Salt" and "Hash" classes, and for each find a collision.
   * A collision happens when 2 different inputs generate the same hash.
   * This is dangerous in password-validation systems that use hash-codes (and in many other applications),
   * as the system will wrongfully assume the user to have supplied the correct password, allowing an attacker to login.
   *
   * N.B. 1: If by chance your randomly generate the actual original password, then this is fine too of course!
   * N.B. 2: As you by now, no doubt have seen, the elements in "Password", "Salt" and "Hash" are all in the same order,
   *         meaning the first password with the first salt results in the first hash.
   *         When returning from this method, make sure your password guesses are in the same order.
   */
  public List<String> findCollidingPasswords() {
    // TODO: implement this!

    // STEP 1: create and start the needed numbers of producers and consumers using a proper Executor(s)
    // STEP 2: do a clean wait (do not waste CPU resources waiting) until all passwords are cracked
    // STEP 3: signal all producers and consumers that work is done, and that they should finish
    // STEP 4: do another clean wait until all of them are shut down, and until your Executor(s) have shut down properly
    // STEP 5: only now return the result

    return Collections.emptyList(); // Temporary placeholder
  }
}
