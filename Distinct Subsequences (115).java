class Solution {
    public int numDistinct(String s, String t) {
        int[][] ways = new int[t.length() + 1][s.length() + 1];

        // Set bottom row to '1 way'
        for (int i = 0; i < s.length()+1; i++){
            ways[t.length()][i] = 1;
        }

        /*
        The number of unique subsequences of length n at a point i depends on the number of
        distinct subsequences of length n-1 from the point i+1.
        */
        for (int tp = t.length() - 1; tp >= 0; tp--){
            for (int sp = s.length() - 1; sp >= 0; sp--){

                ways[tp][sp] = ways[tp][sp+1];
                if (s.charAt(sp) == t.charAt(tp))
                    ways[tp][sp] += ways[tp+1][sp+1];

            }
            // print(ways);
        }

        return ways[0][0];
    }

    // private void print(int[][] grid){
    //     for (int y = 0; y < grid.length; y++){
    //         for (int x = 0; x < grid[0].length; x++){
    //             System.out.print(grid[y][x] + " ");
    //         }
    //         System.out.println();
    //     }
    //     System.out.println();
    // }
}
