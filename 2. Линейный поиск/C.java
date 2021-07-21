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
        int n = Integer.parseInt(reader.readLine());
        String[] s = reader.readLine().split(" ");
        int x = Integer.parseInt(reader.readLine());
        int diff = Integer.MAX_VALUE, num = 0;

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(s[i]);
            if (diff > Math.abs(tmp - x)) {
                diff = Math.abs(tmp - x);
                num = tmp;
            }
        }

        System.out.println(num);
    }

    public static void close() throws IOException {
        reader.close();
    }
}
