package com.murari.contest;

public class StringCompression {
    public int compress(char[] chars) {
        int index = 0; // Pointer for writing into the array
        int i = 0;     // Pointer for reading the array

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count the occurrences of the current character
            while (i < chars.length && chars[i] == currentChar) {
                count++;
                i++;
            }

            // Write the character to the array
            chars[index++] = currentChar;

            // If count > 1, write the digits of the count to the array
            if (count > 1) {
                for (char digit : String.valueOf(count).toCharArray()) {
                    chars[index++] = digit;
                }
            }
        }

        return index; // Return the new length of the array
    }

    public static void main(String[] args) {
        StringCompression obj = new StringCompression();
        char[] charArr1 = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println("New Length: " + obj.compress(charArr1));
        System.out.println("Compressed Array: " + new String(charArr1, 0, obj.compress(charArr1)));

        char[] charArr2 = new char[]{'a'};
        System.out.println("New Length: " + obj.compress(charArr2));
        System.out.println("Compressed Array: " + new String(charArr2, 0, obj.compress(charArr2)));
    }
}
