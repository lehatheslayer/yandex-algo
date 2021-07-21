#include <algorithm>
#include <iostream>

long binarySearch(long &n, long &x, long &y) {
    long min = 0, max = (n - 1) * std::max(x, y);
    while (min + 1 < max) {
        long mid = (min + max) / 2;
        long copy_num = mid / x + mid / y;

        if (copy_num < n - 1) {
            min = mid;
        } else {
            max = mid;
        }
    }

    return max + std::min(x, y);
}

int main() {
    long n, x, y;
    std::cin >> n >> x >> y;

    std::cout <<binarySearch(n, x, y);
}