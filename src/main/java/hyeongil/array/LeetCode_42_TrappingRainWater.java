package hyeongil.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
 * it can trap after raining.
 * <p>
 * 높이와 높이 사이에 물이 차는 양을 구하는 문제.
 * <p>
 * 0 0 1 0 2
 */
public class LeetCode_42_TrappingRainWater {

    public int trap(int[] height) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            // 저장되어있는 막대가 하나도 없고, 스택이 비어있다면 가장 큰 막대가 되므로 저장한다.
            // 그리고 더 이상 진행할 수 없으므로 다음 루프로 넘어간다.
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            int currentHeight = height[i];
            int beforeHeight = height[i - 1];
            if (currentHeight > beforeHeight) {
                // 왼쪽 막대와 오른쪽 막대의 위치를 구한 뒤, 그 사이에 존재하는 모든 막대들의 높이를 두 막대의 길이 중 작은 값으로 증가시킨다.
                int leftHeightIdx = stack.pop();
                int rightHeightIdx = i;
                int minHeight = Math.min(height[leftHeightIdx], height[rightHeightIdx]);
                for (int j = leftHeightIdx + 1; j < rightHeightIdx; j++) {
                    if (height[j] < minHeight) {
                        answer += minHeight - height[j];
                        height[j] = minHeight;
                    }
                }

                // 그리고 모든 연산이 끝난 이후, 더 큰 막대의 위치를 stack에 저장한다.
                stack.push(height[leftHeightIdx] > height[rightHeightIdx] ? leftHeightIdx : rightHeightIdx);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_561_ArrayPartition().trap(new int[] {5,4,1,2}));
    }
}
