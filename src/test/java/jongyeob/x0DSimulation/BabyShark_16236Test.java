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

class BabyShark_16236Test {
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
        setInput("3\n0 0 0\n0 0 0\n0 9 0");
        BabyShark_16236.main(new String[] {});
        assertEquals("0", getOutput());
    }

    @Test
    void 예제2() throws IOException {
        setInput("3\n0 0 1\n0 0 0\n0 9 0");
        BabyShark_16236.main(new String[] {});
        assertEquals("3", getOutput());
    }

    @Test
    void 예제3() throws IOException {
        setInput("4\n4 3 2 1\n0 0 0 0\n0 0 9 0\n1 2 3 4");
        BabyShark_16236.main(new String[] {});
        assertEquals("14", getOutput());
    }

    @Test
    void 예제4() throws IOException {
        setInput("6\n5 4 3 2 3 4\n4 3 2 3 4 5\n3 2 9 5 6 6\n2 1 2 3 4 5\n3 2 1 6 5 4\n6 6 6 6 6 6");
        BabyShark_16236.main(new String[] {});
        assertEquals("60", getOutput());
    }

    @Test
    void 예제5() throws IOException {
        setInput("6\n6 0 6 0 6 1\n0 0 0 0 0 2\n2 3 4 5 6 6\n0 0 0 0 0 2\n0 2 0 0 0 0\n3 9 3 0 0 1");
        BabyShark_16236.main(new String[] {});
        assertEquals("48", getOutput());
    }

    @Test
    void 예제6() throws IOException {
        setInput("6\n1 1 1 1 1 1\n2 2 6 2 2 3\n2 2 5 2 2 3\n2 2 2 4 6 3\n0 0 0 0 0 6\n0 0 0 0 0 9");
        BabyShark_16236.main(new String[] {});
        assertEquals("39", getOutput());
    }

}
