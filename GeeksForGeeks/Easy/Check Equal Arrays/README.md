# Check Equal Arrays

## Difficulty: Easy

## Platform: GeeksForGeeks

## Problem Link
[View Problem](https://www.geeksforgeeks.org/problems/check-if-two-arrays-are-equal-or-not3847/1)

## Solved On
04 Aug 2026 at 10:14 am

<h2><a href="https://www.geeksforgeeks.org/problems/check-if-two-arrays-are-equal-or-not3847/1">Check Equal Arrays</a></h2><h3>Difficulty Level: Easy</h3><hr><p><span style="font-size: 18px;">Given two arrays <strong>a[]</strong> and <strong>b[] </strong>of equal size, the task is to find whether the elements in the arrays are equal.<br></span><span style="font-size: 18px;">Two arrays are said to be equal if both contain the same set of elements, arrangements (or permutations) of elements may be different though.<br></span><span style="font-size: 18px;"><strong>Note:</strong> If there are repetitions, then counts of repeated elements must also be the same for two arrays to be equal.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>a[] = [1, 2, 5, 4, 0], b[] = [2, 4, 5, 0, 1]
<strong>Output: </strong>true<strong>
Explanation: </strong>Both the array can be rearranged to [0,1,2,4,5]</span>
</pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>a[] = [1, 2, 5], b[] = [2, 4, 15]
<strong>Output: </strong>false<strong>
Explanation: </strong>a[] and b[] have only one common value.</span></pre>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 ≤ a.size(), b.size() ≤ 10<sup>7</sup><br>0 ≤ a[i], b[i] ≤ 10<sup>9</sup></span></p>