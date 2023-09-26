public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
         SinglyLinkedListNode a = llist;
         SinglyLinkedListNode b = null;
         SinglyLinkedListNode c = null;
         while (a != null) {
             b = a.next;
             a.next = c;
             c = a;
             a = b;
         }
         return c;
    }