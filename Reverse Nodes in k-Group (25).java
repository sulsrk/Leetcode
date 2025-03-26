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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode check = head; ListNode curr = head;
        int[] toAdd = new int[k];

        while (check != null){
            // Iterate over the next k elements
            for (int i = 0; i < k; i++){
                if (check == null) return head;
                toAdd[i] = check.val;
                check = check.next;
            }
            // Add the next k elements back in reverse
            for (int i = k-1; i >= 0; i--){
                curr.val = toAdd[i];
                curr = curr.next;
            }
        }

        return head;
    }
}
