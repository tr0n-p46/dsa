import java.util.Stack;

public class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(int val, boolean flag) {
        this.head = null;
        while(val != 0) {
            if(!flag)
                insertAtEnd(val % 10);
            else
                insertAtBegin(val % 10);
            val /= 10;
        }
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private void insertAtEnd(int data) {
        Node n = new Node(data);
        if(head == null)
            head = n;
        else {
            Node p = head;
            while(p.next != null) {
                p = p.next;
            }
            p.next = n;
        }
    }

    private void insertAtBegin(int data) {
        Node n = new Node(data);
        if(head == null)
            head = n;
        else {
            n.next = head;
            head = n;
        }
    }

    private void insertAfterNode(Node prev, int data) {
        if(prev == null || head == null)
            return;
        Node n = new Node(data);
        n.next = prev.next;
        prev.next = n;

    }

    private boolean find(int data) {
        Node p = head;
        while(p != null) {
            if(p.data == data)
                return true;
            p = p.next;
        }
        return false;
    }

    private void deleteAtBegin() {
        if(head == null)
            return;
        Node p = head;
        head = p.next;
        p.next = null;
    }

    private void deleteAtEnd() {
        if(head == null)
            return;
        else if(head.next == null)
            head = null;
        else {
            Node p = head;
            while(p.next.next != null) {
                p = p.next;
            }
            p.next = null;
        }
    }

    private void deleteAfterNode(Node prev) {
        if(prev == null || head == null)
            return;
        else if(head.next == null || prev.next == null)
            return;
        else {
            Node p = prev.next;
            prev.next = p.next;
            p.next = null;
        }
    }

    private void deleteFirstOccurance(int data) {
        if(head == null)
            return;
        if(head.next == null && head.data == data) {
            head = null;
            return;
        }
        Node p = head;
        while(p.next != null && p.next.data != data) {
            p = p.next;
        }
        if(p.next != null && p.next.data == data) {
            Node m = p.next;
            p.next = m.next;
            m.next = null;
        }
    }

    private void deleteAllOccurance(int data) {
        if(head == null)
            return;
        if(head.next == null && head.data == data) {
            head= null;
            return;
        }
        Node p = head;
        while(p.next != null) {
            if(p.next.data == data) {
                Node m = p.next;
                p.next = m.next;
                m.next = null;
            } else
                p = p.next;

        }
        if(p.next != null && p.next.data == data)
            p.next = null;
    }

    private void deleteAtPos(int pos) {
        if(head == null || pos < 0)
            return;
        if(pos == 0) {
            Node m = head;
            head = head.next;
            m.next = null;
            return;
        }
        int count = 0;
        Node p = head;
        while(p.next != null) {
            if(count + 1 == pos) {
                Node m = p.next;
                p.next = m.next;
                m.next = null;
                return;
            }
            ++count;
            p = p.next;
        }
    }

    private void swap(int data1, int data2) {
        if(head == null)
            return;
        if(head.next == null)
            return;
        Node first = null, p = head, second = null;
        int foundFirst = -1, foundSecond = -1, count = 0;
        if(p.data == data1) {
            foundFirst++;
        } else if(p.data == data2) {
            foundSecond++;
        }
        while(p.next != null) {
            if(p.next.data == data1) {
                first = p;
                foundFirst = count;
            }
            else if(p.next.data == data2) {
                second = p;
                foundSecond = count;
            }
            if(foundFirst >= 0 && foundSecond >= 0) {
                if(foundFirst >= foundSecond) {
                    Node t = first;
                    first = second;
                    second = t;
                }
                Node p1 = (first == null)?head:first.next;
                Node p2 = second.next;
                Node p3 = p1.next;

                if(first != null)
                    first.next = p2;
                else
                    head = p2;
                if(p1 != second)
                    second.next = p1;
                else
                    second.next = p2.next;
                p1.next = p2.next;
                if(p1 != second)
                    p2.next = p3;
                else
                    p2.next = p1;
                return;
            }
            p = p.next;
            ++count;
        }
    }

    private void reverse() {
        if(head == null || head.next == null)
            return;
        Node m = null, p = head, t = p.next;
        while(t.next != null) {
            p.next = m;
            m = p;
            p = t;
            t = t.next;
        }
        p.next = m;
        t.next = p;
        head = t;
    }

    private Node merge(Node head1, Node head2) {
        Node head = new Node(0);
        Node p = head;
        while(head1 != null && head2 != null) {
            if(head1.data < head2.data) {
                p.next = head1;
                head1 = head1.next;
                p.next.next = null;
            } else {
                p.next = head2;
                head2 = head2.next;
                p.next.next = null;
            }
            p = p.next;
        }
        if(head1 != null)
            p.next = head1;
        else if(head2 != null)
            p.next = head2;
        return head.next;
    }

    private Node split(Node head) {
        if(head == null || head.next == null)
            return head;
        if(head.next.next == null) {
            Node p = head.next;
            head.next = null;
            return p;
        }
        Node pSlow = head, pFast = pSlow.next.next;
        while(pFast != null && pFast.next != null) {
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }
        Node p = pSlow;
        pSlow = pSlow.next;
        p.next = null;
        return pSlow;
    }

    private Node sort(Node head) {
        if(head == null || head.next == null)
            return head;
        Node mid = split(head);
        Node left = sort(head);
        Node right = sort(mid);
        return merge(left, right);
    }

    private LinkedList add(LinkedList l) {
        LinkedList res = new LinkedList();
        int carry = 0;
        Node p1 = this.head;
        Node p2 = l.head;
        while(p1 != null && p2 != null) {
            int val = p1.data + p2.data + carry;
            int sum = val % 10;
            carry = val /= 10;
            res.insertAtEnd(sum);
            p1 = p1.next;
            p2 = p2.next;
        }
        while(p1 != null) {
            int val = p1.data + carry;
            int sum = val % 10;
            carry = val /= 10;
            res.insertAtEnd(sum);
            p1 = p1.next;
        }
        while(p2 != null) {
            int val = p2.data + carry;
            int sum = val % 10;
            carry = val /= 10;
            res.insertAtEnd(sum);
            p2 = p2.next;
        }
        return res;
    }

    private LinkedList reverseAdd(LinkedList l) {
        LinkedList res = new LinkedList();
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        Node p1 = this.head, p2 = l.head;
        while(p1 != null) {
            a.push(p1.data);
            p1 = p1.next;
        }
        while(p2 != null) {
            b.push(p2.data);
            p2 = p2.next;
        }
        int carry = 0;
        while(!a.empty() && !b.empty()) {
            int val1 = a.pop(), val2 = b.pop();
            int val = val1 + val2 + carry;
            int sum = val % 10;
            carry = val / 10;
            res.insertAtBegin(sum);
        }
        while(!a.empty()) {
            int val = a.pop() + carry;
            int sum = val % 10;
            carry = val / 10;
            res.insertAtBegin(sum);
        }
        while(!b.empty()) {
            int val = b.pop() + carry;
            int sum = val % 10;
            carry = val / 10;
            res.insertAtBegin(sum);
        }
        return res;
    }

    private Node splitByK(Node head, int k) {
        int count = 0;
        Node p = head;
        while(p != null && count != k - 1) {
            ++count;
            p = p.next;
        }
        if(count != k - 1)
            return null;
        Node temp = p.next;
        p.next = null;
        return temp;
    }

    private void rotate(int k) {
        if(k == 0)
            return;
        Node pos = splitByK(this.head, k);
        if(pos == null)
            return;
        Node p = pos;
        while(p.next != null) {
            p = p.next;
        }
        p.next = this.head;
        this.head = pos;
    }

    private boolean detectAndRemoveLoop() {
        if(head == null || head.next == null)
            return false;
        if(head.next == head) {
            head.next = null;
            return true;
        }
        Node pSlow = this.head, pFast = this.head.next;
        boolean loopFound = false;
        while(pFast != null && pFast.next != null) {
            pSlow = pSlow.next;
            pFast = pFast.next.next;
            if(pSlow == pFast) {
                loopFound = true;
                System.out.println(pSlow.data);
                break;
            }
        }
        if(loopFound) {
            pSlow = head;
            while(pSlow != pFast.next) {
                pSlow = pSlow.next;
                pFast = pFast.next;
            }
            pFast.next = null;
            return true;
        }
        return false;
    }

    private void reverseByGroup(int k) {
        if(k < 2 || head == null || head.next == null)
            return;
        Node p = head;
        while(p != null) {

        }
    }

    private void printList() {
        if(head == null)
            return;
        Node p = head;
        while(p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private int getCount() {
        int count = 0;
        Node p = head;
        while(p != null) {
            ++count;
            p = p.next;
        }
        return count;
    }

    private void fromArray(int arr[]) {
        for(int i = 0;i < arr.length;i++) {
            insertAtEnd(arr[i]);
        }
    }

    public static void main(String []args) throws Exception {
//         LinkedList llist = new LinkedList();
//         llist.insertAtEnd(0);
//         llist.insertAtEnd(1);
//         llist.insertAtEnd(2);
//         llist.insertAtEnd(3);
//         llist.insertAtEnd(4);
//         llist.insertAtEnd(5);
//         llist.insertAtEnd(6);
//         llist.insertAtEnd(7);
//         llist.printList();
//
//         llist.insertAtBegin(22);
//         llist.insertAtBegin(99);
//         llist.insertAtBegin(17);
//         llist.printList();
//
//         llist.insertAfterNode(llist.head.next, 9);
//         llist.insertAfterNode(llist.head.next, 7);
//         llist.printList();
//
//         System.out.println(llist.find(-1));
//
//         llist.insertAtEnd(5);
//         llist.insertAtEnd(5);
//         llist.insertAtEnd(5);
//         llist.insertAtEnd(5);
//         llist.insertAtEnd(5);
//
//         llist.printList();
//         llist.deleteAtEnd();
//         llist.deleteAtEnd();
//         llist.deleteAtEnd();
//         llist.printList();
//         llist.deleteAtPos(0);
//         llist.printList();
//         System.out.println(llist.getCount());
//         llist.swap(7, 0);
//         llist.printList();
//         llist.reverse();
//         llist.printList();
//
//         LinkedList list1 = new LinkedList();
//         LinkedList list2 = new LinkedList();
//         list1.insertAtEnd(1);
//         list1.insertAtEnd(3);
//         list1.insertAtEnd(7);
//         list1.insertAtEnd(9);
//
//         list2.insertAtEnd(1);
//         list2.insertAtEnd(3);
//         list2.insertAtEnd(7);
//         list2.insertAtEnd(9);
//         list2.insertAtEnd(14);
//         list2.insertAtEnd(16);
//         list2.insertAtEnd(19);
//
//         list1.printList();
//         list2.printList();
//
//         LinkedList list = new LinkedList();
//         list.head = llist.merge(list1.head, list2.head);
//         list.printList();

//             LinkedList list = new LinkedList();
//             int arr[] = {0, 1, 2, -1, -2, -5, -3, 8};
//             list.fromArray(arr);
//             list.printList();
//             list.head = list.sort(list.head);
//             list.printList();
//             LinkedList l1 = new LinkedList(1, true);
//             l1.printList();
//             LinkedList l2 = new LinkedList(12, true);
//             l2.printList();
//             LinkedList res = l1.reverseAdd(l2);
//             res.printList();
//         LinkedList list = new LinkedList();
//         int arr[] = {10, 20, 30, 40, 50, 60, 70, 80, 90};
//         list.fromArray(arr);
//         list.rotate(1);
//         list.printList();
            LinkedList list = new LinkedList();
            int arr[] = {10, 20, 30};
            list.fromArray(arr);
            //list.printList();
            System.out.println(list.detectAndRemoveLoop());
            list.printList();
    }
}