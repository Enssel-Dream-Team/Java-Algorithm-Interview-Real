package seonguk.leetcode;

import java.util.*;

public class P02196 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode createBinaryTree(int[][] descriptions) {
            Map<Integer, TreeNode> map = new HashMap<>();
            Map<Integer, Boolean> rootCheck = new HashMap<>();

            for (int[] d : descriptions) {
                TreeNode now = map.getOrDefault(d[0], new TreeNode(d[0]));
                TreeNode child = map.getOrDefault(d[1], new TreeNode(d[1]));

                if (d[2] == 1) {
                    now.left = child;
                } else {
                    now.right = child;
                }

                map.put(d[0], now);
                map.put(d[1], child);

                setRootCheck(rootCheck, d[0], false);
                setRootCheck(rootCheck, d[1], true);
            }

            TreeNode root = null;
            for (Map.Entry<Integer, Boolean> entry : rootCheck.entrySet()) {
                if (!entry.getValue()) {
                    continue;
                }
                root = map.get(entry.getKey());
                break;
            }

            return root;
        }

        private void setRootCheck(Map<Integer, Boolean> map, int val, boolean isChild) {
            boolean b = map.getOrDefault(val, true);
            if (b && isChild) {
                b = false;
            }
            map.put(val, b);
        }
    }
}
