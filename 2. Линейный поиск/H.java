import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        long[] nums = new long[s.length];
        for (int i = 0; i < s.length; i++) {
            long x = Long.parseLong(s[i]);
            nums[i] = x;
        }

        int max_idx1, max_idx2, max_idx3;
        int min_idx1, min_idx2;

        max_idx1 = max1(nums);
        min_idx1 = min1(nums);

        max_idx2 = max2(nums, max_idx1);
        min_idx2 = min2(nums, min_idx1);

        max_idx3 = max3(nums, max_idx1, max_idx2);

        if (nums[max_idx1] * nums[max_idx2] * nums[max_idx3] > nums[max_idx1] * nums[min_idx1] * nums[min_idx2]) {
            System.out.println(nums[max_idx1] + " " + nums[max_idx2] + " " + nums[max_idx3]);
        } else {
            System.out.println(nums[max_idx1] + " " + nums[min_idx1] + " " + nums[min_idx2]);
        }
    }

    public static void close() throws IOException {
        reader.close();
    }

    public static int max1(long[] nums) {
        long max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                idx = i;
            }
        }

        return idx;
    }

    public static int max2(long[] nums, int max1_idx) {
        long max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i] && i != max1_idx) {
                max = nums[i];
                idx = i;
            }
        }

        return idx;
    }

    public static int max3(long[] nums, int max1_idx, int max2_idx) {
        long max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i] && i != max1_idx && i != max2_idx) {
                max = nums[i];
                idx = i;
            }
        }

        return idx;
    }

    public static int min1(long[] nums) {
        long min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
                idx = i;
            }
        }

        return idx;
    }

    public static int min2(long[] nums, int min1_idx) {
        long min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i] && i != min1_idx) {
                min = nums[i];
                idx = i;
            }
        }

        return idx;
    }
}
