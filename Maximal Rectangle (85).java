class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[][] height = new int[matrix.length][matrix[0].length];

        for (int x = 0; x < matrix[0].length; x++){
            height[0][x] = (matrix[0][x] == '0') ? 0 : 1;
        }

        for (int y = 1; y < matrix.length; y++){
            for (int x = 0; x < matrix[0].length; x++){
                height[y][x] = (matrix[y][x] == '0') ? 0 : 1 + height[y-1][x];
            }
        }

        int[][] right = new int[matrix.length][matrix[0].length];
        int[][] left = new int[matrix.length][matrix[0].length];

        for (int y = 0; y < matrix.length; y++){
            for (int x = 0; x < matrix[y].length; x++){
                int temp = x - 1;
                while (temp >= 0 && height[y][temp] >= height[y][x])
                    temp = left[y][temp];
                left[y][x] = temp;
            }
            for (int x = matrix[y].length - 1; x >= 0; x--){
                int temp = x + 1;
                while (temp < matrix[y].length && height[y][temp] >= height[y][x])
                    temp = right[y][temp];
                right[y][x] = temp;
            }
        }

        //print(height); print(right); print(left);
        int max = 0;

        for (int y = 0; y < matrix.length; y++){
            for (int x = 0; x < matrix[y].length; x++){
                int area = height[y][x] * (right[y][x] - left[y][x] - 1);
                if (area > max){
                    max = area;
                }
            }
        }
        return max;
    }

    // private void print(int[][] grid){
    //     for (int y = 0; y < grid.length; y++){
    //         for (int x = 0; x < grid[y].length; x++){
    //             System.out.print(grid[y][x] + " ");
    //         }
    //         System.out.println();
    //     }
    //     System.out.println();
    // }
}
