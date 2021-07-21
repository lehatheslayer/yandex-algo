import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int l = i;
            int r = nums.length - 1;

            while (l < nums.length && r >= 0 && nums[l] == nums[r] && l <= r) {
                l++;
                r--;
            }

            if (l > r) {
                for (int k = i - 1; k > -1; k--) {
                    result.add(nums[k]);
                }

                System.out.println(result.size());
                for (int num : result) {
                    System.out.print(num + " ");
                }

                return;
            }
        }
    }

    public static void close() throws IOException {
        reader.close();
    }
}
