package yjham.hashTable;

public class LeetCode_706_DesignHashMap {

    public Object[] useMyHashMap(String[] commands, Integer[][] args) {
        Object[] history = new Object[commands.length];

        MyHashMap myHashMap = new MyHashMap();

        for (int i = 1; i < commands.length; i++) {
            String command = commands[i];
            Integer[] arg = args[i];

            switch (command) {
                case "put" -> myHashMap.put(arg[0], arg[1]);
                case "get" -> history[i] = myHashMap.get(arg[0]);
                case "remove" -> myHashMap.remove(arg[0]);
            }
        }

        return history;
    }
}

class MyHashMap {

    Node[] nodes;

    public MyHashMap() {
        nodes = new Node[1000000];
    }

    public void put(int key, int value) {
        int idx = key % nodes.length;

        Node node = nodes[idx];

        if (node == null) {
            nodes[idx] = new Node(key, value);
            return;
        }

        while (true) {
            if (node.key == key) {
                node.value = value;
                return;
            }

            if (node.next == null) break;

            node = node.next;
        }

        node.next = new Node(key, value);
    }

    public int get(int key) {
        int idx = key % nodes.length;

        Node node = nodes[idx];

        if (node == null) return -1;

        while (node != null) {
            if (node.key == key) return node.value;

            node = node.next;
        }

        return -1;
    }

    public void remove(int key) {
        int idx = key % nodes.length;

        Node node = nodes[idx];

        if (node == null) return;

        if (node.key == key) nodes[idx] = node.next;

        Node prev = node;

        while (node != null) {
            if (node.key == key) {
                prev.next = node.next;
                return;
            }

            prev = node;
            node = node.next;
        }
    }
}

class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
