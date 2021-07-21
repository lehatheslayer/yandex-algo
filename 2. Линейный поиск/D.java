import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int count = 0;

        for (int i = 1; i < s.length - 1; i++) {
            if (Integer.parseInt(s[i]) > Integer.parseInt(s[i - 1]) && Integer.parseInt(s[i]) > Integer.parseInt(s[i + 1])) {
                count ++;
            }
        }

        System.out.println(count);
    }

    public static void close() throws IOException {
        reader.close();
    }
}
