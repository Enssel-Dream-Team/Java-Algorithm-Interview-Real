package src.yjham;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import yjham.dequePriorityQueue.*;
import yjham.linkedList.ListNode;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("10_데크,우선순위 큐 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DequePriorityQueueTest extends BaseTest {

    @Test
    void Design_Circular_Deque() {
        LeetCode_641_DesignCircularDeque exam = new LeetCode_641_DesignCircularDeque();

        String[] commands = {"MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"};
        Integer[] inputs = {3, 1, 2, 3, 4, null, null, null, 4, null};

        Object[] expected = {null, true, true, true, false, 2, true, true, true, 4};
        Object[] actual = exam.useMyCircularDeque(commands, inputs);

        assertArrayEquals(expected, actual);
    }

    @Test
    void Merge_K_Sorted_Lists() {
        LeetCode_23_MergeKSortedLists exam = new LeetCode_23_MergeKSortedLists();

        // 1
        ListNode[] lists = {createListNode(1, 4, 5), createListNode(1, 3, 4), createListNode(2, 6)};

        ListNode expected = createListNode(1, 1, 2, 3, 4, 4, 5, 6);
        ListNode actual = exam.mergeKLists(lists);

        assertArrayEquals(nodeToArray(expected), nodeToArray(actual));

        // 2
        lists = new ListNode[]{};

        expected = null;
        actual = exam.mergeKLists(lists);

        assertArrayEquals(nodeToArray(expected), nodeToArray(actual));

        // 3
        lists = new ListNode[]{createListNode()};

        expected = null;
        actual = exam.mergeKLists(lists);

        assertArrayEquals(nodeToArray(expected), nodeToArray(actual));
    }

    @Test
    void K_Closest_Points_To_Origin() {
        LeetCode_973_KClosestPointsToOrigin exam = new LeetCode_973_KClosestPointsToOrigin();

        // 1
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;

        int[][] expected = {{-2, 2}};
        int[][] actual = exam.kClosest(points, k);

        assertArrayEquals(expected, actual);

        // 2
        points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        k = 2;

        expected = new int[][]{{3, 3}, {-2, 4}};
        actual = exam.kClosest(points, k);

        assertArrayEquals(expected, actual);
    }

    @Test
    void Scoville() {
        Programmers_42626_Scoville exam = new Programmers_42626_Scoville();

        // 1
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        int expected = 2;
        int actual = exam.solution(scoville, K);

        assertEquals(expected, actual);
    }
}
