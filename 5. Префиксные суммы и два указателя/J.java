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
        int n = Integer.parseInt(reader.readLine());

        List<Pair> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = reader.readLine().split(" ");
            points.add(new Pair(Long.parseLong(s[0]), Long.parseLong(s[1])));
        }

        int result = 0;
        for (Pair x1y1 : points) {
            Map<Long, List<Pair>> points_by_distances = new HashMap<>();
            for (Pair x2y2 : points) {
                if (x1y1 == x2y2) {
                    continue;
                }

                long x = x1y1.getFirst() - x2y2.getFirst();
                long y = x1y1.getSecond() - x2y2.getSecond();
                long squared_distance = (long) (Math.pow(x, 2) + Math.pow(y, 2));

                if (points_by_distances.containsKey(squared_distance)) {
                    for (Pair prev_point : points_by_distances.get(squared_distance)) {
                        long x3 = prev_point.getFirst() - x2y2.getFirst();
                        long y3 = prev_point.getSecond() - x2y2.getSecond();
                        long squared_distance2 = (long) (Math.pow(x3, 2) + Math.pow(y3, 2));
                        if (4 * squared_distance > squared_distance2) {
                            result++;
                        }
                    }
                }

                if (!points_by_distances.containsKey(squared_distance)) {
                    points_by_distances.put(squared_distance, new ArrayList<>());
                }

                points_by_distances.get(squared_distance).add(x2y2);
            }
        }

        System.out.println(result);
    }

    public static void close() throws IOException {
        reader.close();
    }
}

class Pair {
    private long first;
    private long second;

    public Pair(long first, long second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(long first) {
        this.first = first;
    }

    public void setSecond(long second) {
        this.second = second;
    }

    public long getFirst() {
        return first;
    }

    public long getSecond() {
        return second;
    }
}
