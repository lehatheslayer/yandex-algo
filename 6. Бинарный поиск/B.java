import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int n = Integer.parseInt(s[0]), k = Integer.parseInt(s[1]);

        String[] str1 = reader.readLine().split(" ");
        List<Integer> array1 = new ArrayList<>();
        for (String value : str1) {
            array1.add(Integer.parseInt(value));
        }

        String[] str2 = reader.readLine().split(" ");
        for (String value : str2) {
            System.out.println(array1.get(binarySearch(Integer.parseInt(value), array1)));
        }
    }

    public static int binarySearch(int x, List<Integer> array) {
        int l = 0;
        int r = array.size();

        while (l < r) {
            int m = (l + r) / 2;

            if (array.get(m) > x) {
                r = m;
            } else if (array.get(m) < x){
                l = m + 1;
            } else {
                return m;
            }
        }

        if (l < array.size() && (l == 0 || array.get(l) - x < x - array.get(l - 1))) {
            return l;
        } else {
            return l - 1;
        }
    }

    public static void close() throws IOException {
        reader.close();
    }
}