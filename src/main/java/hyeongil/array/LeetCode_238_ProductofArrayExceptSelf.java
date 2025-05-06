package hyeongil.array;


import java.util.Arrays;

// 단, product[i]라고 했을 때, nums[i]의 값을 제외한 나머지들의 곱으로 이루어져야한다.
// 추가적인 공간을 사용하지 않아야한다.
// 나누기 연산을 사용하지 않아야하고, O(N)안에서 문제를 해결하도록 하자.
public class LeetCode_238_ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = p;
            p *= nums[i];
        }

        p = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = p;
            p *= nums[i];
        }
        return result;
    }
}
