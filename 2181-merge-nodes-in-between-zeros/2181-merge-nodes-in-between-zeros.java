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
    public ListNode mergeNodes(ListNode head) {
       // Initialize a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode temp = head.next; // Skip the initial zero node
        int sum = 0;

        // Traverse the list starting from the node after head
        while (temp != null) {
            if (temp.val == 0) {
                // When a zero node is found, create a new node with the accumulated sum
                current.next = new ListNode(sum);
                current = current.next;
                sum = 0; // Reset the sum
            } else {
                // Accumulate the sum
                sum += temp.val;
            }
            temp = temp.next; // Move to the next node
        }

        return dummy.next; // Return the merged list starting from dummy's next node
    }
}