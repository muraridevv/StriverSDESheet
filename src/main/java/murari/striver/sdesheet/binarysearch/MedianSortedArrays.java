package murari.striver.sdesheet.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class MedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1=nums1.length;
        int n2= nums2.length;

        List<Integer> mergedList= new ArrayList<>();

        // merge the arrays
        int i=0;
        int j=0;
        while (i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                mergedList.add(nums1[i]);
                i++;
            }
            else {
                mergedList.add(nums2[j]);
                j++;
            }
        }

        //copy left out thing
        while (i<n1){
            mergedList.add(nums1[i]);
            i++;
        }
        while ((j<n2)){
            mergedList.add(nums2[j]);
            j++;
        }
        // find the median
        if((n1+n2)%2==1)
            return mergedList.get((n1+n2)/2);

        return (mergedList.get((n1+n2)/2)+ mergedList.get((n1+n2)/2-1))/2.0;
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums1 = {1, 4, 7, 10, 12};
        int[] nums2 = {2, 3, 6, 15};

        MedianSortedArrays main = new MedianSortedArrays();
        double median = main.findMedianSortedArrays(nums1, nums2);

        System.out.println("Median: " + median);
    }
}
