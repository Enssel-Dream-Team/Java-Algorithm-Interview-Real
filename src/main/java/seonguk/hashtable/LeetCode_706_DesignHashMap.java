package seonguk.hashtable;

import java.util.*;

public class LeetCode_706_DesignHashMap {
    static class MyHashMap {
        HashSet<Integer> set;
        int[] arr = new int[1000001];

        public MyHashMap() {
            set = new HashSet<>();
        }

        public void put(int key, int value) {
            set.add(key);
            arr[key] = value;
        }

        public int get(int key) {
            if(!set.contains(key))
                return -1;
            return arr[key];
        }

        public void remove(int key) {
            set.remove(key);
        }
    }
}
