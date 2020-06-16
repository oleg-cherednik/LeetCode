/**
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 * <p>
 * <b>IPv4</b> addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255,
 * separated by dots ("."), e.g.,<tt>172.16.254.1</tt>;
 * <p>
 * Besides, leading zeros in the IPv4 is invalid. For example, the address <tt>172.16.254.01</tt> is invalid.
 * <p>
 * <b>IPv6</b> addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by
 * colons (":"). For example, the address <tt>2001:0db8:85a3:0000:0000:8a2e:0370:7334</tt> is a valid one. Also, we could omit some leading zeros
 * among four hexadecimal digits and some low-case characters in the address to upper-case ones, so <tt>2001:db8:85a3:0:0:8A2E:0370:7334</tt> is also
 * a valid IPv6 address(Omit leading zeros and using upper cases).
 * <p>
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For
 * example, <tt>2001:0db8:85a3::8A2E:0370:7334</tt> is an invalid IPv6 address.
 * <p>
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address <tt>02001:0db8:85a3:0000:0000:8a2e:0370:7334</tt> is invalid.
 * <p>
 * <b>Note:</b> You may assume there is no extra space or special characters in the input string.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: "172.16.254.1"
 * Output: "IPv4"
 * Explanation: This is a valid IPv4 address, return "IPv4".
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * Output: "IPv6"
 * Explanation: This is a valid IPv6 address, return "IPv6".
 * </pre>
 * <b>Example 3:</b>
 * <pre>
 * Input: "256.256.256.256"
 * Output: "Neither"
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 16.06.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(validIPAddress("172.16.254.1"));                             // IPv4
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));        // IPv6
        System.out.println(validIPAddress("256.256.256.256"));                          // Neither
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));       // Neither
        System.out.println(validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));  // IPv6
        System.out.println(validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"));         // IPv6
        System.out.println(validIPAddress("2001:0db8:85a3::8A2E:0370:7334"));           // Neither
        System.out.println(validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334")); // Neither
    }

    private static final String IPv4 = "IPv4";
    private static final String IPv6 = "IPv6";
    private static final String NEITHER = "Neither";

    public static String validIPAddress(String IP) {
        if (IP != null && !IP.isEmpty()) {
            if (IP.contains("."))
                return validateIPv4Address(IP);
            if (IP.contains(":"))
                return validateIPv6Address(IP);
        }

        return NEITHER;
    }

    private static String validateIPv4Address(String IP) {
        if (IP.startsWith(".") || IP.endsWith("."))
            return NEITHER;

        String[] parts = IP.split("\\.");

        if (parts.length != 4)
            return NEITHER;

        for (String part : parts) {
            if (part.isEmpty())
                return NEITHER;

            for (int i = 0; i < part.length(); i++) {
                char ch = part.charAt(i);

                if (!(ch >= '0' && ch <= '9'))
                    return NEITHER;
            }

            int length = part.length();

            if (length > 1 && part.startsWith("0"))
                return NEITHER;
            if (length > 3)
                return NEITHER;
            if (Integer.parseInt(part, 10) > 255)
                return NEITHER;
        }

        return IPv4;
    }

    private static String validateIPv6Address(String IP) {
        if (IP.startsWith(":") || IP.endsWith(":"))
            return NEITHER;

        String[] parts = IP.toLowerCase().split(":");

        if (parts.length != 8)
            return NEITHER;

        for (String part : parts) {
            if (part.isEmpty())
                return NEITHER;

            for (int i = 0; i < part.length(); i++) {
                char ch = part.charAt(i);

                if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f')))
                    return NEITHER;
            }

            int length = part.length();

            if (length > 4)
                return NEITHER;
            if (Integer.parseInt(part, 16) > 0xFFFF)
                return NEITHER;
        }

        return IPv6;
    }

}
