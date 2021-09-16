import java.util.*;

public class QuickSort {

    public static int partition(int arr[], int l, int r) {
        int i = l - 1;
        int x = arr[r];
        for(int j = l;j < r;j++) {
            if(arr[j] < x) {
                ++i;
                swap(arr, i, j);
            }
        }
        ++i;
        swap(arr, i, r);
        return i;
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int arr[], int l, int r) {
        if(l < r) {
            int pos = partition(arr, l, r);
            quickSort(arr, l, pos - 1);
            quickSort(arr, pos + 1, r);
        }
    }

    public static void main(String[]args) throws Exception {
        int arr[] = {10};
        quickSort(arr, 0, arr.length - 1);
        for(int i = 0;i < arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}