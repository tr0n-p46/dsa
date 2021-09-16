import java.util.*;

public class BinarySearch {

    public static int binSearch(int arr[], int l, int r, int x) {
        if(l > r) return -1;
        int mid = l + (r - l) / 2;
        if(arr[mid] == x) return mid;
        else if(arr[mid] < x) return binSearch(arr, mid + 1, r, x);
        else return binSearch(arr, l, mid - 1, x);
    }

    public static void main(String[]args) throws Exception {
        int arr[] = {10, 13, 14};
        int x = 14;
        System.out.println(binSearch(arr, 0, arr.length - 1, x));
    }
}