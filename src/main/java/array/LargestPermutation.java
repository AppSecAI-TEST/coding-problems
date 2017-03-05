package array;

/**
 * Source: <a href="https://www.hackerrank.com/challenges/largest-permutation">HackerRank</a>
 * <p>
 *     You are given an array N of integers which is a permutation of N the first natural numbers.
 *     You can swap any two elements of the array. You can make at most K swaps.
 *     What is the largest permutation, in numerical order, you can make?
 * </p>
 * <p>
 *     Constraints:<br/>
 *     1 <= N <= 10^5<br/>
 *     1 <= K <= 10^9
 * </p>
 * <hr/>
 * <p>
 *     Sample Input #1:<br/>
 *     N=5, K=1<br/>
 *     array = {4, 2, 3, 5, 1}
 * </p>
 * <p>
 *     Sample Output #1:<br/>
 *     array = {5, 2, 3, 4, 1}
 * </p>
 * <hr/>
 * <p>
 *     Sample Input #2:<br/>
 *     N=3, K=1<br/>
 *     array = {2, 1, 3}
 * </p>
 * <p>
 *     Sample Output #2:<br/>
 *     array = {3, 1, 2}
 * </p>
 *
 * @author iaroslavn
 * @since 04-Mar-17
 */
public class LargestPermutation {

    private static int[] solve(int n, int k, int[] a) {

        int[] idx_array = new int[n + 1];
        for (int i = 0; i < n; i++) {
            idx_array[a[i]] = i;
        }

        for (int i = n; i > 0 && k > 0; i--) {
            if (a[n - i] == i) {
                continue;
            }
            // swap elements at 0 index and at the index of n-th element
            //               at 1 index and at the index of (n-1)-th element
            swap(n - i, idx_array[i], a);
            // update indices of elements after swap
            swap(a[n - i], a[idx_array[i]],idx_array);

            k--;
        }

        return a;
    }

    private static void swap(int i, int j, int[] a) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        a = solve(n, k, a);

        for(int e : a) {
            System.out.print(e + " ");
        }
    }
}
