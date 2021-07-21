import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
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
        int n = Integer.parseInt(s[0]);
        long r = Long.parseLong(s[1]);

        s = reader.readLine().split(" ");
        List<Long> monuments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long d = Long.parseLong(s[i]);
            monuments.add(d);
        }

        int i = 0, j = 1;
        long result = 0;
        while (j < n) {
            if (monuments.get(j) - monuments.get(i) > r) {
                result += n - j;
                i++;
            } else {
                j++;
            }
        }

        System.out.println(result);
    }

    public static void close() throws IOException {
        reader.close();
    }
}
