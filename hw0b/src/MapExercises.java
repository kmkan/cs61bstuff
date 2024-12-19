import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        char currentLetter = 'a';
        for (int i = 1; i <= 26; i++) {
            map.put(currentLetter++, i);
        }

        return map;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        Map<Integer, Integer> squares = new TreeMap<Integer, Integer>();

        for (int elem : nums) {
            squares.put(elem, elem * elem);
        }

        return squares;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> count = new TreeMap<String, Integer>();
        for (String word : words) {
            if (count.containsKey(word)) {
                int wordCount = count.get(word);
                count.put(word, wordCount + 1);
            } else {
                count.put(word, 1);
            }
        }

        return count;
    }
}
