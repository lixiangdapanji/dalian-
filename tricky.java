fabi
public class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 1, b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            b = a;
            a = c;
        }
        return c;
    }
}

String Permutation
public class Solution {
    public boolean Permutation(String A, String B) {
        // write your code here
        int[] str = new int[123];
        for (int i = 0; i < A.length(); ++i)
            str[(int)A.charAt(i)] += 1;
        for (int i = 0; i < B.length(); ++i)
            str[(int)B.charAt(i)] -= 1;
        for (int i = 0; i < 123; ++i)
            if (str[i] != 0)
                return false;
        return true;
    }
}