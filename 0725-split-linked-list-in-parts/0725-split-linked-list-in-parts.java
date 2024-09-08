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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];  // Array to store the k parts
        
        // Step 1: Count the number of nodes in the linked list
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        
        // Step 2: Calculate the base size and the extra nodes needed for the first few parts
        int c = n / k;  // Minimum size of each part
        int rem = n % k;  // Number of parts that will have one extra node
        
        // Step 3: Split the list into parts
        temp = head;
        for (int i = 0; i < k; i++) {
            ListNode cur = temp;  // This will be the head of the temp part
            ListNode prev = null;
            
            // Determine the size of the temp part (c + 1 if rem > 0)
            int len = c + (rem > 0 ? 1 : 0);
            rem--;  // Decrease rem after assigning one extra node
            
            // Iterate through the temp part
            for (int j = 0; j < len; j++) {
                prev = temp;
                if (temp != null) 
                    temp = temp.next;
            }
            
            // Disconnect the temp part from the rest of the list
            if (prev != null)
                 prev.next = null;
            
            // Add the temp part to the result array
            result[i] = cur;
        }
        
        return result;
    }
}