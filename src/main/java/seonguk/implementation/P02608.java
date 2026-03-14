package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P02608 {

    static Map<Character, Integer> romeMap = new HashMap<>();
    static Map<Integer, Character> arabianMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        setInit();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String romeNum1 = br.readLine();
        String romeNum2 = br.readLine();

        int arabianResult = toArabian(romeNum1) + toArabian(romeNum2);
        String romeResult = toRome(arabianResult);

        System.out.println(arabianResult);
        System.out.println(romeResult);
    }

    static String toRome(int n) {
        StringBuilder sb = new StringBuilder();
        if (n / 1000 > 0) {
            int temp = n / 1000;
            n %= 1000;
            for (int i = 0; i < temp; i++) {
                sb.append(arabianMap.get(1000));
            }
        }
        if (n / 100 > 0) {
            calcNum(sb, n, 100);
            n %= 100;
        }
        if (n / 10 > 0) {
            calcNum(sb, n, 10);
            n %= 10;
        }
        calcNum(sb, n, 1);
        return sb.toString();
    }

    private static void calcNum(StringBuilder sb, int n, int size) {
        int temp = n / size;
        if (temp > 8) {
            sb.append(arabianMap.get(size));
            sb.append(arabianMap.get(size * 10));
        } else if (temp >= 5) {
            sb.append(arabianMap.get(size * 5));
            for (int i = 0; i < temp - 5; i++) {
                sb.append(arabianMap.get(size));
            }
        } else if (temp > 3) {
            sb.append(arabianMap.get(size));
            sb.append(arabianMap.get(size * 5));
        } else {
            for (int i = 0; i < temp; i++) {
                sb.append(arabianMap.get(size));
            }
        }
    }

    static int toArabian(String romeNum) {
        char[] arr = romeNum.toCharArray();
        int sum = 0;
        int i = 0;
        for (; i < arr.length - 1; i++) {
            int now = romeMap.get(arr[i]);
            int next = romeMap.get(arr[i + 1]);
            if (now < next) {
                sum += next - now;
                i++;
            } else {
                sum += now;
            }
        }
        if (i == arr.length - 1) {
            sum += romeMap.get(arr[arr.length - 1]);
        }

        return sum;
    }

    static void setInit() {
        Integer[] arrInt = new Integer[]{1, 5, 10, 50, 100, 500, 1000};
        Character[] arrChar = new Character[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};

        for (int i = 0; i < arrInt.length; i++) {
            romeMap.put(arrChar[i], arrInt[i]);
            arabianMap.put(arrInt[i], arrChar[i]);
        }
    }

}
