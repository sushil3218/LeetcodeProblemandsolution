/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

    int length = 0;
    ListNode temp = head;

    // 1. Find length
    while (temp != null) {
        length++;
        temp = temp.next;
    }

    // 2. If first node has to be deleted
    if (n == length) {
        return head.next;
    }

    // 3. Find the node BEFORE the node to delete
    int position = length - n;

    temp = head;

    for (int i = 1; i < position; i++) {
        temp = temp.next;
    }

    // 4. Delete
    temp.next = temp.next.next;

    return head;
}
}