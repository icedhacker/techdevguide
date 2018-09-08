package com.google.tech.devguide.problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  /**
   * Second Solution :
   *
   * 1. Sort the Dictionary by String Length
   *
   * 2. Create a Map with the character and all index positions from the sequence.
   *
   * 3. Use the map to check if the words in the dictionary are a subsequence.
   *
   * 4. If true, return the dictionary word. Else, Continue.
   *
   * 5. If no match found, return null.
   *
   * Consider 'N' as length of sequence, 'M' as length of dictionary & 'W' as length of word in
   * dictionary.
   *
   * Space Complexity : O(1)
   *
   * Time Complexity : O(N + W * log N )
   */
  public String solveWithSolnTwo(String sequence, String... dictionary) {
    sortArrayByCharLengthDesc(dictionary);
    Map<Character, List<Integer>> charMap = createCharMap(sequence);
    for (int i = dictionary.length - 1; i >= 0; i--) {
      if (isSubSequenceWithMap(dictionary[i], charMap)) {
        return dictionary[i];
      }
    }
    return null;
  }

  private Map<Character, List<Integer>> createCharMap(String word) {
    Map<Character, List<Integer>> charMap = new HashMap<>();
    int i = 0;
    for (char ch : word.toCharArray()) {
      List<Integer> tempList = charMap.containsKey(ch) ? charMap.get(ch) : new ArrayList<>();
      tempList.add(i);
      charMap.put(ch, tempList);
      i++;
    }
    return charMap;
  }

  private boolean isSubSequenceWithMap(String subSequence,
      Map<Character, List<Integer>> sequenceMap) {
    int lastIndex = -1;
    for (char ch : subSequence.toCharArray()) {
      if (!sequenceMap.containsKey(ch)) {
        return false;
      }
      boolean found = false;
      for (int i : sequenceMap.get(ch)) {
        if (i > lastIndex) {
          found = true;
          lastIndex = i;
          break;
        }
      }
      if (!found) {
        return false;
      }
    }
    return true;
  }
}
