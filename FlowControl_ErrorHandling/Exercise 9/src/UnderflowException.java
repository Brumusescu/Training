/**
 * Created by dbrumusescu on 8/17/2015.
 */
public class UnderflowException extends RuntimeException {
    public UnderflowException () {
        System.out.println("Average lower than Integer.MIN_VALUE!");
    }
}
