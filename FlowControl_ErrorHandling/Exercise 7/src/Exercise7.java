/**
 * Created by dbrumusescu on 8/17/2015.
 *
 * We have an array of heights, representing the altitude along a walking trail.
 * Given start/end indexes into the array,
 * return the sum of the changes for a walk beginning at the start index and ending at the end index.
 * For example, with the heights {5, 3, 6, 7, 2} and start=2, end=4 yields a sum of 1 + 5 = 6.
 * The start end end index will both be valid indexes into the array with start <= end.
 */
public class Exercise7 {
    private static int getHigh (int start, int end) {
        if (start > end) {
            return (start - end);
        }
        return (end - start);
    }

    private static int sumHeights (int [] heights, int start, int end) {
        int sum = 0;
        if (start < 0 || end > heights.length) {
            return 0;
        }
        for (int i = start; i <= end-1; i++) {
            sum += getHigh(heights[i], heights [i+1]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int []heights = {5, 3, 6, 7, 2};
        System.out.println(sumHeights(heights, 2, 4));
        System.out.println(sumHeights(heights, 0, 1));
        System.out.println(sumHeights(heights, 0, 4));
    }
}
