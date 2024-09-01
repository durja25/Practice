import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {

        String s = "";
        String t = "";

//        s = "rat";
//        t = "car";
        s = "anagram";
        t = "nagaram";
//        s = "ab";
//        t = "a";
        // what is time complexity of this approach
        // Time complexity of this approach is O(n)
        System.out.println(isAnagram2(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> seen = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (char c : s.toCharArray()) {
            seen.put(c, seen.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            seen.put(c, seen.getOrDefault(c, 0) - 1);
        }

        for (int var :  seen.values()) {
            if (var != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagram2(String s, String t) {

        // is anagram valid  if the length of both strings are same then only we can compare them
        if (s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[128];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if (letters[t.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }
}
