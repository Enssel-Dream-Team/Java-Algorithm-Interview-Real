package jongyeob.string;

import java.util.*;

public class LeetCode_937_ReorderDataInLogFiles {
    public static void main(String[] args) {
        String[] logs = {"6p tzwmh ige mc", "ns 566543603829", "ubd cujg j d yf", "ha6 1 938 376 5", "3yx 97 666 56 5", "d 84 34353 2249", "0 tllgmf qp znc", "s 1088746413789", "ys0 splqqxoflgx", "uhb rfrwt qzx r", "u lrvmdt ykmox", "ah4 4209164350", "rap 7729 8 125", "4 nivgc qo z i", "apx 814023338 8"};
        logs = reorderLogFiles(logs);
        System.out.println("Arrays.toString(logs) = " + Arrays.toString(logs));
    }

    public static String[] reorderLogFiles(String[] logs) {
        List<String> letter = new ArrayList<>();
        List<String> digit = new ArrayList<>();
        for (String s : logs) {
            String first = s.split(" ")[1];
            if(Character.isDigit(first.charAt(0)))
                digit.add(s);
            else
                letter.add(s);
        }
        letter.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] a = o1.split(" ", 2);
                String[] b = o2.split(" ", 2);
                if(a[1].compareTo(b[1]) == 0)
                    return a[0].compareTo(b[0]);
                else
                    return a[1].compareTo(b[1]);
            }
        });
        letter.addAll(digit);
        return letter.toArray(new String[letter.size()]);

    }
}
