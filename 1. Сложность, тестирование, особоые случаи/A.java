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

        int[] t = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String s = reader.readLine();

        switch (s) {
            case "freeze":
                System.out.println(Math.min(t[0], t[1]));
                break;

            case "heat":
                System.out.println(Math.max(t[0], t[1]));
                break;

            case "auto":
                System.out.println(t[1]);
                break;

            case "fan":
                System.out.println(t[0]);
                break;
        }
    }

    public static void close() throws IOException {

        reader.close();
    }
}