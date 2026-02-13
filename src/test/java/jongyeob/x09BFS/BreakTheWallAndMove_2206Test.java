package jongyeob.x09BFS;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BreakTheWallAndMove_2206Test {
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
        setInput("6 4\n0100\n1110\n1000\n0000\n0111\n0000");
        BreakTheWallAndMove_2206.main(new String[] {});
        assertEquals("15", getOutput());
    }

    @Test
    void 예제2() throws IOException {
        setInput("4 4\n0111\n1111\n1111\n1110");
        BreakTheWallAndMove_2206.main(new String[] {});
        assertEquals("-1", getOutput());
    }

}