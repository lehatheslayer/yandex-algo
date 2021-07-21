import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Contest {

    private static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        close();
    }

    public static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void solve() throws IOException {
        String[] s = reader.readLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            int x = Integer.parseInt(s[i]);
            nums[i] = x;
        }

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int max_idx1 = -1;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int min_idx1 = -1;

        for (int i = 0; i < nums.length; i++) {
            if (max1 < nums[i]) {
                max1 = nums[i];
                max_idx1 = i;
            }

            if (min1 > nums[i]) {
                min1 = nums[i];
                min_idx1 = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (max2 < nums[i] && max_idx1 != i) {
                max2 = nums[i];
            }

            if (min2 > nums[i] && min_idx1 != i) {
                min2 = nums[i];
            }
        }

        if (Math.abs(max1 + max2) > Math.abs(min1 + min2)) {
            if (max1 > max2) {
                System.out.println(max2 + " " + max1);
            } else {
                System.out.println(max1 + " " + max2);
            }
        } else {
            if (min1 > min2) {
                System.out.println(min2 + " " + min1);
            } else {
                System.out.println(min1 + " " + min2);
            }
        }
    }

    public static void close() throws IOException {
        reader.close();
    }
}
