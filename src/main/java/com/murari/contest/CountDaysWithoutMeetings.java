package com.murari.contest;

public class CountDaysWithoutMeetings {

    public int countDaysBruteForce(int days, int[][] meetings) {
        boolean[] daysCounted= new boolean[days];

        for(int[] day: meetings){
            for(int i= day[0]; i<day[1];i++){
                daysCounted[i-1]=true;
            }
        }

        int count=0;
        for(boolean dayIncluded: daysCounted){
            if(!dayIncluded) count++;
        }
        return count;
    }

    public int countDays(int days, int[][] meetings) {
//        Arrays.sort(meetings, (a));
        return 0;
    }

    public static void main(String[] args) {
        CountDaysWithoutMeetings solution = new CountDaysWithoutMeetings();

        // Example 1
        int days1 = 10;
        int[][] meetings1 = {{1, 2}, {4, 5}, {6, 7}, {8, 10}};
        int result1 = solution.countDays(days1, meetings1);
        System.out.println("Number of days not covered by meetings: " + result1);  // Output should be 3 (Days 3, 6, 7, 8, and 9)

        // Example 2
        int days2 = 10;
        int[][] meetings2 = {{1, 2}, {3, 5}, {6, 8}};
        int result2 = solution.countDays(days2, meetings2);
        System.out.println("Number of days not covered by meetings: " + result2);  // Output should be 2 (Days 9 and 10)
    }
}
