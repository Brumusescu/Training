import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbrumusescu on 8/17/2015.
 */
public class Exercise9 {
    private static Integer add (Integer a, Integer b) {
        int sum = a + b;

        try {
            if (sum == 0) {
                throw new OverflowException();
            }
        }
        catch (OverflowException ex) {
            System.out.println(ex);
        }
        return sum;
    }

    private static Integer divide (Integer a, Integer b){
        int div = a / b;
        try {
            if (div == 0) {
                throw new UnderflowException();
            }
        }
        catch (UnderflowException ex) {
            System.out.println(ex);
        }
        return div;
    }

    private static Integer average (List<Integer> elementList) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < elementList.size(); i++) {
            sum = add(sum, elementList.get(i));
            count++;
        }
        return divide(sum, count);
    }

    public static void main(String[] args) throws OverflowException, UnderflowException {
        System.out.println(Integer.MAX_VALUE);
        List<Integer> elementList = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            elementList.add(Integer.MAX_VALUE + 1);
        }

        int av = average(elementList);
        System.out.println("Average = " + av);
    }

}
