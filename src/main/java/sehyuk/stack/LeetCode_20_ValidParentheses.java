package sehyuk.stack;

import java.util.Stack;

public class LeetCode_20_ValidParentheses {

	public void main(String[] args){

	}
	public static boolean isValid(String s) {
		Stack<Character> sta= new Stack<Character>();
		for(int i=0;i<s.length();i++){
			Character ch= s.charAt(i);
			if(ch=='(' || ch=='{' || ch=='['){
				sta.push(ch);
			}
			else{
				if(sta.empty()) return false;
				if((ch==')' && sta.peek()=='(') || (ch=='}' && sta.peek()=='{') || (ch==']' && sta.peek()=='[') ){
					sta.pop();
				}
				else return false;
			}
		}
		if(sta.empty()) return true;
		else return false;


	}
}
