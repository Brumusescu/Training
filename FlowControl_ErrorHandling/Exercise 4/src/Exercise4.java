/**
 * Created by dbrumusescu on 8/17/2015.
 *
 * Given a string, take the last char and return a new string with the last char added at the front and back,
 * so "cat" yields "tcatt".
 * The original string will be length 1 or more.
 */
public class Exercise4 {
    public static String backAround (String word) {
        String lastLetter = word.substring(word.length()-1);
        word = lastLetter + word + lastLetter;
        return word;
    }
    public static void main(String[] args) {
        System.out.println(backAround("cat"));
        System.out.println(backAround("Heloo"));
        System.out.println(backAround("a"));
    }
}
