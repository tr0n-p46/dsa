import java.util.*;

public class KSmallest {

    class MinHeap {
        int heap[];
        int size;
        int maxSize;

        public MinHeap(int arr[]) {
            maxSize = size = arr.length;
            heap = new int[maxSize];
            for(int i = 0;i < size;i++) heap[i] = arr[i];
            buildHeap();
        }

        private int left(int i) {
            return (i << 1) + 1;
        }

        private int right(int i) {
            return (i << 1) + 2;
        }

        private int root(int i) {
            return i >> 1;
        }

        private void buildHeap() {
            for(int i = size>>1;i >= 0;i--) {
                minHeapify(i);
            }
        }

        private int extractMin() {
            int temp = heap[0];
            heap[0] = heap[size - 1];
            --size;
            minHeapify(0);
            return temp;
        }

        private int getSmallest() {
            return heap[0];
        }

        private void minHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int smallest = i;
            if(l < size && heap[l] < heap[smallest]) {
                smallest = l;
            }
            if(r < size && heap[r] < heap[smallest]) {
                smallest = r;
            }
            if(smallest != i) {
                int temp = heap[smallest];
                heap[smallest] = heap[i];
                heap[i] = temp;
                minHeapify(smallest);
            }
        }
    }

    public int getKSmallest(int arr[], int k) {
        MinHeap heap = new MinHeap(arr);
        for(int i = 0;i < k - 1;i++) {
            heap.extractMin();
        }
        return heap.getSmallest();
    }

    public static void main(String[]args) throws Exception {
        int arr[] = {7, 10, 4, 3, 20, 15};
        int k = 1;
        KSmallest kSmallest = new KSmallest();
        System.out.println(kSmallest.getKSmallest(arr, k));
    }
}