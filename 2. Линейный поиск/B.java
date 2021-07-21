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
        boolean constant = true;
        boolean ascending = true;
        boolean weakly_ascending = true;
        boolean descending = true;
        boolean weakly_descending = true;

        int first = Integer.parseInt(reader.readLine()), second;
        while (true) {
            second = Integer.parseInt(reader.readLine());
            if (second == -2000000000) {
                break;
            }

            if (constant) {
                if (first != second) {
                    constant = false;
                }
            }

            if (ascending) {
                if (first >= second) {
                    ascending = false;
                }
            }

            if (weakly_ascending) {
                if (first > second) {
                    weakly_ascending = false;
                }
            }

            if (descending) {
                if (first <= second) {
                    descending = false;
                }
            }

            if (weakly_descending) {
                if (first < second) {
                    weakly_descending = false;
                }
            }

            first = second;
        }

        if (constant) {
            System.out.println("CONSTANT");
        } else if (ascending) {
            System.out.println("ASCENDING");
        } else if (weakly_ascending) {
            System.out.println("WEAKLY ASCENDING");
        } else if (descending) {
            System.out.println("DESCENDING");
        } else if (weakly_descending){
            System.out.println("WEAKLY DESCENDING");
        } else {
            System.out.println("RANDOM");
        }
    }

    public static void close() throws IOException {
        reader.close();
    }
}
