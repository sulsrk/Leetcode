import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;

class RandomizedCollection {
    HashMap<Integer,HashSet<Integer>> inds;
    ArrayList<Integer> nums;

    public RandomizedCollection() {
        nums = new ArrayList<Integer>();
        inds = new HashMap<Integer,HashSet<Integer>>();
    }
    
    public boolean insert(int val) {
        boolean contains = inds.containsKey(val);
        if (!contains){
            inds.put(val, new HashSet<Integer>());
        }
        
        inds.get(val).add(nums.size());
        nums.add(val);

        return !contains;
    }
    
    public boolean remove(int val) {
        HashSet<Integer> valInds = inds.get(val);
        if (valInds == null || nums.size() == 0) return false;

        int last = nums.get(nums.size() - 1);
        if (last == val){
            valInds.remove(nums.size() - 1);
            if (valInds.size() == 0) inds.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        } 

        int toRem = valInds.iterator().next();
        HashSet<Integer> replace = inds.get(last);

        replace.remove(nums.size() - 1);
        replace.add(toRem);

        valInds.remove(toRem);
        if (valInds.size() == 0) inds.remove(val);

        nums.set(toRem, last);
        nums.remove(nums.size() - 1);

        return true;
    }
    
    public int getRandom() {
        int index = (int) (Math.random()*nums.size());
        return nums.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
