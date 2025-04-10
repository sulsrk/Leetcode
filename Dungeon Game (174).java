class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        dungeon[dungeon.length-1][dungeon[0].length - 1] = 
            1 - dungeon[dungeon.length-1][dungeon[0].length - 1];
        if (dungeon[dungeon.length-1][dungeon[0].length - 1] <= 0)
            dungeon[dungeon.length-1][dungeon[0].length - 1] = 1;

        for (int y = dungeon.length - 2; y >= 0; y--){
            dungeon[y][dungeon[0].length-1] = 
                get(dungeon[y+1][dungeon[0].length-1],dungeon[y][dungeon[0].length-1]);
        }

        for (int x = dungeon[0].length - 2; x >= 0; x--){
            dungeon[dungeon.length-1][x] = 
                get(dungeon[dungeon.length-1][x+1],dungeon[dungeon.length-1][x]);
        }

        for (int x = dungeon[0].length - 2; x >= 0; x--){
            for (int y = dungeon.length - 2; y >= 0; y--){
                int min = Math.min(dungeon[y+1][x],dungeon[y][x+1]);
                dungeon[y][x] = get(min, dungeon[y][x]);
            }
        }
        
        return dungeon[0][0];
    }

    private void print(int[][] arr){
        for (int y = 0; y < arr.length; y++){
            for (int x = 0; x < arr[y].length; x++)
                System.out.print(arr[y][x] + " ");
            System.out.println();
        }
    }

    private int get(int min, int cur){
        if (cur > 0 && cur >= min){
            return 1;
        } else {
            return min - cur;
        }
    }
}
