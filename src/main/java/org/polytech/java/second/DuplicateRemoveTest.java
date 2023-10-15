package main.java.org.polytech.java.second;

public class DuplicateRemoveTest {
    public static void main(String[] args) {

        final ListNode listNode8 = new ListNode(6);
        final ListNode listNode7 = new ListNode(6, listNode8);
        final ListNode listNode6 = new ListNode(6, listNode7);
        final ListNode listNode5 = new ListNode(3, listNode6);
        final ListNode listNode4 = new ListNode(3, listNode5);
        final ListNode listNode3 = new ListNode(2, listNode4);
        final ListNode listNode2 = new ListNode(1, listNode3);
        final ListNode head = new ListNode(1, listNode2);

        print(head);
        deleteDuplicates(head);
        print(head);

    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        ListNode node = head.next;
        while (node != null) {
            if (tmp.val == node.val) {
                tmp.next = null;
                node = node.next;
                continue;
            }
            tmp.next = node;
            tmp = node;
            node = node.next;
        }

        return head;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}