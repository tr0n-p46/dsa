import java.util.*;

public class PriorityQueue {
    class Node {
        int val;
        int priority;

        public Node(int val, int priority) {
            this.val = val;
            this.priority = priority;
        }

        public String toString() {
            return val + ", " + priority;
        }
    }

    class MaxHeap {
        int capacity;
        Node heap[];
        int size;

        public MaxHeap(int capacity) {
            this.capacity = capacity;
            size = 0;
            heap = new Node[capacity];
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

        private void insert(Node n) {
            if(size == capacity - 1) return;
            heap[size++] = n;
            shiftUp(size - 1);
        }

        private void delete(int i) {
            if(size == 0) return;
            updatePriority(i, getMax().priority + 1);
            extractMax();
        }

        private Node getMax() {
            if(size == 0) return null;
            return heap[0];
        }

        private Node extractMax() {
            if(size == 0) return null;
            Node temp = heap[0];
            swap(0, size - 1);
            --size;
            shiftDown(0);
            return temp;
        }

        private void updatePriority(int i, int p) {
            //heap[i].priority;
            shiftUp(i);
        }

        private void shiftDown(int i) {
            int left = left(i);
            int right = right(i);
            int largest = i;
            if(left < size && heap[left].priority > heap[largest].priority) {
                largest = left;
            }
            if(right < size && heap[right].priority > heap[largest].priority) {
                largest = right;
            }
            if(largest != i) {
                swap(largest, i);
                shiftDown(largest);
            }
        }

        private void shiftUp(int i) {
            while(i != 0 && heap[i].priority > heap[root(i)].priority) {
                swap(root(i), i);
                i = root(i);
            }
        }

        private void swap(int i, int j) {
            Node temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }

    public void start() {
        MaxHeap queue = new MaxHeap(50);
        queue.insert(new Node(100, 10));
        queue.insert(new Node(101, 1));
        queue.insert(new Node(102, 3));
        queue.insert(new Node(103, 8));
        queue.insert(new Node(104, 2));
        queue.insert(new Node(105, 5));
        queue.insert(new Node(106, 6));
        queue.insert(new Node(107, 4));
        queue.insert(new Node(108, 7));
        queue.insert(new Node(109, 9));

        Node n = queue.extractMax();
        System.out.println(n);

        n = queue.extractMax();
        System.out.println(n);

        n = queue.extractMax();
        System.out.println(n);

        queue.insert(new Node(111, 10));
        queue.insert(new Node(112, 9));
        queue.insert(new Node(113, 8));

        n = queue.extractMax();
        System.out.println(n);

        n = queue.extractMax();
        System.out.println(n);

        queue.delete(4);
        queue.delete(5);

        n = queue.extractMax();
        System.out.println(n);
    }

    public static void main(String[]args) {
        PriorityQueue q = new PriorityQueue();
        q.start();
    }
}