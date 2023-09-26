public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {

SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

    if(llist == null) {
        llist = newNode;
        return llist;
    }

    if(position == 0) {
        SinglyLinkedListNode temp = llist;
        llist = newNode;
        newNode.next = temp;

        return llist;
    }

    SinglyLinkedListNode preLinkedListNode = llist;
    int count = 0;

    while(preLinkedListNode.next != null && count < position - 1) {
        preLinkedListNode = preLinkedListNode.next;
        count++;
    }

    SinglyLinkedListNode temp = preLinkedListNode.next;
    preLinkedListNode.next = newNode;
    newNode.next = temp;

    return llist;

}