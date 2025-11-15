package ObjClasses;

/**
 * Test program for the StopWatch class that measures execution time
 * of sorting 100,000 numbers using selection sort algorithm.
 */
public class TestStopWatch {
    public static void main(String[] args) {
        StopWatch st = new StopWatch();
        st.start();
        selectionSort(initArray());
        st.stop();

        System.out.println("Execution time for sorting 100,00 numbers using selection sort:");
        System.out.println(st.getElapsedTime() + " milliseconds");

    }

    public static void selectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {

            for (int j = i + 1; j < array.length; j++) {

                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;

                }
            }
        }

    }

    public static int[] initArray() {
        int[] array = new int[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = (int) (Math.random() * 100000);
        }
        return array;
    }
}

/**
 * StopWatch class for measuring elapsed time in milliseconds
 * 
 * UML Diagram:
 * +------------------+
 * | StopWatch |
 * +------------------+
 * | - startTime: long|
 * | - endTime: long |
 * +------------------+
 * | + StopWatch() |
 * | + start(): void |
 * | + stop(): void |
 * | + getElapsedTime(): long |
 * | + getStartTime(): long |
 * | + getEndTime(): long |
 * +------------------+
 */
class StopWatch {
    // Private data fields
    private long startTime;
    private long endTime;

    /**
     * No-argument constructor that initializes startTime with current time
     */
    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    /**
     * Resets startTime to the current time
     */
    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    /**
     * Sets endTime to the current time
     */
    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    /**
     * Returns the elapsed time for the stopwatch in milliseconds
     * 
     * @return elapsed time in milliseconds
     */
    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }

    /**
     * Returns the start time
     * 
     * @return start time in milliseconds
     */
    public long getStartTime() {
        return this.startTime;
    }

    /**
     * Returns the end time
     * 
     * @return end time in milliseconds
     */
    public long getEndTime() {
        return this.endTime;
    }
}