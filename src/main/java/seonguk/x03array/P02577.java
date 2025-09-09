package seonguk.x03array;

import java.util.Scanner;

public class P02577 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = Integer.parseInt(scan.nextLine());
		int B = Integer.parseInt(scan.nextLine());
		int C = Integer.parseInt(scan.nextLine());

		String result = A * B * C + "";

		int[] arr = new int[10];
		for(char c : result.toCharArray()) {
			arr[c - '0']++;
		}

		for (int i : arr) {
			System.out.println(i);
		}

		scan.close();
	}
}
