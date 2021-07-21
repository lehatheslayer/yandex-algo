import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
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
        int n = Integer.parseInt(reader.readLine());

        Set<String> all_known = new HashSet<>();
        Set<String> at_least_one_known = new HashSet<>();
        boolean first_iteration = true;

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(reader.readLine());
            Set<String> tmp = new HashSet<>();

            for (int j = 0; j < m; j++) {
                String lang = reader.readLine();
                at_least_one_known.add(lang);

                if (first_iteration) {
                    all_known.add(lang);
                } else {
                    if (all_known.contains(lang)) {
                        tmp.add(lang);
                    }
                }
            }

            if (!first_iteration) {
                all_known = tmp;
            }
            first_iteration = false;
        }

        System.out.println(all_known.size());
        for (String lang : all_known) {
            System.out.println(lang);
        }

        System.out.println(at_least_one_known.size());
        for (String lang : at_least_one_known) {
            System.out.println(lang);
        }
    }

    public static void close() throws IOException {
        reader.close();
    }
}
