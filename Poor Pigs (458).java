class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets <= 1) return 0;

        final int tests = (minutesToTest / minutesToDie) + 1;
        int bucketCount = tests; int pigs = 1;

        while (bucketCount < buckets){
            bucketCount *= tests;
            pigs++;
        }

        return pigs;
    }
}
