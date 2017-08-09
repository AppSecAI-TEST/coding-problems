package sorting;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Source: <a href="https://www.hackerrank.com/challenges/big-sorting">HackerRank</a>
 * <p>
 * Consider an array of numeric strings, where each string is a positive number
 * with anywhere from 1 to 10^6 digits. Sort the array's elements in non-decreasing
 * (i.e., ascending) order of their real-world integer values and print each element
 * of the sorted array on a new line.
 * </p>
 * <p>
 * Input Format:<br/>
 * The first line contains an integer, n, denoting the number of strings in the array.<br/>
 * Each of the  subsequent lines contains a string of integers describing an element of the array.
 * </p>
 * <p>
 * Constraints:<br/>
 * 1 <= n <= 2 * 10^5<br/>
 * Each string is guaranteed to represent a positive integer without leading zeros.<br/>
 * The total number of digits across all strings in the array is between 1 and  10^6 (inclusive).
 * </p>
 * <p>
 * Output Format:<br/>
 * Print each element of the sorted array on a new line.
 * </p>
 * <hr/>
 * <p>
 * Sample Input #1:<br/>
 * <pre>
 *     6
 *     31415926535897932384626433832795
 *     1
 *     3
 *     10
 *     3
 *     5
 *     </pre>
 * </p>
 * <p>
 * Sample Output #1:<br/>
 * <pre>
 *     1
 *     3
 *     3
 *     5
 *     10
 *     31415926535897932384626433832795
 *     </pre>
 * </p>
 *
 * @author iaroslavn
 * @since 08-Aug-17
 */
public class SortLargeNumbers {
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out))
        ) {

            int n = in.nextInt();
            String[] unsorted = new String[n];
            IntStream.range(0, n)
                    .forEach(i -> unsorted[i] = in.next());

            Arrays.sort(unsorted, (s1, s2) -> {
                // first sort by length
                int cmp = Integer.compare(s1.length(), s2.length());
                // sorts strings of the same length lexicographically
                return cmp != 0 ? cmp : s1.compareTo(s2);
            });

            Arrays.stream(unsorted).forEach(out::println);
            out.flush();
        }
    }
}
