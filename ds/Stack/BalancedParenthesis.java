public class BalancedParenthesis {

    class Stack {
        int data[];
        int capacity;
        int size;

        public Stack(int capacity) {
            this.capacity = capacity;
            data = new int[capacity];
            size = 0;
        }

        private void push(int val) {
            if(size == capacity)
                return;
            data[size++] = val;
        }

        private int pop() {
            return data[size--];
        }

        private int top() {
            if(empty())
                return -1;
            return data[size - 1];
        }

        private boolean empty() {
            return size == 0;
        }
    }

    private boolean checkBalanced(String exp) {
        if(exp == null || exp.length() == 0 || exp.length() % 2 != 0)
            return false;
        Stack s = new Stack(exp.length());
        for(int i = 0;i < exp.length();i++) {
            char c = exp.charAt(i);
            switch(c) {
                case '(':
                case '{':
                case '[':
                    s.push(c);
                    continue;
            }
            switch(c) {
                case ')':
                    if(s.top() != '(') return false; else s.pop();
                    break;
                case '}':
                    if(s.top() != '{') return false; else s.pop();
                    break;
                case ']':
                    if(s.top() != '[') return false; else s.pop();
                    break;
            }
        }
        return s.empty();
    }

    public static void main(String[]args) throws Exception {
        String exp = "()[][][()]";
        BalancedParenthesis p = new BalancedParenthesis();
        System.out.println(p.checkBalanced(exp));
    }
}