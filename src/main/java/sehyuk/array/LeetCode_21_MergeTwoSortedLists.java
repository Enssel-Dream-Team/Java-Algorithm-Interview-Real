package sehyuk.array;
/**
 *  21. Merge Two Sorted Lists
 *  Link : https://leetcode.com/problems/merge-two-sorted-lists/
 *  explanation : 
 */
public class LeetCode_21_MergeTwoSortedLists{
  	public static void main(String[] args){
  		ListNode head = new ListNode(5);
      ListNode head2 = new ListNode(6);
  		mergeTwoLists(head, head2);
  	}
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }  
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        NodeList list=new NodeList();
        while(list1 != null && list2 != null){
            if(list1.val >= list2.val){
                list.add(list2);
                list2 = list2.next;
            }else{
                list.add(list1);
                list1 = list1.next;
            }
        }
        while(list1 !=null){
            list.add(list1);
            list1 = list1.next;
        }
        while(list2 != null){
            list.add(list2);
            list2 = list2.next;

        }
        return list.head;
    }
    static class NodeList {
        ListNode head = null;
        ListNode tail = null;
        public NodeList(){
        }

        public void add(ListNode n){
            ListNode tempNode = new ListNode(n.val);
            if(head == null){
                head = tempNode;
                tail = head;
            }else{
                tail.next = tempNode;
                tail = tail.next;
            }
        }

    }
	
}
