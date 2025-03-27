class Solution {

    public int countDigitOne(int n) {
        int place = 1;
        int sum = 0;
        while (place <= n) {
            int next = place * 10;
            // Get the remainder if the digit is format is between x10 <= n < x20
            int rem = ((n % next) < 2 * place && (n % next) >= place) ? n % place + 1: 0;
          // Get the times the nth digit 'repeats' as a set of 10 and sum this with rem
            sum += (n + 8*place) / next * place + rem;

            place = next;
        }
        return sum;
    }

    // private int digits(int n, int place){
    //     if (place > n) return 0;

    //     int next = place * 10;
    //     int temp = (n + 8*place) / next * place;
    //     int rem = ((n % next) < 2 * place && (n % next) >= place) ? n % place + 1: 0;

    //     return temp  + rem + digits(n, next);
    // }

    // private int nDigitsO(int n){
    //     if (n <= 1) return 1;

    //     return (n*pow(9,n-1));
    // }

    // private int pow(int base, int exp){
    //     int total = 1;
    //     while (exp > 0){
    //         if ((exp & 1) == 1){
    //             total *= base;
    //         }
    //         base *= base;
    //         exp >>= 1;
    //     }
    //     return total;
    // }
}
