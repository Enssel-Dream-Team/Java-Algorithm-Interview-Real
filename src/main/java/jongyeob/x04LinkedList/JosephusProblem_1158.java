package jongyeob.x04LinkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class JosephusProblem_1158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        String result = solve(N, K);
        System.out.println(result);
    }

    private static String solve(int n, int k) {
        int cursor = -1;
        LinkedList<Integer> linkedList = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        builder.append("<");
        for (int i = 0; i < n; i++) {
            linkedList.add(i+1);
        }
        while (!linkedList.isEmpty()) {
            cursor = (cursor + k) % linkedList.size();
            Integer removed = linkedList.remove(cursor--);
            builder.append(removed + ", ");
        }
        builder.setLength(builder.length() - 2);
        builder.append(">");
        return builder.toString();
    }
}
