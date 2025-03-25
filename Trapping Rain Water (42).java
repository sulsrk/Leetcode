class Solution {
    public int trap(int[] height) {
        return nnSol(height);
    }

    public int n2Sol(int[] height){
        // O(n^2) time complexity, O(1) space
        int maxHeightR = findMaxHeightRight(height, 0);
        int maxHeightL = 0;
        int total = 0;
        // The water that can be trapped on a given column depends on the min of the maximum
        // heights of the walls to the left/right ( - the columns own height)
        for (int i = 0; i < height.length; i++){
            // If the current height is the max, find a new max
            if (height[i] == maxHeightR) maxHeightR = findMaxHeightRight(height, i+2); 
            if (height[i] > maxHeightL) maxHeightL = height[i];

            int trapped = min(maxHeightL, maxHeightR) - height[i];
            if (trapped > 0) total += trapped;
        }

        return total;
    }

    public int nnSol(int[] height){
        // O(n) time, O(n) space
        if (height.length == 0) return 0;

        int maxHeightL = 0;
        int[] maxHeightsR = findMaxHeightsRight(height);

        int total = 0;

        for (int i = 0; i < height.length; i++){
            if (height[i] > maxHeightL) maxHeightL = height[i];
            
            int trapped = min(maxHeightL, maxHeightsR[i]) - height[i];
            if (trapped > 0) total += trapped;
        }

        return total;
    }

    private int[] findMaxHeightsRight(int[] height){
        int[] maxHeightsR = new int[height.length];
        maxHeightsR[height.length - 1] = 0;

        for (int i = height.length - 2; i >= 0; i--)
            maxHeightsR[i] = max(height[i+1], maxHeightsR[i+1]);

        return maxHeightsR;
    }

    private int findMaxHeightRight(int[] height, int index){
        int max = 0;
        for(int i = index; i < height.length; i++){
            if (height[i] > max) max = height[i];
        }
        return max;
    }

    private int min(int a, int b){
        if (a < b) return a;
        return b;
    }

    private int max(int a, int b){
        if (a > b) return a;
        return b;
    }
}
