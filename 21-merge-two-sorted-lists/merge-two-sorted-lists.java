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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer>list = new ArrayList<>();
        ListNode temp1 = list1;
        while(temp1 != null){
            list.add (temp1.val);
            temp1 = temp1.next;
        }
        ListNode temp2 = list2;
        while(temp2 != null){
            list.add(temp2.val);
            temp2 = temp2.next;
        }

        Collections.sort(list);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        for(int value : list){
            temp.next = new ListNode(value);
            temp = temp.next;
        }

        return dummy.next;
    }
}