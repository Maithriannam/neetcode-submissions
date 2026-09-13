class Solution {
    public double myPow(double x, int n) {
        long power = n;        // use long to handle overflow
        if (power < 0) {
            x = 1 / x;         // reciprocal if negative
            power = -power;
        }

        double ans = 1.0;
        while (power > 0) {
            if (power % 2 == 1) {   // if odd
                ans *= x;
            }
            x *= x;    // square the base
            power /= 2; // halve the power
        }
        return ans;
    }
}
