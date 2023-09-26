public public public static void reversePrint(SinglyLinkedListNode llist) {
        SinglyLinkedListNode a = llist;
        SinglyLinkedListNode b = null;
        SinglyLinkedListNode c = null;
        while (a != null) {
            b = a.next;
            a.next = c;
            c = a;
            a = b;
        }
        while( c !=null){
            System.out.println(c.data);
            c=c.next;
        }
    }