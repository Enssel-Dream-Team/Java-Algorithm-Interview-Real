package sehyuk.linkedList;
/**
 *  21. Merge Two Sorted Lists
 *  Link : https://leetcode.com/problems/merge-two-sorted-lists/
 *  explanation :
 *  1. 두 정렬된 링크드리스트의 헤드 값을 비교하여 낮은 값을 추가한다.
 *  2. 남은 값들을 링크드리스트에 추가한다.
 */
public class LeetCode_21_MergeTwoSortedLists{
  	public static void main(String[] args){
  		ListNode head = new ListNode(5);
      ListNode head2 = new ListNode(6);
  		mergeTwoLists(head, head2);
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
