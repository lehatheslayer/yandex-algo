import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
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

        if (a + b > c && b + c > a && a + c > b) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void close() throws IOException {

        reader.close();
    }
}