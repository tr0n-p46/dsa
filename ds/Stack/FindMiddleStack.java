public class FindMiddleStack {

    LinkedList list;

    public FindMiddleStack() {
        list = new LinkedList();
    }

    class Node {
        int val;
        Node prev, next;

        public Node(int val) {
            this.val = val;
            prev = next = null;
        }
    }

    class LinkedList {
        Node head, mid;
        int size;

        public LinkedList() {
            head = mid = null;
            size = 0;
        }

        private void insertAtBegin(int val) {
            Node n = new Node(val);
            ++size;
            if(head == null)
                head = mid = n;
            else {
                n.next = head;
                head.prev = n;
                head = n;
                if(size % 2 != 0)
                    mid = mid.prev;
            }
        }

        private int removeFromBegin() {
            if(head == null)
                return Integer.MIN_VALUE;
            int val = head.val;
            --size;
            head = head.next;
            if(head == null)
                mid = null;
            else {
                head.prev.next = null;
                head.prev = null;
            }
            if(size % 2 != 0) {
                mid = mid.next;
            }
            return val;
        }

        private int getMiddle() {
            if(mid == null)
                return Integer.MIN_VALUE;
            else
                return mid.val;
        }

        private void removeMiddle() {
            if(mid == null)
                return;
            --size;
            if(mid == head) {
                head = mid = null;
                return;
            }
            Node p = mid.next;
            mid.prev.next = p;
            if(p != null)
                p.prev = mid.prev;
            mid.next = mid.prev = null;
            if(p != null && size % 2 == 0) {
                mid = p;
            } else if(p == null) {
                mid = head;
            }
        }

        private int getByPos(int k) {
            if(head == null || k < 0)
                return Integer.MIN_VALUE;
            int count = 0;
            Node p = head;
            while(p != null && count < k) {
                ++count;
                p = p.next;
            }
            if(count == k) {
                return p.val;
            }
            return Integer.MIN_VALUE;
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
        list.insertAtBegin(val);
    }

    private int pop() {
        return list.removeFromBegin();
    }

    private boolean empty() {
        return list.size == 0;
    }

    private int top() {
        return list.getByPos(0);
    }

    private int findMiddle() {
        return list.getMiddle();
    }

    private void deleteMiddle() {
        list.removeMiddle();
    }

    private void show() {
        list.show();
    }

    public static void main(String[]args) throws Exception {
        FindMiddleStack s = new FindMiddleStack();
        s.push(1);
        s.push(2);
        System.out.println(s.findMiddle());
        s.deleteMiddle();
        s.show();
        System.out.println(s.findMiddle());
        System.out.println(s.top());
        System.out.println(s.pop());
    }
}