# Minimum Cost Selection

## Difficulty: Medium

## Platform: GeeksForGeeks

## Problem Link
[View Problem](https://www.geeksforgeeks.org/problems/buying-vegetables0016/1)

## Solved On
28 Aug 2026 at 09:15 am

<h2><a href="https://www.geeksforgeeks.org/problems/buying-vegetables0016/1">Minimum Cost Selection</a></h2><h3>Difficulty Level: Medium</h3><hr><p><span style="font-size: 18px;">Given an <strong>n × 3</strong> matrix <strong>mat[][]</strong>, where each row represents the costs of three available choices at a shop, </span><span style="font-size: 18px;">select exactly one choice from each row such that the same choice is not selected in two adjacent rows. </span></p>
<p><span style="font-size: 18px;">Return the minimum<strong> </strong>total cost required.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>mat[][] = [[1, 50, 50], [50, 50, 50], [1, 50, 50]]<strong>
Output: </strong>52<strong>
Explanation: </strong>One optimal selection is- Row 1: Choice 1 (Cost = 1), Row 2: Choice 2 (Cost = 50), Row 3: Choice 1 (Cost = 1)
Total cost = 1 + 50 + 1 = 52.</span></pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>mat[][] = [[1, 4, 1], [3, 2, 2], [3, 2, 3]]<strong>
Output: </strong>5<strong>
Explanation: </strong>One optimal selection is- Row 1: Choice 1 (Cost = 1), Row 2: Choice 2 (Cost = 2), Row 3: Choice 3 (Cost = 2)
Total cost = 1 + 2 + 2 = 5.</span></pre>
