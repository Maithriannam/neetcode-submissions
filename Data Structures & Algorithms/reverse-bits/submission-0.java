class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;               // take last bit
            result = (result << 1) | bit;  // append to result
            n >>= 1;                       // move to next bit
        }
        return result;
    }
}
