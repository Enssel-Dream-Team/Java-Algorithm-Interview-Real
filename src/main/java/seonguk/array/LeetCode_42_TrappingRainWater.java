package seonguk.array;

public class LeetCode_42_TrappingRainWater {
    public int trap(int[] height) {
        int[] arr = new int[height.length];
        int left = 0;
        for(int i = 0; i < height.length; i++){
            if(height[i] > left){
                left = height[i];
            }
            arr[i] = left;
        }

        int right = 0;
        for(int i = height.length - 1; i >= 0; i--){
            if(height[i] > right){
                right = height[i];
                if(right == left)
                    break;
            }
            arr[i] = right;
        }

        int ans = 0;
        for(int i = 0; i < height.length; i++){
            ans += arr[i] - height[i];
        }

        return ans;
    }
}
