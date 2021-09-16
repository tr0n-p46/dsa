public class MinStack {
    LinkedList list;
    int min;

    public MinStack() {
        list = new LinkedList();
        min = Integer.MIN_VALUE;
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            next = null;
        }
    }

    class LinkedList {
        Node head;
        int size;

        public LinkedList() {
            head = null;
            size = 0;
        }

        private void insertAtBegin(int val) {
            Node n = new Node(val);
            ++size;
            if(head == null)
                head = n;
            else {
                n.next = head;
                head = n;
            }
        }

        private int removeFromBegin() {
            if(head == null)
                return Integer.MAX_VALUE;
            --size;
            Node p = head;
            head = head.next;
            p.next = null;
            return p.val;
        }

        private int getByPos(int k) {
            if(head == null || k < 0)
                return Integer.MAX_VALUE;
            Node p = head;
            int count = 0;
            while(p != null && count != k) {
                ++count;
                p = p.next;
            }
            if(count == k)
                return p.val;
            else
                return Integer.MAX_VALUE;
        }

        private void show() {
            Node p = head;
            while(p != null) {
                System.out.print(p.val + " ");
                p = p.next;
            }
            System.out.println();
        }
    }

    private void push(int val) {
        if(empty())
            min = val;
        if(val >= min)
            list.insertAtBegin(val);
        else {
            list.insertAtBegin(2 * val - min);
            min = val;
        }
    }

    private int pop() {
        int val = Integer.MAX_VALUE;
        if(!empty()) {
            val = list.removeFromBegin();
            if(val < min) {
                min = 2 * min - val;
            }
        }
        return val;
    }

    private int top() {
        return list.getByPos(0);
    }

    private int getMin() {
        return min;
    }

    private boolean empty() {
        return list.size == 0;
    }

    private void show() {
        list.show();
    }

    public static void main(String[]args) throws Exception {
        MinStack s = new MinStack();
        s.push(18);
        s.push(19);
        s.push(29);
        s.push(15);
        s.push(16);
        s.show();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
    }
}