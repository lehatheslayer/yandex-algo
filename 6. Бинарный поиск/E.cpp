#include <algorithm>
#include <iostream>

long long binarySearch(long long &a, long long &b, long long &c) {
    long long min = 0, max = a + b;
    while (min + 1 < max) {
        long long mid = (min + max) / 2;
        long double mark = (long double) (a * 2 + b * 3 + c * 4 + mid * 5) / (a + b + c + mid);

        if (mark >= 3.5) {
            max = mid;
        } else {
            min = mid;
        }
    }

    return max;
}

int main() {
    long long a, b, c;
    std::cin >> a >> b >> c;

    std::cout << binarySearch(a, b, c);
}