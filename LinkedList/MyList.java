public class MyList {
    MyNode head;

    private MyNode append(String data, MyNode node) {
        if (node == null) return new MyNode(data, null);
        node.next = append(data, node.next);
        return node;
    }
    public void append(String data) {
        head = append(data, head);
    }

    private MyNode removeFirst(String data, MyNode node) {
        if (node == null) return null;
        if (node.data.equals(data)) {
            return node.next;
        }
        node.next = removeFirst(data, node.next);
        return node;
    }
    public void removeFirst(String data) {
        head = removeFirst(data, head);
    }

    private MyNode removeAll(String data, MyNode node) {
        if (node == null) return null;
        if (node.data.equals(data)) {
//            node = node.next;
            return removeAll(data, node.next);
        }
        node.next = removeAll(data, node.next);
        return node;
    }
    public void removeAll(String data) {
        head = removeAll(data, head);
    }
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (MyNode p = head; p != null; p = p.next) builder.append(p.data).append(" ");
        return builder.append("]").toString();
    }

    public static void main(String[] args) {
        MyList list = new MyList();
        list.append("One");
        list.append("Two");
        list.append("One");
        list.append("Three");
        list.append("One");
        System.out.println(list); //One Two Three One

        list.removeAll("One");
        System.out.println(list);  //Two Three One
        list.removeFirst("One");
        System.out.println(list);  //Two Three
        list.removeFirst("One");
        System.out.println(list);  //Two Three

        list.removeFirst("Two");
        System.out.println(list);  //Three
        list.removeFirst("Three");
        System.out.println(list);  //[]
        list.removeFirst("Three");
//        System.out.println(list);  //[]
    }
}
