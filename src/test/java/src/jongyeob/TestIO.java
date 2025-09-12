package src.jongyeob;

import java.io.*;

public class TestIO {
    public static String runWithInput(Runnable entry, String input) {
        InputStream origIn = System.in;
        PrintStream origOut = System.out;
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            System.setOut(new PrintStream(bout));
            entry.run(); // e.g. () -> Editor_1406.main(new String[0])
            return bout.toString().replace("\r\n", "\n").trim();
        } finally {
            System.setIn(origIn);
            System.setOut(origOut);
        }
    }
}
