package jongyeob.x1ATopologicalSort;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ACMCraft_1005Test {
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
        setInput(
            "2\n4 4\n10 1 100 10\n1 2\n1 3\n2 4\n3 4\n4\n8 8\n10 20 1 5 8 7 1 43\n1 2\n1 3\n2 4\n2 5\n3 6\n5 7\n6 7\n7 8\n7");
        ACMCraft_1005.main(new String[] {});
        assertEquals("120\n39", getOutput());
    }

    @Test
    void 예제2() throws IOException {
        setInput(
            "5\n3 2\n1 2 3\n3 2\n2 1\n1\n4 3\n5 5 5 5\n1 2\n1 3\n2 3\n4\n5 10\n100000 99999 99997 99994 99990\n4 5\n3 5\n3 4\n2 5\n2 4\n2 3\n1 5\n1 4\n1 3\n1 2\n4\n4 3\n1 1 1 1\n1 2\n3 2\n1 4\n4\n7 8\n0 0 0 0 0 0 0\n1 2\n1 3\n2 4\n3 4\n4 5\n4 6\n5 7\n6 7\n7");
        ACMCraft_1005.main(new String[] {});
        assertEquals("6\n5\n399990\n2\n0", getOutput());
    }
}