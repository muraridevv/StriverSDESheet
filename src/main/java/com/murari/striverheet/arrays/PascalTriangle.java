package com.murari.striverheet.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> tempResult,previous=null;
        for(int i=0;i<numRows;i++){
            tempResult=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i) tempResult.add(1);
                else{
                    tempResult.add(previous.get(j-1)+previous.get(j));
                }
            }
            previous=tempResult;

            result.add(tempResult);
        }
        return result;
    }

}
