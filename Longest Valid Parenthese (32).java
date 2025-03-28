class Solution {
    boolean formed = false;
    int ind = 0;
    String s;

    public int longestValidParentheses(String s) {
        this.s = s;
        int count = 0; int max = 0;

        while (ind < s.length()){
            if (s.charAt(ind++) == '('){
                int add = getFormed();
                if (formed){
                    count += add;
                } else {
                    count = add;
                }
            } else {
                formed = false;
                count = 0;
            }
            max = (count > max) ? count : max;
        }

        return max << 1;
    }

    int getFormed(){
        if (ind == s.length()) return 0;

        int count = 0;
        while (ind < s.length()){
            if (s.charAt(ind++) == '('){
                int add = getFormed();
                if (formed) {
                    count += add;
                } else {
                    count = (add > count) ? add : count;
                }
            } else {
                formed = true;
                return (count + 1);
            }
        }
        formed = false;
        return count;
    }
}
