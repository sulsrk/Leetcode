class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        arr[nums.length - 1] = 0;

        Node tree = new Node(nums[nums.length-1]);

        for (int i = nums.length - 2; i >= 0; i--){
            arr[i] = 0;

            tree = insert(tree, nums[i], arr, i); 
        }
        
        return Arrays.asList(arr);
    }

    private Node insert(Node n, int val, Integer[] arr, int ind){
        if (n == null){
            return new Node(val);
        }

        if (val > n.val){
            arr[ind] += n.size;
            n.right = insert(n.right, val, arr, ind);
        } else {
            n.size++;
            n.left = insert(n.left, val, arr, ind);
        }

        n.update();
        if (Node.getBalance(n) > 1) {
            Node temp = n.right.left;
            n.right.left = n;
            n = n.right;
            n.left.right = temp;
            n.update();
            n.left.update();
            n.size += n.left.size;
        } else if (Node.getBalance(n) < -1) {
            Node temp = n.left.right;
            n.left.right = n;
            n = n.left;
            n.right.left = temp;
            n.update();
            n.right.update();
            n.right.size -= n.size;
        }

        return n;
    }
}

class Node{
    int val;
    int size;
    int height;
    Node left;
    Node right;

    public Node(int val){
        this.val = val;
        this.size = 1;
        this.height = 0;
    }

    public static int height (Node n){
        return (n == null) ? -1 : n.height;
    }

    public static int getBalance(Node n){
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    public void update(){
        this.height = 1 + Math.max(height(left), height(right));
    }
}
