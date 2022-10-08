import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * You are given a string <tt>s</tt> and an array of strings <tt>words</tt>. All the strings of words are of
 * <b>the same length</b>.
 * <p>
 * A <b>concatenated substring</b> in <tt>s</tt> is a substring that contains all the strings of any permutation of
 * <tt>words</tt> concatenated.
 * <ul>
 * <li>For example, if <tt>words = ["ab","cd","ef"]</tt>, then <tt>"abcdef"</tt>, <tt>"abefcd"</tt>, <tt>"cdabef"</tt>,
 * <tt>"cdefab"</tt>, <tt>"efabcd"</tt>, and <tt>"efcdab"</tt> are all concatenated strings. <tt>"acdbef"</tt> is not a
 * concatenated substring because it is not the concatenation of any permutation of <tt>words</tt>.</li>
 * </ul>
 * Return <i>the starting indices of all the concatenated substrings in <tt>s</tt></i>. You can return the answer in
 * <b>any order</b>.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Since words.length == 2 and words[i].length == 3, the concatenated substring has to be of length 6.
 * The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
 * The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
 * The output order does not matter. Returning [9,0] is fine too.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * Explanation: Since words.length == 4 and words[i].length == 4, the concatenated substring has to be of length 16.
 * There is no substring of length 16 is s that is equal to the concatenation of any permutation of words.
 * We return an empty array.
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 * Explanation: Since words.length == 3 and words[i].length == 3, the concatenated substring has to be of length 9.
 * The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"] which is a permutation of words.
 * The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"] which is a permutation of words.
 * The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"] which is a permutation of words.
 * </pre>
 * <ul>
 * <b>Constraints:</b>
 * <li><tt>1 <= s.length <= 10<sup>4</sup></tt></li>
 * <li><tt>1 <= words.length <= 5000</tt></li>
 * <li><tt>1 <= words[i].length <= 30</tt></li>
 * <li><tt><tt>s</tt> and <tt>words[i]</tt> consist of lowercase English letters</tt></li>
 * </ul>
 *
 * @author Oleg Cherednik
 * @since 08.10.2022
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[] { "foo", "bar" })); // [0, 9]
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "word" })); // []
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[] { "bar", "foo", "the" })); // [6, 9, 12]
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "word" })); // []
        System.out.println(findSubstring("a", new String[] { "a" })); // [0]
        System.out.println(findSubstring("pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyx"
                                                 + "gjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdv"
                                                 + "ccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvq"
                                                 + "fiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayf"
                                                 + "sxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekc"
                                                 + "pjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspe"
                                                 + "otkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpi"
                                                 + "pguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombia"
                                                 + "mxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqk"
                                                 + "scekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapooje"
                                                 + "gggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbc"
                                                 + "tweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouip"
                                                 + "abfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcll"
                                                 + "phshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmm"
                                                 + "wcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzq"
                                                 + "kpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnr"
                                                 + "pqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhva"
                                                 + "kcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbb"
                                                 + "jjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkx"
                                                 + "rgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyo"
                                                 + "xqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstuly"
                                                 + "bnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkyd"
                                                 + "eoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehr"
                                                 + "fsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupx"
                                                 + "nwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfid"
                                                 + "gsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtq"
                                                 + "shcwsztkrzwrpabqrrhnlerxjojemcxel",
                                         new String[] { "dhvf",
                                                 "sind",
                                                 "ffsl",
                                                 "yekr",
                                                 "zwzq",
                                                 "kpeo",
                                                 "cila",
                                                 "tfty",
                                                 "modg",
                                                 "ztjg",
                                                 "ybty",
                                                 "heqg",
                                                 "cpwo",
                                                 "gdcj",
                                                 "lnle",
                                                 "sefg",
                                                 "vimw",
                                                 "bxcb" })); // [935]
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        Map<String, Long> map = Arrays.stream(words)
                                      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int wordLength = words[0].length();
        int maxLength = words.length * wordLength;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= s.length() - maxLength; i++) {
            String firstWord = s.substring(i, i + wordLength);
            long count = map.getOrDefault(firstWord, 0L);

            if (count == 0)
                continue;

            Map<String, Long> tmp = new HashMap<>(map);

            if (count == 1)
                tmp.remove(firstWord);
            else
                tmp.put(firstWord, count - 1);

            if (isMatch(s, wordLength, i + wordLength, tmp))
                res.add(i);
        }

        return res;
    }

    private static boolean isMatch(String s, int wordLength, int i, Map<String, Long> map) {
        while (!map.isEmpty()) {
            if (i > s.length() - wordLength)
                return false;

            String word = s.substring(i, i + wordLength);
            long count = map.getOrDefault(word, 0L);

            if (count == 0)
                return false;

            if (count == 1)
                map.remove(word);
            else
                map.put(word, count - 1);

            i += wordLength;
        }

        return true;
    }

}
