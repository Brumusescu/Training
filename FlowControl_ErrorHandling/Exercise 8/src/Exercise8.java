/**
 * Created by dbrumusescu on 8/17/2015.
 *
 * Write a method which throws OutOfMemoryError and one which throws StackOverflowError.
 * Can you continue running the program after intercepting the error?
 */
public class Exercise8 {
    private static void outOfMemoryError () {
        try {
            long[] ll = new long[1024*1024*1024];
            System.out.println(ll);
        }
        catch (OutOfMemoryError outOfMemoryError) {
            System.out.println(outOfMemoryError.getMessage());
        }
    }

    private static int recursiveIterator (int no) {
        if (no == 0) {
            return 0;
        }
        else {
            return recursiveIterator(no++);
        }
    }

    private static void stackOverflowError () {
        try {
            System.out.println(recursiveIterator(5));
        }
        catch (StackOverflowError stackOverflowError) {
            System.out.println(stackOverflowError.getMessage());
        }
    }

    public static void main(String[] args) {
        outOfMemoryError();
        stackOverflowError();
    }
}
