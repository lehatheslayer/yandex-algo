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
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        if (c < 0 || a == 0 && b < 0 || a == 0 && c * c != b) {
            System.out.println("NO SOLUTION");
            return;
        }

        if (a == 0) {
            System.out.println("MANY SOLUTIONS");
            return;
        }

        if ((c * c - b) % a != 0) {
            System.out.println("NO SOLUTION");
            return;
        }

        int x = (c * c - b) / a;

        System.out.println(x);
    }

    public static void close() throws IOException {
        reader.close();
    }
}
