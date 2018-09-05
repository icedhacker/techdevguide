package com.google.tech.devguide.problem1;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.time.Instant;
import org.junit.Before;
import org.junit.Test;

public class ChallengeTest {

  private Challenge challenge;

  @Before
  public void setup() {
    challenge = new Challenge();
  }

  @Test
  public void sampleTestCaseWithSolutionOne() {
    Instant start = Instant.now();
    String actual = challenge
        .solveWithSolnOne("abppplee", "able", "ale", "apple", "bale", "kangaroo");
    Instant finish = Instant.now();
    assertThat(actual).isEqualTo("apple");
    long timeElapsed = Duration.between(start, finish).toMillis();
    System.out.println("Execution Time is " + timeElapsed);
  }
}
