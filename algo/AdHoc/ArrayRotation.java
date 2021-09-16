public class ArrayRotation {
    public static void rotateByOne(int arr[], int n) {
        int x = arr[0];
        for(int i = 1;i < n;i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = x;
    }

    public static void rotate(int arr[], int d, int n) {
        for(int i = 0;i < d;i++) {
            rotateByOne(arr, n);
        }
    }

    public static void main(String[]args) throws Exception {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int d = 2, n = arr.length;
        rotate(arr, d, n);
        for(int i = 0;i < n;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}