public class Queue {
    private Node first,last;
    private static class Node {
        private String data;
        private Node next;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void enqueue(String data) {
        Node tmp = last;
        last = new Node();
        last.data = data;
        last.next = null;
        if(isEmpty()) first = last;
        else tmp.next = last;
    }
    public String dequeue() {
        String data = first.data;
        first = first.next;
        if (isEmpty()) last = null;
        return data;
    }
    public static void main(String[] args) {
        Queue st = new Queue();
        st.enqueue("one");
        st.enqueue("two");
        st.enqueue("three");
        st.enqueue("four");
        st.enqueue("five");
        while(!st.isEmpty()) {
            System.out.println(st.dequeue());
        }
    }
}
