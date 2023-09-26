static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode x = new SinglyLinkedListNode(data);
        if(head == null) {
            head = x;
        }
        else {
             SinglyLinkedListNode t = head;
             while (t.next != null){
                 t = t.next;
             }
             t.next = x;
        }
        return head;
    }