package murari.striver.sdesheet.greedy;

import java.util.*;

class Meeting{
    int start;
    int end;
    int position;

    Meeting(int start, int end, int position){
        this.start=start;
        this.end = end;
        this.position = position;
    }
}




public class MaxNoOfMeeting {

    static void maxMeetings(int[] start, int[] end, int n){

        //store meeting in arrayList
        List<Meeting> meetingList= new ArrayList<>();
        for(int i=0;i<n;i++){
            meetingList.add(new Meeting(start[i], end[i],i+1));
        }

        //sort meeting based on end time using custom operator
        meetingList.sort(Comparator.comparingInt((Meeting m) -> m.end).
                thenComparingInt(m -> m.position));


        //store the order of meeting to be performed
        List<Integer> answer= new ArrayList<>();
        answer.add(meetingList.get(0).position);
        int limit= meetingList.get(0).end;

        for (Meeting meeting : meetingList) {
            if (meeting.start > limit) {
                limit = meeting.end;
                answer.add(meeting.position);
            }
        }

        System.out.println("The order in which the meetings will be performed is:");
        for(int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }




    // Main method to test the maxMeetings function
    public static void main(String args[]) {
        int n = 6; // Number of meetings
        int start[] = {3, 0, 5, 8, 5, 1}; // Start times of meetings
        int end[] = {4, 5, 7, 9, 9, 2}; // End times of meetings


        maxMeetings(start, end, n);

    }
}
