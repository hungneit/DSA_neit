public public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        if( position == 0) {
            return llist.next;
        }
        SinglyLinkedListNode t = llist;
        while (position > 1) {
            t = t.next;
            position--;
        }
        t.next = t.next.next;
        return llist;
    }
