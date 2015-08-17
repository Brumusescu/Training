/**
 * Created by dbrumusescu on 8/17/2015.
 *
 * Given a non-empty string and an int N, return the string made starting with char 0,
 * and then every Nth char of the string.
 * So if N is 3, use char 0, 3, 6, ... and so on.
 * N is 1 or more.
 */
public class Exercise5 {
    public static String everyNth (String word, int no) {
        String newWord = "";
        for (int i = 0; i < word.length(); i+=no) {
            newWord += word.substring(i, i+1);
        }
        return newWord;
    }
    public static void main(String[] args) {
        System.out.println(everyNth("Miracle", 2));
        System.out.println(everyNth("abcdefg", 2));
        System.out.println(everyNth("abcdefg", 3));
    }
}
