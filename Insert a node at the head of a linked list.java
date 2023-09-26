static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode x = new SinglyLinkedListNode(data);
        if( llist == null) {
            llist = x;
        }
        else {
            x.next = llist;
            llist = x;
        }
        return llist;
    }