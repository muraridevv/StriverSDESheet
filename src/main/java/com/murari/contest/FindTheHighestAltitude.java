package com.murari.contest;

public class FindTheHighestAltitude {
  public int largestAltitude(int[] gain) {
    int maxAltitude = 0;
    int currentAltitude = 0;
    for (int j : gain) {
      currentAltitude += j;
      maxAltitude = Math.max(currentAltitude, maxAltitude);
    }
    return maxAltitude;
  }

  public static void main(String[] args) {
    FindTheHighestAltitude obj = new FindTheHighestAltitude();
    //        int[] gain= new int[]{-5,1,5,0,-7};
    int[] gain = new int[] {-4, -3, -2, -1, 4, 3, 2};
    System.out.println(obj.largestAltitude(gain));
  }
}
