package com.murari.contest;

public class MinimumChair {
    public int minimumChairs(String s) {
        int minimumChair=0;
        int count=0;
        for(char ch: s.toCharArray()){
            if(ch=='E') count++;
            else if(ch=='L') count--;
            minimumChair=Math.max(count,minimumChair);
        }
        return minimumChair;
    }
}
