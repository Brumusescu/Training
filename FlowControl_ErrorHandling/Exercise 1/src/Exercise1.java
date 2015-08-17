/**
 * Created by dbrumusescu on 8/17/2015.
 *
 * We have two monkeys, a and b, and the parameters aSmile and bSmile indicate if each is smiling.
 * We are in trouble if they are both smiling or if neither of them is smiling.
 * Return true if we are in trouble.
 */
public class Exercise1 {
    public static boolean monkeyTruble (boolean aSmile, boolean bSmile) {
        if ((aSmile && bSmile) || (!aSmile && !bSmile)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        if (monkeyTruble(true, true)) {
            System.out.println("Both smiling!");
        }
        if (!monkeyTruble(true, false)) {
            System.out.println("Second is not smiling!");
        }
        if (!monkeyTruble(false, true)) {
            System.out.println("First is not smiling!");
        }
        if (monkeyTruble(false, false)) {
            System.out.println("Both are not smiling!");
        }
    }
}
