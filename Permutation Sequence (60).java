import java.util.ArrayList;

class Solution {
    public String getPermutation(int n, int k) {
        k -= 1;
        // Initialise list of possible digits
        ArrayList<Integer> availableDigits = new ArrayList<Integer>(n);
        for (int i = 1; i <= n; i++) availableDigits.add(i);
        // Store initial permutation count for efficiency
        int subpermcount = fact(n-1);
        // Initialise permutation
        StringBuilder permutation = new StringBuilder();

        // For every digits in the permutation...
        for (int i = n-1 ; i > 0; i--){
            /*The kth permutation digit for a sequence of length n depends on the amount of
            permutations of length n-1 that were repeated before it*/
            permutation.append(
                String.valueOf(availableDigits.remove(k / subpermcount))
                );
            // "Normalise" the permutation position
            k %= subpermcount;
            subpermcount /= i;
        }
        // Append final digit for i=0
        permutation.append(
            String.valueOf(availableDigits.get(0))
        );

        return permutation.toString();
    }

    private int fact(int n){
        int ans = 1;
        for (int i = 2; i <= n; i++){
            ans *= i;
        }
        return ans;
    }
}
