package jongyeob.x05Stack;

import java.util.Scanner;
import java.util.Stack;

public class Zero_10773 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] input = new int[N];
        for(int i = 0 ; i < N ; i++){
            input[i] = scanner.nextInt();
        }
        int result = solve(input);
        System.out.println(result);
    }

    private static int solve(int[] input) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i : input) {
            if(i == 0){
                stack.pop();
            }else{
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}
