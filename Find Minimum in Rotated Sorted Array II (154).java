class Solution {
    public int findMin(int[] nums) {
        int start = 0; int end = nums.length - 1;
        int mid = 0;
        while (start <= end){
            mid = (start+end)/2;
            if (nums[mid] > nums[end]){
                start = (start == mid) ? mid + 1 : mid;
            } else if (nums[start] == nums[end]){
                start++; end--;
            } else {
                end = (end == mid) ? mid - 1 : mid;
            } 
        }

        return nums[mid];
    }


}
