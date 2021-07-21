import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

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
        int count = 0;

        Set<Integer> set = new HashSet<>();
        for (String value : s) {
            if (set.add(Integer.parseInt(value))) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void close() throws IOException {
        reader.close();
    }
}
