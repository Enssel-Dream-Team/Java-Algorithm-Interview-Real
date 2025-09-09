package seonguk.x03array;

import java.util.Scanner;

public class P01457 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();

		int[] arr = new int[10];
		for(char c : str.toCharArray()) {
			arr[c - '0']++;
		}

		int result = (arr[6] + arr[9] + 1) / 2;

		for(int i = 0; i < 6; i++) {
			result = Math.max(result, arr[i]);
		}

		for(int i = 7; i < 9; i++) {
			result = Math.max(result, arr[i]);
		}

		System.out.println(result);
		scan.close();
	}
}
