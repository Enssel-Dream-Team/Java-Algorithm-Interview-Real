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

class Surveillance_15683Test {
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
        setInput("4 6\n0 0 0 0 0 0\n0 0 0 0 0 0\n0 0 1 0 6 0\n0 0 0 0 0 0");
        Surveillance_15683.main(new String[] {});
        assertEquals("20", getOutput());
    }

    @Test
    void 예제2() throws IOException {
        setInput("6 6\n0 0 0 0 0 0\n0 2 0 0 0 0\n0 0 0 0 6 0\n0 6 0 0 2 0\n0 0 0 0 0 0\n0 0 0 0 0 5");
        Surveillance_15683.main(new String[] {});
        assertEquals("15", getOutput());
    }

    @Test
    void 예제3() throws IOException {
        setInput("6 6\n1 0 0 0 0 0\n0 1 0 0 0 0\n0 0 1 0 0 0\n0 0 0 1 0 0\n0 0 0 0 1 0\n0 0 0 0 0 1");
        Surveillance_15683.main(new String[] {});
        assertEquals("6", getOutput());
    }

    @Test
    void 예제4() throws IOException {
        setInput("6 6\n1 0 0 0 0 0\n0 1 0 0 0 0\n0 0 1 5 0 0\n0 0 5 1 0 0\n0 0 0 0 1 0\n0 0 0 0 0 1");
        Surveillance_15683.main(new String[] {});
        assertEquals("2", getOutput());
    }

    @Test
    void 예제5() throws IOException {
        setInput("1 7\n0 1 2 3 4 5 6");
        Surveillance_15683.main(new String[] {});
        assertEquals("0", getOutput());
    }

    @Test
    void 예제6() throws IOException {
        setInput("3 7\n4 0 0 0 0 0 0\n0 0 0 2 0 0 0\n0 0 0 0 0 0 4");
        Surveillance_15683.main(new String[] {});
        assertEquals("0", getOutput());
    }

}