/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the
 * quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have <tt>n</tt> versions <tt>[1, 2, ..., n]</tt> and you want to find out the first bad one, which causes all the following ones to be
 * bad.
 * <p>
 * You are given an API <tt>bool isBadVersion(version)</tt> which will return whether <tt>version</tt> is bad. Implement a function to find the first
 * bad version. You should minimize the number of calls to the API.
 * <p>
 * <b>Example:</b>
 * <pre>
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 * </pre>
 *
 * @author Oleg Cherednik
 * @since 01.05.2020
 */
public class Solution extends VersionControl {

    public static void main(String... args) {
        System.out.println(new Solution(4).firstBadVersion(5)); //4
    }

    public Solution(int firstBadVersion) {
        super(firstBadVersion);
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                res = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }

        return res;
    }

}

abstract class VersionControl {

    private final int firstBadVersion;

    protected VersionControl(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    public boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }
}
