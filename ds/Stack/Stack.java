public class Stack {

    LinkedList list;
    int size;

    public Stack() {
        list = new LinkedList();
        size = 0;
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

        public LinkedList() {
            head = null;
        }

        private void insertAtBegin(int val) {
            Node n = new Node(val);
            if(head == null)
                head = n;
            else {
                n.next = head;
                head = n;
            }
            ++size;
        }

        private int removeFromBegin() {
            if(head == null)
                return Integer.MIN_VALUE;
            Node p = head;
            head = head.next;
            --size;
            p.next = null;
            return p.val;
        }

        private int getByPos(int k) {
            if(k < 0 || head == null)
                return Integer.MIN_VALUE;
            Node p = head;
            int count = 0;
            while(p != null && count != k) {
                ++count;
                p = p.next;
            }
            if(count == k)
                return p.val;
            return Integer.MIN_VALUE;
        }
    }

    private int size() {
        return this.size;
    }

    private void push(int val) {
        list.insertAtBegin(val);
    }

    private int pop() {
        return list.removeFromBegin();
    }

    private int top() {
        return list.getByPos(0);
    }

    private boolean empty() {
        return size() == 0;
    }


    public static void main(String[]args) throws Exception {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);

        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.top());

        s.push(9);
        System.out.println(s.pop());
        System.out.println(s.top());

        s.push(10);
        s.push(11);
        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.top());
    }
}