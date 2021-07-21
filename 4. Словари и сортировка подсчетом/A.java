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
        int n = Integer.parseInt(reader.readLine());
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] words = reader.readLine().split(" ");

            map.put(words[0], words[1]);
            map.put(words[1], words[0]);
        }

        System.out.println(map.get(reader.readLine()));
    }

    public static void close() throws IOException {
        reader.close();
    }
}
