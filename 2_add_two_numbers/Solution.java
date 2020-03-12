/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value = (l1.val + l2.val) % 10;
        boolean adder = l1.val + l2.val >= 10;
        ListNode newNode = new ListNode(value);
        newNode.next = null;
        ListNode nextNodeOne = l1.next;
        ListNode nextNodeTwo = l2.next;
        boolean isL1Null = false;
        boolean isL2Null = false;
        ListNode lastNode = newNode;
        while(true) {
            if (adder)
            value = 0 + adder;
            adder = 0;

            if (nextNodeOne == null) {
                isL1Null = true;
            } else {
                value = value + nextNodeOne.val;
                nextNodeOne = nextNodeOne.next;
            }

            if (nextNodeTwo == null) {
                isL2Null = true;
            } else {
                value = value + nextNodeTwo.val;
                nextNodeTwo = nextNodeTwo.next;
            }

            if (value >= 10) {
                adder = value / 10;
                value = value % 10;
            }

            if (isL1Null && isL2Null && value == 0) {
                break;
            }

            ListNode nextNode = new ListNode(value);
            lastNode.next = nextNode;
            lastNode = nextNode;
        }
        return newNode;
    }
}