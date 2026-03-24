package jongyeob.x10DP;

import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TheLongestIncreasingSubsequence4_14002Test {
    private final InputStream originalIn = in;
    private final PrintStream originalOut = out;
    private ByteArrayOutputStream outputCapture;

    @BeforeEach
    void setUp() {
        outputCapture = new ByteArrayOutputStream();
        setOut(new PrintStream(outputCapture));
    }

    @AfterEach
    void tearDown() {
        setIn(originalIn);
        setOut(originalOut);
    }

    private void setInput(String input) {
        setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private String getOutput() {
        return outputCapture.toString().trim();
    }

    @Test
    void 예제1() throws IOException {
        setInput("6\n10 20 10 30 20 50");
        TheLongestIncreasingSubsequence4_14002.main(new String[] {});
        assertEquals("4\n10 20 30 50", getOutput());
    }

    @Test
    void 예제2() throws IOException {
        setInput("6\n1 100 2 3 4 5");
        TheLongestIncreasingSubsequence4_14002.main(new String[] {});
        assertEquals("5\n1 2 3 4 5", getOutput());
    }

}
