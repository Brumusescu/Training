/**
 * Created by dbrumusescu on 8/17/2015.
 *
 * We have a loud talking parrot.
 * The "hour" parameter is the current hour time in the range 0..23.
 * We are in trouble if the parrot is talking and the hour is before 7 or after 20.
 * Return true if we are in trouble. 
 */
public class Exercise2 {
    public static boolean parrotTrouble (boolean talking, int hour) {
        if (talking && (hour < 7 || hour > 20)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        if (parrotTrouble(true, 6)) {
            System.out.println("Talking before 7!");
        }
        if (parrotTrouble(true, 21)) {
            System.out.println("Talking after 20!");
        }
        if (!parrotTrouble(true, 15)) {
            System.out.println("Talking at day time!");
        }
        if (!parrotTrouble(false, 6)) {
            System.out.println("Quiet before 7!");
        }
        if (!parrotTrouble(false, 21)) {
            System.out.println("Quiet after 20!");
        }
        if (!parrotTrouble(false, 15)) {
            System.out.println("Quiet at day time!");
        }
    }
}
