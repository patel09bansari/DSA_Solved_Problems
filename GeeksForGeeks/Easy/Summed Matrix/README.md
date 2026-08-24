# Summed Matrix

## Difficulty: Easy

## Platform: GeeksForGeeks

## Problem Link
[View Problem](https://www.geeksforgeeks.org/problems/summed-matrix5834/1)

## Solved On
24 Aug 2026 at 11:01 pm

<h2><a href="https://www.geeksforgeeks.org/problems/summed-matrix5834/1">Summed Matrix</a></h2><h3>Difficulty Level: Easy</h3><hr><p class="PDq2pG_selectionAnchorContainer" data-start="489" data-end="699"><span style="font-size: 14pt;">Given two integers <strong>n </strong>and <strong>q</strong>, consider a n * n matrix where the value at cell (i, j) is i + j, with both row and column indices starting from 1. Return the number of cells whose value is equal to q. </span></p>
<p class="PDq2pG_selectionAnchorContainer" data-start="489" data-end="699"><span style="font-size: 14pt;"><strong data-start="701" data-end="710">Note:</strong> The matrix uses 1-based indexing.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong style="font-size: 18px;">Input:</strong> </span><span style="font-size: 18px;">n =<strong> </strong>4, q =<strong> </strong>7</span>
<span style="font-size: 18px;"><strong><span style="font-size: 18px;">Output:</span> </strong></span><span style="font-size: 18px;">2</span>
<span style="font-size: 18px;"><strong><span style="font-size: 18px;">Explanation:</span> </strong></span><span style="font-size: 18px;">Matrix becomes
2 3 4 5 
3 4 5 6 
4 5 6 7
5 6 7 8
</span><span style="font-size: 18px;">The count of 7 is 2.</span></pre>
<pre><span style="font-size: 18px;"><strong style="font-size: 18px;">Input:</strong> </span><span style="font-size: 18px;">n =<strong> </strong>5, q =<strong> </strong>4</span>
<span style="font-size: 18px;"><strong><span style="font-size: 18px;">Output:</span> </strong></span><span style="font-size: 18px;">3</span>
<span style="font-size: 18px;"><strong><span style="font-size: 18px;">Explanation:</span> </strong></span><span style="font-size: 18px;">Matrix becomes
2 3 4 5 6&nbsp;
3 4 5 6 7&nbsp;
4 5 6 7 8&nbsp;
5 6 7 8 9&nbsp;
6 7 8 9 10&nbsp;
The count of 4 is 3.</span></pre>