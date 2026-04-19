package seonguk.leetcode;

public class P01855 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {55,30,5,4,2};
        int[] nums2 = {100,20,10,10,5};

        System.out.println(s.maxDistance(nums1, nums2));
    }

    static class Solution {
        public int maxDistance(int[] nums1, int[] nums2) {
            int ans = 0;

            for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
                if (nums1[i] <= nums2[j]) {
                    ans = Math.max(ans, j - i);
                    j++;
                    continue;
                }

                boolean flag = true;
                for (int nextI = i + 1; nextI < nums1.length; nextI++) {
                    if (nums1[nextI] <= nums2[j]) {
                        flag = false;
                        i = nextI;
                        if (j < i) {
                            j = i;
                        }
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }

            return ans;
        }
    }
}
