package jongyeob.x1ATopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class GenealogyRestorerHoseok_21276 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        Map<String, ArrayList<String>> parentInfo = new HashMap<>();
        Map<String, ArrayList<String>> childInfo = new HashMap<>();

        int n = Integer.parseInt(tokenizer.nextToken());
        String[] names = new String[n];

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            String name = tokenizer.nextToken();
            parentInfo.put(name, new ArrayList<>());
            childInfo.put(name, new ArrayList<>());
            names[i] = name;
        }
        Arrays.sort(names);

        tokenizer = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            String x = tokenizer.nextToken();
            String y = tokenizer.nextToken();
            parentInfo.get(x).add(y);
        }

        for (String key : parentInfo.keySet()) {
            ArrayList<String> parent = parentInfo.get(key);
            int numOfParents = parent.size();
            for (String s : parent) {
                if (numOfParents - parentInfo.get(s).size() < 2) {
                    childInfo.get(s).add(key);
                }
            }
        }

        ArrayList<String> root = new ArrayList<>();
        for (String key : names) {
            if (parentInfo.get(key).isEmpty()) {
                root.add(key);
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append(root.size()).append('\n');
        for (String name : root) {
            builder.append(name).append(" ");
        }
        builder.append('\n');

        for (String name : names) {
            ArrayList<String> children = childInfo.get(name);
            Collections.sort(children);
            builder.append(name).append(" ").append(children.size()).append(" ");
            for (String childName : children) {
                builder.append(childName).append(" ");
            }
            builder.append('\n');
        }
        System.out.println(builder);
    }
}
