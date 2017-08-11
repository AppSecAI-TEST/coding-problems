package sorting;

import org.junit.Test;
import test.FileBasedTest;

/**
 * @author iaroslavn
 * @since 11-Aug-17
 */
public class CountingSortTest {
    @Test
    public void testCountingSort00() throws Exception {
        FileBasedTest.execute(
                this.getClass(),
                CountingSort.class,
                "CountingSort.00.in.txt",
                "CountingSort.00.out.expected.txt"
        );
    }
}
