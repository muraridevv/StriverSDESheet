package murari.striver.sdesheet.arrays;

import java.util.Arrays;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int minPrice=Integer.MAX_VALUE;

        for(int i=0;i<prices.length;i++){
            minPrice=Math.min(prices[i],minPrice);
            maxProfit=Math.max(prices[i]-minPrice,maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int [] list=new int[]{7,1,5,3,6,4};
        MaxProfit obj1=new MaxProfit();
        System.out.println(obj1.maxProfit(list));

    }
}
