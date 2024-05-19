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
    public ListNode swapNodes(ListNode head, int k) {
        return swap(head, k);
    }

    public static ListNode swap(ListNode head, int k) {
        if (head == null) 
                return null;

        // Find the length of the linked list
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        if (k > length) 
            return head; // If k is greater than the length of the list, return the original list

        // Find the k-th node from the beginning
        ListNode firstKNode = head;
        for (int i = 1; i < k; i++) {
            firstKNode = firstKNode.next;
        }

        // Find the k-th node from the end
        ListNode secondKNode = head;
        for (int i = 1; i <= length - k ; i++) {
            secondKNode = secondKNode.next;
        }

        // Swap the values of the two nodes
        int tempVal = firstKNode.val;
        firstKNode.val = secondKNode.val;
        secondKNode.val = tempVal;

        return head;
    }
}
