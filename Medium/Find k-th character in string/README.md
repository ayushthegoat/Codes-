<h2><a href="https://www.geeksforgeeks.org/problems/find-k-th-character-in-string3841/1">Find k-th character in string</a></h2><h3>Difficulty Level : Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given a decimal number <strong>m</strong>. Convert it into a binary string and apply <strong>n</strong> iterations, in each iteration <strong>0</strong> becomes <strong>01</strong>, and <strong>1</strong> becomes <strong>10</strong>. Find the<strong> k</strong>th (1-indexing) character in the string after the&nbsp;<strong>n</strong>th iteration.</span></p>
<p><span style="font-size: 18px;"><strong>Example 1:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong> m = 5, n = 2, k = 5
<strong>output:</strong> 0
<strong>Explanation:</strong> Binary representation of m 
is "101", after one iteration binary 
representation will be "100110", and after 
second iteration binary representation </span><span style="font-size: 18px;">
will be "100101101001". </span></pre>
<p><span style="font-size: 18px;"><strong>Example 1:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong> m = 5, n = 2, k = 1
<strong>output:</strong> 1
<strong>Explanation:</strong> Binary representation of m 
is "101", after one iteration binary 
representation will be "100110", and after 
second iteration binary representation</span><span style="font-size: 18px;">
will be "100101101001". </span></pre>
<p><span style="font-size: 18px;"><strong>Your task:</strong><br>You do not need to read any input or print anything. The task is to complete the function <strong>kthCharacter()</strong>, which takes 3 integers m, n, and k as input and returns a character. </span></p>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:</strong>&nbsp;O(2<sup>n</sup>)<br><strong>Expected Auxiliary Space:</strong>&nbsp;O(2<sup>n</sup>)</span></p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong></span><br><span style="font-size: 18px;">0 ≤ m ≤ 50<br>0 ≤ n ≤ 10<br>K is a valid index</span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Strings</code>&nbsp;<code>Data Structures</code>&nbsp;