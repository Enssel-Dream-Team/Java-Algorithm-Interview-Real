package hyeongil.array;


import java.util.Arrays;

// 단, product[i]라고 했을 때, nums[i]의 값을 제외한 나머지들의 곱으로 이루어져야한다.
// 추가적인 공간을 사용하지 않아야한다.
// 나누기 연산을 사용하지 않아야하고, O(N)안에서 문제를 해결하도록 하자.
public class LeetCode_238_ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        // nums[i]를 제외한 나머지 수들의 곱을 products[i]라고 했을 때,
        // 곱을 수행하기 위한 초기 값을 product[i]라고 하자.
        for (int i = 0; i < nums.length; i++) {
            products[i] = 1;
        }

        // 자기 자신을 제외한 나머지들의 곱
        // n == 3일 경우, 다음과 같이 구성될 것이다.
        // product[0] = nums[1] * nums[2] * nums[3]
        // product[1] = nums[0] * nums[2] * nums[3]
        // product[2] = nums[0] * nums[1] * nums[3]
        // product[3] = nums[0] * nums[1] * nums[2]
        for (int i = 0; i < nums.length; i++) {

        }

        return products;
    }
}
