# Longest Matching in Dictionary with Removals

## Difficulty: Medium

## Platform: GeeksForGeeks

## Problem Link
[View Problem](https://www.geeksforgeeks.org/problems/find-largest-word-in-dictionary2430/1)

## Solved On
22 Sept 2026 at 07:28 pm

<h2><a href="https://www.geeksforgeeks.org/problems/find-largest-word-in-dictionary2430/1">Longest Matching in Dictionary with Removals</a></h2><h3>Difficulty Level: Medium</h3><hr><p><span style="font-size: 14pt;">Given a lowercase string <strong>s</strong> and a dictionary <strong>d[]</strong> containing lowercase words, find the longest word in the dictionary that can be obtained by deleting some characters from s without changing the order of the remaining characters.</span></p><p><span style="font-size: 14pt;"><strong>Note</strong>: If multiple words have the same maximum length, return the lexicographically smallest one. If no valid word exists, return an empty string.</span></p><p><span style="font-size: 14pt;"><strong>Examples :&nbsp;</strong></span></p><pre><span style="font-size: 14pt;"><strong>Input</strong>: d = ["ale", "apple", "monkey", "plea"], s = "abpcplea"<br><strong>Output:</strong> "apple"&nbsp;<br><strong>Explanation</strong>: After deleting "b", "c", "a" s became "apple" which is present in d.
</span></pre><pre><span style="font-size: 14pt;"><strong>Input: </strong>d = ["a", "b", "c"], s = "abpcplea"<br><strong>Output:&nbsp;</strong>"a"<br><strong>Explanation</strong>: After deleting "b", "p", "c", "p", "l", "e", "a" s became "a" which is present in d.</span></pre><p><span style="font-size: 14pt;"><strong>Constraints:</strong></span><br><span style="font-size: 14pt;">1 ≤ |s| ≤ 5 * 10<sup>5<br></sup>1 ≤ n ≤ 10<sup>4</sup>, where n is the number of words in dictionary<sup><br></sup></span><span style="font-size: 14pt;">1 ≤ m ≤ 100, where m is the length of word in dictionary<br>s&nbsp;and all words in dictionary consist only of lowercase English letters.</span></p>