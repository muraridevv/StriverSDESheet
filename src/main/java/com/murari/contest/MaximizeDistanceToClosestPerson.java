package com.murari.contest;

public class MaximizeDistanceToClosestPerson {
  public int maxDistToClosest(int[] seats) {
    int maxDist = 0;
    int i = 0;
    while (i < seats.length && seats[i] == 0) {
      i++;
    }
    maxDist = i;

    // for mid element
    int prev = i;
    for (; i < seats.length; i++) {
      if (seats[i] == 1) {
        int dist = (i - prev) / 2;
        maxDist = Math.max(maxDist, dist);
        prev = i;
      }
    }

    // for trailing
    int trailingZeroes = 0;
    for (i = seats.length - 1; seats[i] == 0; i--) {
      trailingZeroes++;
    }
    maxDist = Math.max(maxDist, trailingZeroes);
    return maxDist;
  }

  public static void main(String[] args) {
    MaximizeDistanceToClosestPerson obj = new MaximizeDistanceToClosestPerson();
    int[] seats1 = new int[] {1, 0, 0, 0, 1, 0, 1};
    System.out.println(obj.maxDistToClosest(seats1));
  }
}
