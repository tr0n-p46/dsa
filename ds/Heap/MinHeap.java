import java.util.*;

public class MinHeap {
    int heap[];
    int capacity;
    int size;

    public MinHeap(int arr[]) {
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
            minHeapify(i);
        }
    }

    private int getMin() {
        if(size == 0) return -1;
        return heap[0];
    }

    private int extractMin() {
        if(size == 0) return -1;
        int temp = heap[0];
        heap[0] = heap[size - 1];
        --size;
        minHeapify(0);
        return temp;
    }

    private void decreaseKey(int i, int k) {
        heap[i] -= k;
        while(i != 0 && heap[root(i)] > heap[i]) {
            swap(root(i), i);
            i = root(i);
        }
    }

    private void minHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest = i;
        if(left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if(right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if(smallest != i) {
            swap(smallest, i);
            minHeapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[]args) throws Exception {
        int arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        MinHeap heap = new MinHeap(arr);
        for(int i = 0;i < arr.length;i++) {
            System.out.println(heap.extractMin());
        }
        System.out.println(heap.extractMin());
    }
}