package murari.striver.sdesheet.arrayspart2;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] prefix= new int[n];
        int[] suffix= new int[n];
        int[] result= new int[n];

        //calculate the prefix product. ie. product of num before current element
        prefix[0]=1;
        for(int i=1; i<n; i++){
            prefix[i]= nums[i-1]* prefix[i-1];
        }

        //calculate the suffix product. ie. product of num after current element
        suffix[n-1]=1;
        for(int i=n-2; i>=0; i--){
            suffix[i]= nums[i+1]* suffix[i+1];
        }

        for(int i=0; i< n; i++){
            result[i]= prefix[i]* suffix[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductExceptSelf product= new ProductExceptSelf();
        int[] nums= new int[]{1,2,3,4};
        int[] productExceptSelf= product.productExceptSelf(nums);
        for(int num: productExceptSelf){
            System.out.print(num+" ");
        }
    }
}
