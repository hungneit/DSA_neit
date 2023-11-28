import java.util.*;

public class B3 {
    public static class LinkList {
        private class Node {
            private Node next;
            private int data;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public int getData() {
                return data;
            }
        }

    }
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = sn.nextInt();
            list.add(x);
        }
        for (int i = 0; i < n; i++) {
//            mp.put(list.get(i), mp.getOrDefault(list.get(i),0) + 1);
            if (!mp.containsKey(list.get(i))) {

                mp.put(list.get(i), 1);
            }
            else {
                list.remove(i);
                n--;
//                i--;
            }
        }
        for (int x:list) {
            System.out.print(x + " ");
        }
    }
}
//7
//1 2 3 2 4 1 5