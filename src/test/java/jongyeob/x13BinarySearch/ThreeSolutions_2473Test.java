package jongyeob.x13BinarySearch;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ThreeSolutions_2473Test {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outputCapture;

    @BeforeEach
    void setUp() {
        outputCapture = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCapture));
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private String getOutput() {
        return outputCapture.toString().trim();
    }

    @Test
    void 예제1() throws IOException {
        setInput("5\n-2 6 -97 -6 98");
        ThreeSolutions_2473.main(new String[] {});
        assertEquals("-97 -2 98", getOutput());
    }

    @Test
    void 예제2() throws IOException {
        setInput("7\n-2 -3 -24 -6 98 100 61");
        ThreeSolutions_2473.main(new String[] {});
        assertEquals("-6 -3 -2", getOutput());
    }

    @Test
    void 반례1() throws IOException {
        setInput("6\n-1 0 1 2 3 4");
        ThreeSolutions_2473.main(new String[] {});
        assertEquals("-1 0 1", getOutput());
    }

    @Test
    void 반례2() throws IOException {
        setInput("4\n1 1 1 -6");
        ThreeSolutions_2473.main(new String[] {});
        assertEquals("1 1 1", getOutput());
    }

}