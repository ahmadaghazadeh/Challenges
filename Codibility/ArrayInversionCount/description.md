### If you’re using this test for recruitment we recommend swapping it with: BinaryPositiveAnd.

A non-negative integer N is called sparse if its binary representation does not contain two consecutive bits set to 1. For example, 41 is sparse, because its binary representation is "101001" and it does not contain two consecutive 1s. On the other hand, 26 is not sparse, because its binary representation is "11010" and it contains two consecutive 1s.

Two non-negative integers P and Q are called a sparse decomposition of integer N if P and Q are sparse and N = P + Q.

For example:

8 and 18 are a sparse decomposition of 26 (binary representation of 8 is "1000", binary representation of 18 is "10010");
9 and 17 are a sparse decomposition of 26 (binary representation of 9 is "1001", binary representation of 17 is "10001");
2 and 24 are not a sparse decomposition of 26; though 2 + 24 = 26, the binary representation of 24 is "11000", which is not sparse.
Write a function:

class Solution { public int solution(int N); }

that, given a non-negative integer N, returns any integer that is one part of a sparse decomposition of N. The function should return −1 if there is no sparse decomposition of N.

For example, given N = 26 the function may return 8, 9, 17 or 18, as explained in the example above. All other possible results for N = 26 are 5, 10, 16 and 21.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..1,000,000,000].