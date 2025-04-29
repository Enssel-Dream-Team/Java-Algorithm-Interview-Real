package sehyuk.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 125. Valid Palindrome
 * Link : https://leetcode.com/problems/valid-palindrome/
 * explanation : 투 포인터 이용
 * 1. 먼저 문자열을 대문자나 소문자로 통일시킨다.
 * 2. 시작과 끝 쪽에서 포인터를 만든다.
 * 3. 만약 숫자나 사전에 지정한 대문자 or 소문자가 아니라면 다음 인덱스로 넘어간다.
 * 4. 만약 시작과 끝 포인터가 모두 숫자나 문자라면 비교한다.
 * 5. 위 과정을 반복한다.
 *
 */
public class LeetCode_125_ValidPalindrome  {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		boolean result=isPalindrome(input);
		System.out.println(result);
	}
	public static boolean isPalindrome(String s) {
		s=s.toUpperCase();
		int start=0;
		int end=s.length()-1;
		while(start<end){
			char ch=s.charAt(start);
			char ch2=s.charAt(end);
			if(!((ch>=65 && ch<=90) || (ch>=48 && ch<=57))){
				start++;
				continue;
			}
			if(!((ch2>=65 && ch2<=90) || (ch2>=48 && ch2<=57))){
				end--;
				continue;
			}

			if(ch==ch2){
				start++;
				end--;
				continue;
			}

			return false;

		}
		return true;
	}
}