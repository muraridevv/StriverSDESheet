package murari.striver.sdesheet.bits;

public class BitwiseAddition {

    public int add(int a, int b){
        while (b!= 0){
            int carry= a & b;

            a= a ^ b;

            b= carry<<1;

        }
        return a;
    }

    public static void main(String[] args) {
        BitwiseAddition addition= new BitwiseAddition();
        int a = 5;
        int b = 7;

        int sum = addition.add(a, b);

        System.out.println("Sum of " + a + " and " + b + " is: " + sum);
    }

}
