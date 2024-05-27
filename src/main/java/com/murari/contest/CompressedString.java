package com.murari.contest;

public class CompressedString {

    public static String compressedString(String word) {
        StringBuilder comp=new StringBuilder();

        for(int i=0; i< word.length();){
            Character currentChar= word.charAt(i);
            int count=0;

            while (i< word.length() && count<9 && currentChar== word.charAt(i)){
                count++;
                i++;
            }
            comp.append(count).append(currentChar);
        }

        return comp.toString();
    }

    public static void main(String[] args) {
        String word="aaaaaaaaaaaaaabb";
        System.out.println(compressedString(word));
    }
}
