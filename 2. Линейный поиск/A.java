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
        if (s.length <= 1) {
            System.out.println("YES");
            return;
        }
        String t = s[0];

        for (int i = 1; i < s.length; i++) {
            if (Integer.parseInt(t) >= Integer.parseInt(s[i])) {
                System.out.println("NO");
                return;
            } else {
                t = s[i];
            }
        }

        System.out.println("YES");
    }

    public static void close() throws IOException {
        reader.close();
    }
}
