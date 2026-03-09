package jongyeob.x0DSimulation;

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

class StickingStickers_18808Test {
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
        setInput(
            "5 4 4\n3 3\n1 0 1\n1 1 1\n1 0 1\n2 5\n1 1 1 1 1\n0 0 0 1 0\n2 3\n1 1 1\n1 0 1\n3 3\n1 0 0\n1 1 1\n1 0 0");
        StickingStickers_18808.main(new String[] {});
        assertEquals("18", getOutput());
    }

    @Test
    void 예제2() throws IOException {
        setInput("1 3 3\n2 3\n1 0 0\n1 1 1\n1 1\n1\n3 1\n1\n1\n1");
        StickingStickers_18808.main(new String[] {});
        assertEquals("1", getOutput());
    }

    @Test
    void 예제3() throws IOException {
        setInput("2 3 3\n2 3\n1 1 1\n1 0 0\n2 1\n1\n1\n2 2\n1 0\n1 1");
        StickingStickers_18808.main(new String[] {});
        assertEquals("6", getOutput());
    }

    @Test
    void 예제4() throws IOException {
        setInput("4 5 4\n3 3\n1 0 1\n1 1 1\n0 1 0\n2 4\n1 1 1 1\n0 1 0 1\n1 4\n1 1 1 1\n4 2\n1 0\n1 1\n0 1\n0 1");
        StickingStickers_18808.main(new String[] {});
        assertEquals("17", getOutput());
    }

    @Test
    void 예제5() throws IOException {
        setInput("2 2 3\n3 1\n1\n1\n1\n2 3\n1 0 1\n1 1 1\n2 4\n1 0 1 1\n1 1 1 0");
        StickingStickers_18808.main(new String[] {});
        assertEquals("0", getOutput());
    }

    @Test
    void 예제6() throws IOException {
        setInput(
            "6 7 5\n4 6\n1 0 0 1 0 1\n1 1 0 1 0 1\n1 1 1 1 1 1\n0 0 0 1 0 0\n4 3\n0 1 0\n1 1 1\n0 1 1\n1 1 0\n3 6\n1 1 1 1 1 1\n0 0 1 0 0 0\n0 0 1 0 0 0\n6 6\n0 0 1 1 0 0\n1 1 1 1 0 1\n0 0 1 1 1 1\n0 0 1 1 1 1\n1 1 1 0 1 1\n0 1 0 0 1 0\n4 4\n1 1 1 1\n0 0 0 1\n0 0 1 1\n0 0 0 1");
        StickingStickers_18808.main(new String[] {});
        assertEquals("30", getOutput());
    }

    @Test
    void 예제7() throws IOException {
        setInput(
            "6 8 3\n4 5\n0 0 1 1 1\n1 1 1 0 1\n0 0 1 0 1\n0 0 1 0 0\n5 4\n0 0 1 0\n1 1 1 1\n1 1 0 1\n1 1 0 0\n1 1 0 0\n5 6\n0 0 1 1 1 1\n1 1 1 1 0 0\n1 1 1 1 1 0\n0 1 0 1 0 0\n0 1 0 1 0 0");
        StickingStickers_18808.main(new String[] {});
        assertEquals("22", getOutput());
    }

    @Test
    void 예제8() throws IOException {
        setInput(
            "8 6 6\n3 5\n0 1 0 0 0\n1 1 1 1 1\n0 1 0 0 1\n6 3\n0 0 1\n0 0 1\n0 0 1\n1 1 1\n1 0 1\n1 1 1\n6 3\n1 1 0\n1 0 0\n1 1 1\n1 0 1\n1 0 0\n1 0 0\n6 6\n0 0 0 0 1 0\n0 0 1 0 1 0\n0 0 1 0 1 0\n0 1 1 1 1 0\n0 1 1 0 1 1\n1 1 1 0 0 0\n4 5\n0 0 0 0 1\n1 0 0 1 1\n1 1 1 1 0\n1 1 0 1 0\n4 3\n1 1 0\n1 0 0\n1 1 1\n1 1 1");
        StickingStickers_18808.main(new String[] {});
        assertEquals("29", getOutput());
    }

}