<h2><a href="https://leetcode.com/problems/apply-operations-to-make-string-empty/">3039. Apply Operations to Make String Empty</a></h2><h3>Medium</h3><hr><div><p>You are given a string <code>s</code>.</p>

<p>Consider performing the following operation until <code>s</code> becomes <strong>empty</strong>:</p>

<ul>
	<li>For <strong>every</strong> alphabet character from <code>'a'</code> to <code>'z'</code>, remove the <strong>first</strong> occurrence of that character in <code>s</code> (if it exists).</li>
</ul>

<p>Return <em>the value of the string </em><code>s</code><em> right <strong>before</strong> applying the <strong>last</strong> operation</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "aabcbbca"
<strong>Output:</strong> "ba"
<strong>Explanation:</strong> We do the following operations:
- Remove the underlined characters s = "<u><strong>a</strong></u>a<strong><u>bc</u></strong>bbca". The resulting string is s = "abbca".
- Remove the underlined characters s = "<u><strong>ab</strong></u>b<u><strong>c</strong></u>a". The resulting string is s = "ba".
- Remove the underlined characters s = "<u><strong>ba</strong></u>". The resulting string is s = "".
The string just before the last operation is "ba".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "abcd"
<strong>Output:</strong> "abcd"
<strong>Explanation:</strong> We do the following operation:
- Remove the underlined characters s = "<u><strong>abcd</strong></u>". The resulting string is s = "".
The string just before the last operation is "abcd".
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 5 * 10<sup>5</sup></code></li>
	<li><code>s</code> consists only of lowercase English letters.</li>
</ul>
</div>