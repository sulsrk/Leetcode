class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        valueDiff++;
        for (int i : nums){
            max = Math.max(max, i);
            min = Math.min(min, i);
        } 
        
        final int M = max - min;
        int[] arr = new int[M/valueDiff + 1];
        boolean[] set = new boolean[M/valueDiff + 1];

        for (int i = 0; i < nums.length; i++){
            int ind = (nums[i]-min)/valueDiff;
            // System.out.print(ind + " ");
            // Check current bucket
            if ((set[ind] && i - arr[ind] <= indexDiff)
            // Check neighbourhing buckets for values that slide between them
            || (ind > 0 && set[ind-1] && i-arr[ind-1] <= indexDiff && 
            nums[i]-nums[arr[ind-1]] < valueDiff)
            || (ind < arr.length-1 && set[ind+1] && i-arr[ind+1] <= indexDiff && 
            nums[arr[ind+1]]-nums[i] < valueDiff)) 
                return true;

            set[ind] = true; arr[ind] = i;
        }
        return false;
    }
}
