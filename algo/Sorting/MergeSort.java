import java.util.*;

public class MergeSort {

    public static void merge(int arr[], int l, int mid, int r) {
        int NL = mid - l + 1;
        int NR = r - mid;
        int L[] = new int[NL];
        int R[] = new int[NR];
        for(int i = 0;i < NL;i++)
            L[i] = arr[l + i];
        for(int i = 0;i < NR;i++)
            R[i] = arr[mid + 1 + i];
        int i = 0, j = 0, k = l;
        while(i < NL && j < NR) {
            if(L[i] < R[j])
                arr[k] = L[i++];
            else
                arr[k] = R[j++];
            ++k;
        }
        while(i < NL)
            arr[k++] = L[i++];
        while(j < NR)
            arr[k++] = R[j++];
    }

    public static void mergeSort(int arr[], int l, int r) {
        if(l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void main(String[]args) throws Exception {
        int arr[] = {1, 10, 1};
        mergeSort(arr, 0, arr.length - 1);
        for(int i = 0;i < arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}