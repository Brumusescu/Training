/**
 * Created by dbrumusescu on 8/17/2015.
 *
 * Given two int values, return true if one is negative and one is positive.
 * Except if the parameter "negative" is true, then return true only if both are negative.
 */
public class Exercise3 {
    public static boolean posNeg (int a, int b, boolean negative) {
        if (negative) {
            if ((a < 0) && (b < 0)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (((a < 0) && (b > 0)) || ((a > 0) && (b < 0))) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        if (posNeg(1, -1, false)) {
            System.out.println("True");
        }
        if (posNeg(-5, 2, false)) {
            System.out.println("True");
        }
        if (!posNeg(1, -1, true)) {
            System.out.println("False");
        }
        if (!posNeg(-5, 1, true)) {
            System.out.println("False");
        }
        if (posNeg(-4, -5, true)) {
            System.out.println("True");
        }
        if (!posNeg(-4, -5, false)) {
            System.out.println("False");
        }
        if (!posNeg(1, 2, true)) {
            System.out.println("False");
        }
        if (!posNeg(1, 2, false)) {
            System.out.println("False");
        }
    }
}
