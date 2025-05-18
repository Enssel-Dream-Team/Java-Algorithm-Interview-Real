package hyeongil.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

// temp[i]: i번째 날의 온도를 의미한다.
// answer[i] -> i번째날보다 온도가 높은 첫 날
public class LeetCode_739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {

        // 1. 지난 날을 기록하기 위해서 스택을 사용한다.
        // -> i번째 온도 이전에 등장했던 온도들이 가까운 순으로 조회되어야 한다.
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[temperatures.length];

        for (int today = 0; today < temperatures.length; today++) {
            // stack이 비어 있다면, 저장한 이후, continue
            if (stack.isEmpty()) {
                stack.push(today);
                continue;
            }

            int currentTemp = temperatures[today];
            // stack이 비어있지 않고, 현재 온도보다 이전에 저장한 온도가 낮다면
            while (!stack.isEmpty() && currentTemp > temperatures[stack.peek()]) {
                Integer beforeDay = stack.pop();
                result[beforeDay] = today - beforeDay;
            }

            // 오늘의 온도를 저장한다.
            stack.push(today);

        }

        return result;
    }

    public static void main(String[] args) {
        new LeetCode_739_DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
