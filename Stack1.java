import java.util.Stack;

public class Stack1 {
    private static class Node {
        private String data;
        private Node next;

    }
    private Node first;

    public void push(String s) {
        Node tmp = first;
        first = new Node();
        first.data = s;
        first.next = tmp;
    }
    public String pop() {
        Node tmp = first;
        first = first.next;
        return tmp.data;
    }
    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        Stack1 st = new Stack1();
        st.push("one");
        st.push("two");
        st.push("three");
        st.push("four");
        st.push("five");
        st.pop();
        while(!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }
}
