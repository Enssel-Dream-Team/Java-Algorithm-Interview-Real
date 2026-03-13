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

class WizardSharkAndTornado_20057Test {
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
        setInput("5\n0 0 0 0 0\n0 0 0 0 0\n0 10 0 0 0\n0 0 0 0 0\n0 0 0 0 0");
        WizardSharkAndTornado_20057.main(new String[] {});
        assertEquals("10", getOutput());
    }

    @Test
    void 예제2() throws IOException {
        setInput("5\n0 0 0 0 0\n0 0 0 0 0\n0 100 0 0 0\n0 0 0 0 0\n0 0 0 0 0");
        WizardSharkAndTornado_20057.main(new String[] {});
        assertEquals("85", getOutput());
    }

    @Test
    void 예제3() throws IOException {
        setInput(
            "7\n1 2 3 4 5 6 7\n1 2 3 4 5 6 7\n1 2 3 4 5 6 7\n1 2 3 0 5 6 7\n1 2 3 4 5 6 7\n1 2 3 4 5 6 7\n1 2 3 4 5 6 7");
        WizardSharkAndTornado_20057.main(new String[] {});
        assertEquals("139", getOutput());
    }

    @Test
    void 예제4() throws IOException {
        setInput(
            "5\n100 200 300 400 200\n300 243 432 334 555\n999 111 0 999 333\n888 777 222 333 900\n100 200 300 400 500");
        WizardSharkAndTornado_20057.main(new String[] {});
        assertEquals("7501", getOutput());
    }

    @Test
    void 예제5() throws IOException {
        setInput("5\n0 0 100 0 0\n0 0 100 0 0\n0 0 0 0 0\n0 0 100 0 0\n0 0 100 0 0");
        WizardSharkAndTornado_20057.main(new String[] {});
        assertEquals("283", getOutput());
    }

    @Test
    void 예제6() throws IOException {
        setInput(
            "9\n193 483 223 482 858 274 847 283 748\n484 273 585 868 271 444 584 293 858\n828 384 382 818 347 858 293 999 727\n818 384 727 373 636 141 234 589 991\n913 564 555 827 0 999 123 123 123\n321 321 321 983 982 981 983 980 990\n908 105 270 173 147 148 850 992 113\n943 923 982 981 223 131 222 913 562\n752 572 719 590 551 179 141 137 731");
        WizardSharkAndTornado_20057.main(new String[] {});
        assertEquals("22961", getOutput());
    }

}
