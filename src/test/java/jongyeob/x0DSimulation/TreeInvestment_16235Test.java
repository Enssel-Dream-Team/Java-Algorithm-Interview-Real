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

class TreeInvestment_16235Test {
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
        setInput("1 1 1\n1\n1 1 1");
        TreeInvestment_16235.main(new String[] {});
        assertEquals("1", getOutput());
    }

    @Test
    void 예제2() throws IOException {
        setInput("1 1 4\n1\n1 1 1");
        TreeInvestment_16235.main(new String[] {});
        assertEquals("0", getOutput());
    }

    @Test
    void 예제3() throws IOException {
        setInput("5 2 1\n2 3 2 3 2\n2 3 2 3 2\n2 3 2 3 2\n2 3 2 3 2\n2 3 2 3 2\n2 1 3\n3 2 3");
        TreeInvestment_16235.main(new String[] {});
        assertEquals("2", getOutput());
    }

    @Test
    void 예제4() throws IOException {
        setInput("5 2 2\n2 3 2 3 2\n2 3 2 3 2\n2 3 2 3 2\n2 3 2 3 2\n2 3 2 3 2\n2 1 3\n3 2 3");
        TreeInvestment_16235.main(new String[] {});
        assertEquals("15", getOutput());
    }

    @Test
    void 예제5() throws IOException {
        setInput("5 2 3\n2 3 2 3 2\n2 3 2 3 2\n2 3 2 3 2\n2 3 2 3 2\n2 3 2 3 2\n2 1 3\n3 2 3");
        TreeInvestment_16235.main(new String[] {});
        assertEquals("13", getOutput());
    }

    @Test
    void 예제6() throws IOException {
        setInput("5 2 4\n2 3 2 3 2\n2 3 2 3 2\n2 3 2 3 2\n2 3 2 3 2\n2 3 2 3 2\n2 1 3\n3 2 3");
        TreeInvestment_16235.main(new String[] {});
        assertEquals("13", getOutput());
    }

    @Test
    void 예제7() throws IOException {
        setInput("5 2 5\n2 3 2 3 2\n2 3 2 3 2\n2 3 2 3 2\n2 3 2 3 2\n2 3 2 3 2\n2 1 3\n3 2 3");
        TreeInvestment_16235.main(new String[] {});
        assertEquals("13", getOutput());
    }

    @Test
    void 예제8() throws IOException {
        setInput("5 2 6\n2 3 2 3 2\n2 3 2 3 2\n2 3 2 3 2\n2 3 2 3 2\n2 3 2 3 2\n2 1 3\n3 2 3");
        TreeInvestment_16235.main(new String[] {});
        assertEquals("85", getOutput());
    }

}