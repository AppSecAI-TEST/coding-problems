package sorting;


import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <h1>Counting Sort</h1>
 *
 * <h2>Time Complexity</h2>
 * <p>
 * O(n+k) where n is the number of elements in input array and k is the range of input.
 * </p>
 *
 * <h2>Space Complexity</h2>
 * <p>
 * O(n+k)
 * </p>
 *
 * Source: <a href="http://practice.geeksforgeeks.org/problems/largest-even-number/0">Geeks for Geeks</a>
 * <p>
 * As usual Babul is back with his problem but this time with numbers.
 * In his problem there is a number P (always a whole number) with N digits.
 * Now he started finding out the largest possible even number formed by rearranging
 * this N digit number. For example consider number 1324, after rearranging the digits
 * the largest even number possible is 4312.
 * </p>
 * <p>
 * Input Format:<br/>
 * The first line of input will contain an integer T which is the no. of test cases.
 * Each of the next T lines will contain a number P.
 * </p>
 * <p>
 * Constraints:<br/>
 * 1<=T<=100<br/>
 * 1<=N<=1000
 * </p>
 * <p>
 * Output Format:<br/>
 * For each test case in a new line print the required result.
 * </p>
 * <hr/>
 * <p>
 * Sample Input #1:<br/>
 * <pre>
 * 5
 * 1324
 * 3415436
 * 1023422
 * 03517
 * 3555
 * </pre>
 * </p>
 * <p>
 * Sample Output #1:<br/>
 * <pre>
 * 4312
 * 6543314
 * 4322210
 * 75310
 * 5553
 * </pre>
 * </p>
 *
 * @author iaroslavn
 * @since 11-Aug-17
 */
public class CountingSort {
    public static void main (String[] args) {
        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out))
        ){
            int T = in.nextInt();
            IntStream.range(0, T).forEach(i -> {
                String P = in.next();
                int[] a = toIntArray(P);
                sort(a);
                reverse(a);

                // replace the last digit with even number if any
                int evenPos = a.length-1;
                while (evenPos > 0 && a[evenPos] % 2 != 0) evenPos--;
                if (a[evenPos] % 2 == 0) {
                    int[] result = new int[a.length];
                    if (evenPos > 0) {
                        System.arraycopy(a, 0, result, 0, evenPos);
                    }
                    if (evenPos + 1 < a.length) {
                        System.arraycopy(a, evenPos + 1, result, evenPos, a.length - evenPos - 1);
                    }
                    result[a.length - 1] = a[evenPos];
                    a = result;
                }
                out.println(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining("")));
            });
        }
    }

    private static int[] toIntArray(String s) {
        return s.chars().map(c -> Integer.valueOf("" + (char) c)).toArray();
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            swap(a, i, a.length - i - 1);
        }
    }

    private static void sort(int[] a) {
        final int RANGE_SIZE = 10; // all elements are digits from 0 to 9
        int[] index = new int[RANGE_SIZE];

        // store count of each digit
        Arrays.stream(a).forEach(item -> index[item]++);

        // change index[i] so that index[i] now contains actual
        // position of this digit in output array
        for (int i = 1; i < index.length; i++) {
            index[i] += index[i - 1];
        }

        // build the output array
        int[] sorted = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            sorted[--index[a[i]]] = a[i];
        }

        // replace the original array with the sorted results
        System.arraycopy(sorted, 0, a, 0, sorted.length);
    }
}
