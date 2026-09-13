class Solution {
    public int findDuplicate(int[] nums) {
        // Step 1: Slow and Fast pointers
        int slow = nums[0];
        int fast = nums[0];

        // Move slow = 1 step, fast = 2 steps
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);  // meet ayye varaku

        // Step 2: One pointer to start, one at meeting point
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // Meeting point = duplicate number
        return slow;
    }
}
