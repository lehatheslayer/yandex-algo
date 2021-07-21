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
        StringBuilder number_to_add = deleteCharacters(new StringBuilder(reader.readLine()));
        Pair info1 = getInfo(number_to_add);

        for (int i = 0; i < 3; i++) {
            StringBuilder number = deleteCharacters(new StringBuilder(reader.readLine()));
            Pair info2 = getInfo(number);

            if (info1.getFirst().equals(info2.getFirst()) && info1.getSecond().equals(info2.getSecond())) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static Pair getInfo(StringBuilder number) {
        String code, num;
        if (number.length() == 8) {
            code = "495";
            num = number.substring(1);
        } else if (number.length() == 7) {
            code = "495";
            num = number.toString();
        } else {
            code = number.substring(1, 4);
            num = number.substring(4);
        }

        return new Pair(code, num);
    }

    public static StringBuilder deleteCharacters(StringBuilder number) {
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '-' || number.charAt(i) == '+'
                    || number.charAt(i) == '(' || number.charAt(i) == ')') {
                number.deleteCharAt(i);
            }
        }

        return number;
    }



    public static void close() throws IOException {
        reader.close();
    }
}

class Pair {
    private String first;
    private String second;

    public Pair(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }
}
