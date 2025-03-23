import java.util.HashMap;

class Solution {
    public int maxPoints(int[][] points) {
        if(points.length <= 2) return points.length; // Edge case

        HashMap<Grad, Integer> lines = new HashMap<Grad, Integer>();
        int max = 2;

        for (int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                // Calculate the gradient as a fraction dy/dx
                Grad grad = new Grad(points[i], points[j]);
                // Increment its key in the hashmap
                if(lines.containsKey(grad)){
                    lines.put(grad, lines.get(grad) + 1);
                }else{
                    lines.put(grad, 2);
                }

            }
            // Change current max number of points
            for (int numOfPoints : lines.values()){
                if(numOfPoints > max) max = numOfPoints;
            }
            // New hashmap for all the gradients that pass through a given point
            lines.clear();
        }

        return max;
    }

    public static int gcd(int a, int b){
        if(a == 0) return b;

        return gcd(b%a, a);
    }
}

class Grad{
    private int dy;
    private int dx;

    public Grad(int[] coords1, int[] coords2){
        int dy = coords2[1] - coords1[1];
        int dx = coords2[0] - coords1[0];
        int gcd = Solution.gcd(dy,dx);

        this.dy = dy / gcd;
        this.dx = dx / gcd;
    }

    @Override
    public boolean equals(Object o){
        if ((o == null) || (o.getClass() != this.getClass())) return false;
        
        Grad og = (Grad) o;
        return (this.dy == og.dy) && (this.dx == og.dx); 
    }

    @Override
    public int hashCode(){
        return (dy + dx * (dy - 1) / 2);
    }
}
