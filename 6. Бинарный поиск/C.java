import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        long w = Long.parseLong(s[0]), h = Long.parseLong(s[1]), n = Long.parseLong(s[2]);

        System.out.println(binarySearch(w, h, n));
    }

    public static long binarySearch(long w, long h, long n) {
        long min_size = Math.max(w, h), max_size = min_size * n;
        while (min_size + 1 < max_size) {
            long board_size = (min_size + max_size) / 2;
            long number_diplomas = (board_size / w) * (board_size / h);

            if (number_diplomas >= n) {
                max_size = board_size;
            } else {
                min_size = board_size;
            }
        }

        return max_size;
    }

    public static void close() throws IOException {
        reader.close();
    }
}
