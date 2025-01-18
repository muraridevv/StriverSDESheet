package com.murari.contest;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result= new ArrayList<>();
        int greatestNumber= Integer.MIN_VALUE;
        for(int candy: candies){
            greatestNumber= Math.max(greatestNumber, candy);
        }

        for(int candy: candies){
            if(extraCandies+ candy>= greatestNumber){
                result.add(true);
            } else result.add(false);
        }
        return result;
    }
}
