public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        SinglyLinkedListNode t = llist;
        SinglyLinkedListNode a = llist;
        int n = 0;
        while (t != null) {
            n++;
            t = t.next;
        }
        for (int i = 0; i < n - positionFromTail - 1; i++) {
            a = a.next;
        }
        return a.data;
    }