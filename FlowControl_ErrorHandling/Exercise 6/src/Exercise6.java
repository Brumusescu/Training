/**
 * Created by dbrumusescu on 8/17/2015.
 *
 * Given an array of scores, return true if each score is equal or greater than the one before.
 * The array will be length 2 or more.
 */
public class Exercise6 {
    public static boolean scoresIncreasing (int[] scores) {
        for (int i = 1; i < scores.length; i++) {
            if (scores[i-1] > scores[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int []score1 = {1, 2, 3, 10};
        int []score2 = {1, 4, 2, 5};
        System.out.println(scoresIncreasing(score1));
        System.out.println(scoresIncreasing(score2));
    }
}
