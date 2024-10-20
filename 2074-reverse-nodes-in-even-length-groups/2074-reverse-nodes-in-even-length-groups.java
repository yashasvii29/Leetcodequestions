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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode cur = head;
        ListNode prev = null;  // Last node of the previous group
        int groupSize = 1;     // Starting group size is 1
        
        while (cur != null) {
            // Find the size of the current group
            ListNode groupStart = cur;
            int count = 0;
            while (cur != null && count < groupSize) {
                cur = cur.next;
                count++;
            }

            // If the group has even length, reverse it
            if (count % 2 == 0) {
                ListNode reversedGroupHead = reverseGroup(groupStart, count);
                if (prev != null) {
                    prev.next = reversedGroupHead;  // Connect the previous group to the reversed one
                } else {
                    head = reversedGroupHead;  // If the first group is reversed, update the head
                }
                prev = groupStart;  // The groupStart is now the end of the reversed group
            } else {
                // For odd-length groups, just move prev to the end of the current group
                prev = groupStart;
                while (prev.next != cur) {
                    prev = prev.next;
                }
            }

            // Move to the next group with incremented size
            groupSize++;
        }

        return head;
    }

    // Function to reverse the first 'k' nodes in a group and return the new head
    private ListNode reverseGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (k > 0 && cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            k--;
        }
        head.next = cur;  // Connect the reversed group to the remaining list
        return prev;      // Return the new head of the reversed group
    }
}
