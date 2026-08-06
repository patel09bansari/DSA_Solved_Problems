# Missing in Array

## Difficulty: Easy

## Platform: GeeksForGeeks

## Problem Link
[View Problem](https://www.geeksforgeeks.org/problems/missing-number-in-array1416/1)

## Solved On
06 Aug 2026 at 07:48 pm

<h2><a href="https://www.geeksforgeeks.org/problems/missing-number-in-array1416/1">Missing in Array</a></h2><h3>Difficulty Level: Easy</h3><hr><p><span style="font-size: 14pt;">You are given an array <strong>arr[]</strong> of size <strong>n - 1</strong> that contains<strong> distinct integers </strong>in the range from 1 to n (inclusive). This array represents a permutation of the integers from 1 to n with <strong>one element missing</strong>. Your task is to identify and return the <strong>missing element</strong>.</span></p>
<p><span style="font-size: 14pt;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>arr[] = [1, 2, 3, 5]
<strong>Output: </strong>4
<strong>Explanation: </strong>All the numbers from 1 to 5 are present except 4.<br></span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>arr[] = [8, 2, 4, 5, 3, 7, 1]
<strong>Output:</strong> 6
<strong>Explanation: </strong>All the numbers from 1 to 8 are present except 6.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>arr[] = [1]
<strong>Output: </strong>2
<strong>Explanation: </strong>Only 1 is present so the missing element is 2.<br></span></pre>
<p><span style="font-size: 14pt;"><strong>Constraints:</strong><br>1 ≤ arr.size() ≤ 10<sup>6</sup><br>1 ≤ arr[i] ≤ arr.size() + 1</span></p>