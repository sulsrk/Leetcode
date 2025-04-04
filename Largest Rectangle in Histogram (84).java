class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        for (int i = 0; i < heights.length; i++){
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i])
                j = left[j];
            left[i] = j;
        }

        for (int i = heights.length - 1; i >= 0; i--){
            int j = i + 1;
            while (j < heights.length && heights[j] >= heights[i])
                j = right[j];
            right[i] = j;
        }

        for (int i = 0; i < heights.length; i++){
            int area = (right[i] - left[i] - 1) * heights[i];
            if (area > max) max = area;
        }
        return max;
    }
}
