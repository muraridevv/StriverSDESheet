package murari.striver.sdesheet.binarysearch;

public class NthRoot {

    //method to find power of a number
    public static long power(int base, int exp){
        long answer= 1;
        while(exp>0){
            exp--;
            answer*=base;
        }
        return answer;
    }

    public static int NthRoot(int nth, int number){
        if(nth<=0 || number<0)
            return -1;

        int low=1;
        int high=number;
        while (low<=high){
            int mid= low + (high - low)/2;
            long powerValue= power(mid,nth);
            if(powerValue==number) return mid;

            else if(powerValue<number) low= mid+1;
            else high=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Example usage
        int n = 3;
        int m = 29;
//        System.out.println(power(2,3));
        int nthRoot = NthRoot(n, m);
        if (nthRoot != -1) {
            System.out.println("The " + n + "th root of " + m + " is: " + nthRoot);
        } else {
            System.out.println("The " + n + "th root of " + m + " is not an integer.");
        }
    }
}
