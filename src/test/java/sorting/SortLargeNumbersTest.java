package sorting;

import array.LargestPermutation;
import org.junit.Test;
import test.FileBasedTest;

/**
 * @author iaroslavn
 * @since 08-Aug-17
 */
public class SortLargeNumbersTest {
    @Test
    public void testSortLargeNumbers00() throws Exception {
        FileBasedTest.execute(
                this.getClass(),
                SortLargeNumbers.class,
                "SortLargeNumbers.00.in.txt",
                "SortLargeNumbers.00.out.expected.txt"
        );
    }

    @Test
    public void testSortLargeNumbers01() throws Exception {
        FileBasedTest.execute(
                this.getClass(),
                SortLargeNumbers.class,
                "SortLargeNumbers.01.in.txt",
                "SortLargeNumbers.01.out.expected.txt"
        );
    }
}
