import java.util.*;

public class MaxHeap {
    int heap[];
    int capacity;
    int size;

    public MaxHeap(int arr[]) {
        capacity = size = arr.length;
        heap = new int[capacity];
        for(int i = 0;i < capacity;i++) {
            heap[i] = arr[i];
        }
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
        for(int i = capacity>>1;i >= 0;i--) {
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
        heap[0] = heap[size - 1];
        --size;
        maxHeapify(0);
        return temp;
    }

    private void increaseKey(int i, int k) {
        heap[i] += k;
        while(i != 0 && heap[root(i)] < heap[i]) {
            swap(root(i), i);
            i = root(i);
        }
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

    public static void main(String[]args) throws Exception {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MaxHeap heap = new MaxHeap(arr);
        for(int i = 0;i < arr.length;i++) {
            System.out.println(heap.extractMax());
        }
        System.out.println(heap.extractMax());
    }
}