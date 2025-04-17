class Solution {
    public boolean isSelfCrossing(int[] distance) {
        if (distance.length < 4) return false;

        for (int i = 3; i < distance.length; i++){
            if (distance[i] >= distance[i-2]){
                if (distance[i-1] <= distance[i-3]) return true;

                if (i+1 < distance.length && 
                distance[i+1] >= (distance[i-1] - distance[i-3])){
                    
                    if (distance[i] == distance[i-2]) return true;

                    if (i+2 < distance.length && 
                    distance[i+1] <= distance[i-1] &&
                    distance[i+2] >= (distance[i] - distance[i-2])) return true;
                }
            }
        }

        return false;
    }
}
