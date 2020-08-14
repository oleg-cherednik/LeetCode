/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return <tt>true</tt>
 * if the ransom note can be constructed from the magazines; otherwise, it will return <tt>false</tt>.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * <p>
 * <b>Note:</b><br>
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * <pre>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 03.05.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(canConstruct("a", "b"));     // false
        System.out.println(canConstruct("aa", "ab"));   // false
        System.out.println(canConstruct("aa", "aab"));  // true
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];

        for (int i = 0; i < magazine.length(); i++)
            arr[magazine.charAt(i) - 'a']++;

        for (int i = 0; i < ransomNote.length(); i++) {
            int offs = ransomNote.charAt(i) - 'a';
            if (arr[offs] > 0)
                arr[offs]--;
            else
                return false;
        }

        return true;
    }

}

