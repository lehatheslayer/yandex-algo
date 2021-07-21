#include <algorithm>
#include <iostream>
#include <climits>

long binarySearch(long &n, long &a, long &b, long &w, long &h) {
    long min_d = 0, max_d = LONG_MAX;
    while (min_d + 1 < max_d) {
        long mid_d = (min_d + max_d) / 2;
        long modules_num = std::max((w / (a + mid_d * 2)) * (h / (b + mid_d * 2)),
                                    (h / (a + mid_d * 2)) * (w / (b + mid_d * 2)));

        if (modules_num < n) {
            max_d = mid_d;
        } else {
            min_d = mid_d;
        }
    }

    return min_d;
}

int main() {
    long n, a, b, w, h;
    std::cin >> n >> a >> b >> w >> h;

    std::cout << binarySearch(n, a, b, w, h);
}