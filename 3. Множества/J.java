import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        int t = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);
        int n = Integer.parseInt(s[2]);

        int x1 = 0, y1 = 0;
        int x2 = 0, y2 = 0;
        for (int i = 0; i < n; i++) {
            String[] str = reader.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);

            x1 = Math.max(x1 - t, x + y - d);
            y1 = Math.max(y1 - t, x - y - d);
            x2 = Math.min(x2 + t, x + y + d);
            y2 = Math.min(y2 + t, x - y + d);
        }

        List<Pair> result = new ArrayList<>();
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if ((i + j) % 2 == 0) {
                    result.add(new Pair((i + j) / 2, (i - j) / 2));
                }
            }
        }

        System.out.println(result.size());
        for (Pair pair : result) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static void close() throws IOException {
        reader.close();
    }
}

class Pair {
    private final int key;
    private final int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() { return key; }
    public int getValue() { return value; }
}
