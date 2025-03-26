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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        //return merge(lists, 0, lists.length - 1);
        int length = lists.length;
        while (length > 1){
            for (int i = 0; i < length; i+=2)
                lists[i >> 1] = (i+1==length) ? lists[i] : mergeLists(lists[i],lists[i+1]); 

            length = (length+1) >> 1;
        }
        return lists[0];
    }

    // private ListNode merge(ListNode[] lists, int start, int end){
    //     if (end < start) return new ListNode();
    //     if (start == end) return lists[start];

    //     return mergeLists(
    //         merge(lists, start, start + (end - start)/2),
    //         merge(lists, start + (end - start)/2 + 1, end)
    //         );
    // }

    private ListNode mergeLists(ListNode list1, ListNode list2){
        ListNode mergedListPointer = new ListNode();
        ListNode mergedList = mergedListPointer;
        int val;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                val = list1.val;
                list1 = list1.next;
            }else{
                val = list2.val;
                list2 = list2.next;
            }

            mergedListPointer.next = new ListNode(val);
            mergedListPointer = mergedListPointer.next;
        }
        if (list1 != null){
            mergedListPointer.next = list1;
        } else if (list2 != null){
            mergedListPointer.next = list2;
        }

        return mergedList.next;
    }
}
