import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class ContainDuplicate {
    public static void main(String[] args) {
        
        // create a funtion which will take an array and return true if the array contains duplicate element
        // otherwise return false

        int[] arr = {1,1,1,3,3,4,3,2,4,2};
        // Time complexity O(n^2) which makes it  not a good approch with large array
        System.out.println(containsDuplicate(arr));

        // sorting approch
        // Time complexity O(nlogn) which makes it a good approch with large array
        System.out.println("by sorting approch :"+containsDuplicatebysort(arr));

        // Hashset approch
        // Time complexity O(n) which makes it a very good approch with large array
        System.out.println("by Hashset approch :"+containsDuplicatebyHashset(arr));
    }

    private static String containsDuplicatebyHashset(int[] arr) {

        // using hashset we can check duplicate element in O(n) time complexity
        // we can add element to hashset and if it is already present in hashset then it will return true
        // otherwise false

        HashSet <Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return "true";
            }
            set.add(arr[i]);
        }

        return null;
    }

    private static boolean containsDuplicatebysort(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == arr[i+1]) {
                return true;
            }
        }

        return false;
    }

    private static boolean containsDuplicate(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
