# The Challenge

Description : [https://goo.gl/ZFKK9Q]

Given a string *S* and a set of words *D*, find the longest word in *D* that is a subsequence of *S*.

Word *W* is a subsequence of *S* if some number of characters, possibly zero, can be deleted from *S* 
to form *W*, without reordering the remaining characters.

Note: *D* can appear in any format : list, hash table, prefix tree, etc.

For example, given the input :
```sh
S = "abppplee"
D = {"able", "ale", "apple", "bale", "kangaroo"}
```
The correct output would be *"apple"*

* The words "able" and "ale" are both subsequences of S, but they are shorter than "apple".
* The word "bale" is not a subsequence of S because even though S has all the right letters, they 
are not in the right order.
* The word "kangaroo" is the longest word in D, but it isn't a subsequence of S.

### Learning objectives

This question gives you the chance to practice with algorithms and data structures. It’s also a good 
example of why careful analysis for Big-O performance is often worthwhile, as is careful exploration 
of common and worst-case input conditions.