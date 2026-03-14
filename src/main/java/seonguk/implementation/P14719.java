package seonguk.implementation;

import java.util.Scanner;
import java.util.StringTokenizer;

public class P14719 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scan.nextLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];

        st = new StringTokenizer(scan.nextLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] left = leftAmount(arr);
        int right = rightAmount(arr, left[1]);

        System.out.println(left[0] + right);
        scan.close();
    }

    private static int[] leftAmount(int[] arr) {
        int sum = 0;
        int maxHeight = 0;
        int tempAmount = 0;
        int lastIdx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= maxHeight) {
                maxHeight = arr[i];
                sum += tempAmount;
                tempAmount = 0;
                lastIdx = i;
            } else {
                tempAmount += maxHeight - arr[i];
            }
        }

        return new int[] {sum, lastIdx};
    }

    private static int rightAmount(int[] arr, int lastIdx) {
        int sum = 0;
        int maxHeight = 0;
        int tempAmount = 0;

        for (int i = arr.length - 1; i >= lastIdx; i--) {
            if (arr[i] >= maxHeight) {
                maxHeight = arr[i];
                sum += tempAmount;
                tempAmount = 0;
            } else {
                tempAmount += maxHeight - arr[i];
            }
        }

        return sum;
    }
}
