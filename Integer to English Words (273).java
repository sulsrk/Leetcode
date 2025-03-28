class Solution {
    final String[] basic = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight",
    "Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen",
    "Eighteen","Nineteen"};
    final String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy",
    "Eighty", "Ninety"};
    final String[] orders = {"Thousand","Million","Billion"};

    // public Solution(){
    //     basic = new HashMap<Integer,String>();
    //     basic.put(1,"One");
    //     basic.put(2,"Two");
    //     basic.put(3,"Three");
    //     basic.put(4,"Four");
    //     basic.put(5,"Five");
    //     basic.put(6,"Six");
    //     basic.put(7,"Seven");
    //     basic.put(8,"Eight");
    //     basic.put(9,"Nine");
    //     basic.put(10,"Ten");
    //     basic.put(11,"Eleven");
    //     basic.put(12,"Twelve");
    //     basic.put(13,"Thirteen");
    //     basic.put(15,"Fifteen");
    //     basic.put(18,"Eighteen");
    //     basic.put(20,"Twenty");
    //     basic.put(30,"Thirty");
    //     basic.put(40,"Forty");
    //     basic.put(50,"Fifty");
    //     basic.put(80,"Eighty");
    // }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        // return get(num);
        StringBuilder word = new StringBuilder();

        for (int o = 3; o > 0; o--){
            int pow = (int) Math.pow(10, 3*o);
            if (num >= pow){
                word.append(hGet(num / pow));
                word.append(" ");
                word.append(orders[o-1]);
                num %= pow;
                if (num != 0) word.append(" ");
            }
        }
        if (num != 0) word.append(hGet(num));

        return word.toString();
    }

    private String hGet(int n){
        if (n < 20) return basic[n];

        StringBuilder temp = new StringBuilder();

        if (n < 100){
            temp.append(tens[n/10]); 
            if (n%10 != 0){
                temp.append(" ");
                temp.append(basic[n%10]);
            }
        } else if (n < 1000){
            temp.append(basic[n/100]);
            temp.append(" Hundred");
            if (n%100 != 0){
                temp.append(" ");
                temp.append(hGet(n%100));
            }
        }
        return temp.toString();
    }

//     private String get(int n){
//         if (basic.containsKey(n)) return basic.get(n);

//         StringBuilder temp = new StringBuilder();

//         if (n < 20){
//             temp.append(basic.get(n%10));
//             temp.append("teen");
//         } else if (n < 100){
//             if (basic.containsKey(n - n%10)){
//                 temp.append(basic.get(n - n%10));
//                 temp.append(" ");
//                 temp.append(get(n%10));
//             } else {
//                 temp.append(basic.get(n/10));
                
//                 if (n % 10 == 0) {
//                     temp.append("ty");
//                 } else {
//                     temp.append("ty ");
//                     temp.append(get(n%10));
//                 }
//             }
//         } else if (n < 1000){
//             temp.append(basic.get(n/100));
//             if (n % 100 == 0) {
//                 temp.append(" Hundred");
//             } else {
//                 temp.append(" Hundred ");
//                 temp.append(get(n%100));
//             }
//         } else if (n < 1000000){
//             temp.append(get(n/1000));
//             if (n % 1000 == 0) {
//                 temp.append(" Thousand");
//             } else {
//                 temp.append(" Thousand ");
//                 temp.append(get(n%1000));
//             }
//         } else if (n < 1000000000){
//             temp.append(get(n/1000000));
//             if (n % 1000000 == 0) {
//                 temp.append(" Million");
//             } else {
//                 temp.append(" Million ");
//                 temp.append(get(n%1000000));
//             }
//         } else {
//             temp.append(get(n/1000000000));
//             if (n % 1000000000 == 0) {
//                 temp.append(" Billion");
//             } else {
//                 temp.append(" Billion ");
//                 temp.append(get(n%1000000000));
//             }
//         }

//         return temp.toString();
//     }
}
