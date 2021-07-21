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
        int k = Integer.parseInt(s[1]);

        s = reader.readLine().split(" ");
        List<Integer> trees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(s[i]);
            trees.add(t);
        }

        int[] colors = new int[k];
        int l = 0, r = 0;
        int minl = 1, minr = n;
        int num = 0;
        while (r < n) {
            int color = trees.get(r) - 1;
            if (colors[color] == 0) {
                num++;
            }

            colors[trees.get(r) - 1]++;
            r++;

            if (num == k) {
                while (colors[color] > 0) {
                    color = trees.get(l) - 1;
                    colors[color]--;
                    l++;
                }

                if (r - l < minr - minl) {
                    minl = l;
                    minr = r;
                }

                num--;
            }
        }

        System.out.println(minl + " " + minr);
    }

    public static void close() throws IOException {
        reader.close();
    }
}