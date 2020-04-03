/**
 * Given a text file <tt>file.txt</tt> that contains list of phone numbers (one per line), write a one liner bash script to print all valid phone
 * numbers.
 * <p>
 * You may assume that a valid phone number must appear in one of the following two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx. (x means a digit)
 * <p>
 * You may also assume each line in the text file must not contain leading or trailing white spaces.
 * <p>
 * <b>Example:</b>
 * <p>
 * Assume that <tt>file.txt</tt> has the following content:
 * <pre>
 * 987-123-4567
 * 123 456 7890
 * (123) 456-7890
 * </pre>
 * Your script should output the following valid phone numbers:
 * <pre>
 * 987-123-4567
 * (123) 456-7890
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 17.08.2018
 */
public class Solution {

    public int reverseBits(int n) {
        long val = n & 0x00000000ffffffffL;
        String str = Long.toBinaryString(val);
        str = str.length() < 32 ? String.format("%0" + (32 - str.length()) + "d%s", 0, str) : str;
        return (int)Long.parseLong(new StringBuilder(str).reverse().toString(), 2);
    }

}
