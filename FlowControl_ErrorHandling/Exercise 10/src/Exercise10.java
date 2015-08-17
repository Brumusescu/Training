/**
 * Created by dbrumusescu on 8/17/2015.
 */
public class Exercise10 {
    private static int testReturn(int a, int b) {
        try {
            int div = a/b;
            return 1;
        }
        catch (Exception e) {
            return 2;
        }
        finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println("The result is: " + testReturn(10, 0));
    }
}
