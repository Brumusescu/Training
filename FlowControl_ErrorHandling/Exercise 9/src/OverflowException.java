/**
 * Created by dbrumusescu on 8/17/2015.
 */
public class OverflowException extends Exception {
    public OverflowException () {
        System.out.println("Average higher than Integer.MAX_VALUE!");
    }
}
