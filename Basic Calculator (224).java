import java.util.Stack;

class Solution {
    int index = 0;

    public int calculate(String s) {
        return evaluate(s);
    }

    private int evaluate (String s){
        int sign = 1;
        int sum = 0;
        int num = 0;
        
        while (index < s.length()){
            char curr = s.charAt(index++);
            switch (curr){
                case(' '):
                    continue;
                case ('('):
                    num = evaluate(s);
                    break;
                case (')'):
                    return (sum + num * sign);
                case ('+'):
                    sum += num*sign;
                    num = 0;
                    sign = 1;
                    break;
                case ('-'):
                    sum += num*sign;
                    num = 0;
                    sign = -1;
                    break;
                default:
                    num = (num*10) + ((int) curr - '0');
            }
        }
        return sum += num*sign;
    }
}

class Last{
    int val;
    boolean sub;

    public Last(int val, boolean sub){
        this.val = val;
        this.sub = sub;
    }
}
