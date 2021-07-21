import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
        int n = Integer.parseInt(reader.readLine());
        String[] s = reader.readLine().split(" ");
        int[] nums = new int[s.length];
        int max = Integer.MIN_VALUE, idx = -1;

        for(int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(s[i]);

            if (max < nums[i]) {
                max = nums[i];
                idx = i;
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = idx + 1; i < nums.length - 1; i++) {
            if (result < nums[i] && nums[i] % 10 == 5 && nums[i] > nums[i + 1]) {
                result = nums[i];
            }
        }

        if (result == Integer.MIN_VALUE) {
            System.out.println(0);
        } else {
            Arrays.sort(nums);
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == result) {
                    System.out.println(nums.length - i);
                    return;
                }
            }
        }
    }

    public static void close() throws IOException {
        reader.close();
    }
}
