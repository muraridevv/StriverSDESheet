package com.murari.striverheet.string;

public class RomanToInteger {
    public static int romanToInt(String s) {
        int result=0;
        for(int i=0; i<s.length();i++){
            switch (s.charAt(i)) {
                case 'I' -> result += 1;
                case 'V' -> result += 5;
                case 'X' -> result += 10;
                case 'L' -> result += 50;
                case 'C' -> result += 100;
                case 'D' -> result += 500;
                case 'M' -> result += 1000;
            }
        }

        if(s.contains("IV")) result-=2;
        if(s.contains("IX")) result-=2;
        if(s.contains("XL")) result-=20;
        if(s.contains("XC")) result-=20;
        if(s.contains("CD")) result-=200;
        if(s.contains("CM")) result-=200;
        return result;
    }

    public static void main(String[] args) {
        String roman= "XIX";
        System.out.println(romanToInt(roman));
    }
}
