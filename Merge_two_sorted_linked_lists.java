static void insertLast (SinglyLinkedListNode list, int data) {
         SinglyLinkedListNode x = new SinglyLinkedListNode(data);
         if (list == null) {
             list = x;
         }
         else {
             SinglyLinkedListNode t = list;
             while (t.next != null) {
                 t.next = x;
             }
         }
     }
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(1);
        while (head1 != null && head2 !=null) {
            if (head1.data <= head2.data) {
                insertLast(node, head1.data);
                head1 = head1.next;
            }
            else {
                insertLast(node, head2.data);
                head2 = head2.next;
            }
        }
        while (head1 != null) {
            insertLast(node, head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            insertLast(node, head2.data);
            head2 = head2.next;
        }
        return node.next;
    }