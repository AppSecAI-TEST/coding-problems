package array;

import org.junit.Test;
import test.FileBasedTest;

/**
 * @author Yaroslav
 * @since 04-Mar-17
 */
public class LargestPermutationTest {
    @Test
    public void testLargestPermutation00() throws Exception {
        FileBasedTest.execute(
                this.getClass(),
                LargestPermutation.class,
                "LargestPermutation.00.in.txt",
                "LargestPermutation.00.out.expected.txt"
        );
    }

    @Test
    public void testLargestPermutation01() throws Exception {
        FileBasedTest.execute(
                this.getClass(),
                LargestPermutation.class,
                "LargestPermutation.01.in.txt",
                "LargestPermutation.01.out.expected.txt"
        );
    }

    @Test
    public void testLargestPermutation02() throws Exception {
        FileBasedTest.execute(
                this.getClass(),
                LargestPermutation.class,
                "LargestPermutation.02.in.txt",
                "LargestPermutation.02.out.expected.txt"
        );
    }

    @Test
    public void testLargestPermutation03() throws Exception {
        FileBasedTest.execute(
                this.getClass(),
                LargestPermutation.class,
                "LargestPermutation.03.in.txt",
                "LargestPermutation.03.out.expected.txt"
        );
    }

    @Test
    public void testLargestPermutationLarge04() throws Exception {
        FileBasedTest.execute(
                this.getClass(),
                LargestPermutation.class,
                "LargestPermutation.04.in.txt",
                "LargestPermutation.04.out.expected.txt"
        );
    }

    @Test
    public void testLargestPermutationLarge05() throws Exception {
        FileBasedTest.execute(
                this.getClass(),
                LargestPermutation.class,
                "LargestPermutation.05.in.txt",
                "LargestPermutation.05.out.expected.txt"
        );
    }
}