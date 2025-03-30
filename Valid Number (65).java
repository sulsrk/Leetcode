class Solution {

    public boolean isNumber(String s) {
        if (s.length() == 0) return false;
        int ind = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;
        if (ind >= s.length() || s.charAt(ind) == 'e' || s.charAt(ind) == 'E') return false;

        while (ind < s.length()){
            char chr = s.charAt(ind++);
            if (chr < '0' || chr > '9'){
                
                if (chr == '.'){
                    return getDot(s,ind);
                } else if (chr == 'e' || chr == 'E'){
                    return getExp(s, ind);
                } else {
                    return false;
                }

            }
        }
        return true;
    }

    private boolean getExp(String s, int ind){
        if (ind >= s.length()) return false;
        ind += (s.charAt(ind) == '+' || s.charAt(ind) == '-') ? 1 : 0;
        if (ind >= s.length()) return false;

        while (ind < s.length()){
            char chr = s.charAt(ind++);
            if (chr < '0' || chr > '9') return false;
        }
        return true;
    }

    private boolean getDot(String s, int ind){
        if (ind <= 2 && (s.charAt(0) < '0' || s.charAt(0) > '9')){
            if (ind >= s.length() || s.charAt(ind) < '0' || s.charAt(ind) > '9') return false;
        }
        while (ind < s.length()){
            char chr = s.charAt(ind++);
            if (chr == 'e' || chr == 'E'){
                return getExp(s, ind);
            } else if (chr < '0' || chr > '9'){
                return false;
            }
        }
        return true;
    }
}
