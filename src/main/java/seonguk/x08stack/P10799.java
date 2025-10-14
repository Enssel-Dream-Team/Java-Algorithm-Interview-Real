package seonguk.x08stack;

import java.util.Scanner;

public class P10799 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] arr = scan.next().toCharArray();

		int layer = 0;
		int ans = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == '(') {
				if (arr[i + 1] == ')') {
					ans += layer;
					i++;
				} else {
					layer++;
					ans++;
				}
			} else {
				layer--;
			}
		}

		System.out.println(ans);
	}
}
