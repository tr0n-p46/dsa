import java.util.*;

public class FenwickTree {

    int tree[];

    public FenwickTree(int arr[]) {
        tree = new int[arr.length + 1];
        for(int i = 1;i < arr.length + 1;i++) {
            update(i, arr[i - 1]);
        }
    }

    private int query(int i) {
        int sum = 0;
        while(i > 0) {
            sum += tree[i];
            i -= (i & -i);
        }
        return sum;
    }

    private int query(int l, int r) {
        return query(r) - query(l - 1);
    }

    private void update(int i, int k) {
        while(i < tree.length) {
            tree[i] += k;
            i += (i & -i);
        }
    }

    private void update(int l, int r, int k) {
        update(l, k);
        update(r + 1, -k);
    }

    public static void main(String[]args) throws Exception {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        FenwickTree tree = new FenwickTree(arr);
        System.out.println(tree.query(7, 9));
        tree.update(8, -2);
        System.out.println(tree.query(7, 9));

    }
}