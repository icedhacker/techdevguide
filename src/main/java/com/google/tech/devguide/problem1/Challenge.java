package com.google.tech.devguide.problem1;

import java.util.Arrays;
import java.util.Comparator;

public class Challenge {

  public String solve(String s, String... d) {
    sortArrayByCharLengthDesc(d);
    for (int i = d.length - 1; i >= 0; i--) {
      if (isSubsequence(d[i], s)) {
        return d[i];
      }
    }
    return null;
  }

  private boolean isSubsequence(String subSequence, String word) {
    int j = 0;
    char[] wordArr = word.toCharArray();
    char[] subSeqArr = subSequence.toCharArray();
    for (int i = 0; i < wordArr.length && j < subSeqArr.length; i++) {
      if (subSeqArr[j] == wordArr[i]) {
        j++;
      }
    }
    return (j == subSeqArr.length);
  }

  private String[] sortArrayByCharLengthDesc(String[] d) {
    Arrays.sort(d, Comparator.comparing(String::length));
    return d;
  }
}
