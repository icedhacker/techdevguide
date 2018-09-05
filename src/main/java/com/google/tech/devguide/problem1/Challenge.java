package com.google.tech.devguide.problem1;

import java.util.Arrays;
import java.util.Comparator;

public class Challenge {

  /**
   * First Solution :
   *
   * 1. Sort the Dictionary by String Length
   *
   * 2. Loop through the dictionary in descending order.
   *
   * 3. Check if the word in dictionary is a subsequence of the input sequence.
   *
   * 4. If true, return the dictionary word. Else, Continue.
   *
   * 5. If no match found, return null.
   *
   * Consider 'n' as length of sequence, 'm' as length of dictionary & 'w' as length of word in
   * dictionary.
   *
   * Space Complexity : O(1)
   *
   * Time Complexity : O(m * n)
   */
  public String solveWithSolnOne(String sequence, String... dictionary) {
    sortArrayByCharLengthDesc(dictionary);
    for (int i = dictionary.length - 1; i >= 0; i--) {
      if (isSubsequence(dictionary[i], sequence)) {
        return dictionary[i];
      }
    }
    return null;
  }

  private boolean isSubsequence(String subSequence, String sequence) {
    int j = 0;
    for (int i = 0; i < sequence.length() && j < subSequence.length(); i++) {
      if (subSequence.charAt(j) == sequence.charAt(i)) {
        j++;
      }
    }
    return (j == subSequence.length());
  }

  private String[] sortArrayByCharLengthDesc(String[] dictionary) {
    Arrays.sort(dictionary, Comparator.comparing(String::length));
    return dictionary;
  }
}
