import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <blockquote>
 * Note: This is a companion problem to the <a href="https://leetcode.com/discuss/interview-question/system-design/">System Design</a> problem: <a
 * href="https://leetcode.com/discuss/interview-question/124658/Design-a-URL-Shortener-(-TinyURL-)-System/">Design TinyURL</a>.
 * </blockquote>
 * <p>
 * TinyURL is a URL shortening service where you enter a URL such as <tt>https://leetcode.com/problems/design-tinyurl</tt> and it returns a short URL
 * such as <tt>http://tinyurl.com/4e9iAk</tt>.
 * <p>
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just
 * need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 *
 * @author Oleg Cherednik
 * @since 05.05.2020
 */
public class Solution {

    public static class Codec {

        private static final String PREFIX = "http://foo/";
        private final Map<String, String> map = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String shortUrl = PREFIX + UUID.randomUUID();
            map.put(shortUrl, longUrl);
            return shortUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return map.get(shortUrl);
        }
    }

}
