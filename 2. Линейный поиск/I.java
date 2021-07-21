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
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int m = Integer.parseInt(s[2]);

        if (m == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    System.out.print(0 + " ");
                }

                System.out.println();
            }
            return;
        }

        int[][] field = new int[n][k];
        for (int i = 0; i < m; i++) {
            String[] coords = reader.readLine().split(" ");
            int x = Integer.parseInt(coords[1]) - 1;
            int y = Integer.parseInt(coords[0]) - 1;

            field[y][x] = -1;

            if (y - 1 >= 0 && x - 1 >= 0 && field[y - 1][x - 1] != -1) {
                field[y - 1][x - 1]++;
            }

            if (y - 1 >= 0 && field[y - 1][x] != -1) {
                field[y - 1][x]++;
            }

            if (y - 1 >= 0 && x + 1 < k && field[y - 1][x + 1] != -1) {
                field[y - 1][x + 1]++;
            }

            if (x - 1 >= 0 && field[y][x - 1] != -1) {
                field[y][x - 1]++;
            }

            if (x + 1 < k && field[y][x + 1] != -1) {
                field[y][x + 1]++;
            }

            if (y + 1 < n && x - 1 >= 0 && field[y + 1][x - 1] != -1) {
                field[y + 1][x - 1]++;
            }

            if (y + 1 < n && field[y + 1][x] != -1) {
                field[y + 1][x]++;
            }

            if (y + 1 < n && x + 1 < k && field[y + 1][x + 1] != -1) {
                field[y + 1][x + 1]++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (field[i][j] == -1) {
                    System.out.print("* ");
                } else {
                    System.out.print(field[i][j] + " ");
                }
            }

            System.out.println();
        }
    }

    public static void close() throws IOException {
        reader.close();
    }
}
