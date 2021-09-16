import java.util.*;

public class QuickSelect {
    public static int partition(int arr[], int l, int r) {
        int x = arr[r];
        int i = l - 1;
        for(int j = l;j <= r - 1;j++) {
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
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static int getKSmallest(int arr[], int l, int r, int k) {
        if(k > 0 && k <= r - l + 1) {
            int pos = partition(arr, l, r);
            System.out.println();
            if(pos - l == k - 1)
                return arr[pos];
            else if(pos - l < k - 1)
                return getKSmallest(arr, pos + 1, r, k - pos + l - 1);
            else return getKSmallest(arr, l, pos - 1, k);
        }
        return -1;
    }

    public static void main(String[]args) throws Exception {
        int arr[] = {7, 10, 4, 3, 20, 15};
        int k = 6;
        System.out.println(getKSmallest(arr, 0, arr.length - 1, k));
    }
}