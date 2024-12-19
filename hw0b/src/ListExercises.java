import java.util.List;
import java.util.ArrayList;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        int sum = 0;
        for (int elem : L) {
            sum += elem;
        }

        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> evenLst = new ArrayList<Integer>();

        for (int elem : L) {
            if (elem % 2 == 0) {
                evenLst.add(elem);
            }
        }

        return evenLst;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> commonItems = new ArrayList<Integer>();

        for (int elem : L1) {
            if (L2.contains(elem)) {
                commonItems.add(elem);
            }
        }

        return commonItems;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int totalCount = 0;

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c){
                    totalCount++;
                }
            }
        }

        return totalCount;
    }
}
