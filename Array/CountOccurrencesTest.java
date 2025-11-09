package Array;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Lightweight unit tests for CountOccurrences without external frameworks.
 * Simulates System.in and captures System.out to verify behavior.
 */
public class CountOccurrencesTest {
    private static String runMainWithInput(String input) throws Exception {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos, true, "UTF-8");
        try {
            System.setIn(bais);
            System.setOut(ps);
            CountOccurrences.main(new String[0]);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
            ps.flush();
        }
        String out = baos.toString("UTF-8");
        // Normalize line endings for stable assertions
        return out.replace("\r\n", "\n");
    }

    private static void assertContains(String full, String expected) {
        if (!full.contains(expected)) {
            throw new AssertionError("Expected output to contain:\n" + expected + "\nBut was:\n" + full);
        }
    }

    public static void main(String[] args) throws Exception {
        testDuplicatesAndBounds();
        testOutOfRangeIgnored();
        testImmediateZeroStops();
        testNonIntegerStopsLoop();
        testMixedIntThenNonInt();
        System.out.println("All tests passed");
    }

    static void testDuplicatesAndBounds() throws Exception {
        String out = runMainWithInput("1 2 2 50 0\n");
        assertContains(out, "Enter the integers between 1 and 50 (end with 0): ");
        assertContains(out, "  read 1: freq[1] = 1");
        assertContains(out, "  read 2: freq[2] = 1");
        assertContains(out, "  read 2: freq[2] = 2");
        assertContains(out, "  read 50: freq[50] = 1");
        assertContains(out, "1 occurs 1 time");
        assertContains(out, "2 occurs 2 times");
        assertContains(out, "50 occurs 1 time");
    }

    static void testOutOfRangeIgnored() throws Exception {
        String out = runMainWithInput("-1 51 0\n");
        assertContains(out, "  ignored -1");
        assertContains(out, "  ignored 51");
        if (out.contains(" occurs ")) {
            throw new AssertionError("Expected no summary lines for out-of-range only input");
        }
    }

    static void testImmediateZeroStops() throws Exception {
        String out = runMainWithInput("0\n");
        if (out.contains("read") || out.contains("ignored") || out.contains(" occurs ")) {
            throw new AssertionError("Expected no processing after immediate 0");
        }
    }

    static void testNonIntegerStopsLoop() throws Exception {
        String out = runMainWithInput("a\n");
        if (out.contains("read") || out.contains("ignored") || out.contains(" occurs ")) {
            throw new AssertionError("Expected break on non-integer with no summary");
        }
    }

    static void testMixedIntThenNonInt() throws Exception {
        String out = runMainWithInput("3 x\n");
        assertContains(out, "  read 3: freq[3] = 1");
        assertContains(out, "3 occurs 1 time");
    }
}