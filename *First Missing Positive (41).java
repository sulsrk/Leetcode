import java.util.HashSet;

class Solution {
    public int firstMissingPositive(int[] nums) {
        /* Researched */
        boolean one = false;
        // Get rid of zeros and duplicates by replacing them with a 1.
        // Keep track of whether a 1 appears naturally.
        for (int i = 0; i < nums.length; i++){
            one |= (nums[i] == 1);
            if (nums[i] <= 0 || nums[i] > nums.length) nums[i] = 1;
        }

        if (!one) return 1;

        // Use the index of the array as a hash, making it negative if the number exists
        for (int i : nums){
            if (i < 0) i *= -1;
            if (i > 1 && nums[i - 1] > 0) nums[i - 1] *= -1;
        }
        // Look for the first non-negative index to return, otherwise return length+1
        for (int i = 1; i < nums.length; i++)
            if (nums[i] > 0) return i + 1;
        
        return nums.length + 1;
    }
}
