import java.util.*;

public class HeapSort {
    class MaxHeap {
        int heap[];
        int capacity;
        int size;

        public MaxHeap(int arr[]) {
            capacity = size = arr.length;
            heap = arr;
            buildHeap();
        }

        private int root(int i) {
            return i >> 1;
        }

        private int left(int i) {
            return (i << 1) + 1;
        }

        private int right(int i) {
            return (i << 1) + 2;
        }

        private void buildHeap() {
            for(int i = capacity >> 1;i >= 0;i--) {
                maxHeapify(i);
            }
        }

        private int getMax() {
            if(size == 0) return -1;
            return heap[0];
        }

        private int extractMax() {
            if(size == 0) return -1;
            int temp = heap[0];
            swap(0, size - 1);
            --size;
            maxHeapify(0);
            return temp;
        }

        private void maxHeapify(int i) {
            int left = left(i);
            int right = right(i);
            int largest = i;
            if(left < size && heap[left] > heap[largest]) {
                largest = left;
            }
            if(right < size && heap[right] > heap[largest]) {
                largest = right;
            }
            if(largest != i) {
                swap(largest, i);
                maxHeapify(largest);
            }
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        private void sort() {
            for(int i = 0;i < capacity;i++) {
                int temp = extractMax();
                heap[capacity - 1 - i] = temp;
            }
        }
    }

    private void sort(int arr[]) {
        MaxHeap heap = new MaxHeap(arr);
        heap.sort();
        for(int i = 0;i < arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[]args) throws Exception {
        int arr[] = {1, 2, 3, 10, 0};
        HeapSort sort = new HeapSort();
        sort.sort(arr);
    }
}