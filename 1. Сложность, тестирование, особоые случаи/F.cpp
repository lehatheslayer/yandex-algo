#include <algorithm>
#include <iostream>
#include <vector>

int main() {
    int a1, b1, a2, b2;
    std::cin >> a1 >> b1 >> a2 >> b2;

    std::vector<std::pair<int, int>> r;
    r.emplace_back(a1 + a2, b1 + (b1 >= b2 ? 0 : b2 - b1));
    r.emplace_back(a1 + b2, b1 + (b1 >= a2 ? 0 : a2 - b1));
    r.emplace_back(a1 + (a1 >= b2 ? 0 : b2 - a1), b1 + a2);
    r.emplace_back(a1 + (a1 >= a2 ? 0 : a2 - a1), b1 + b2);

    int s1 = r[0].first * r[0].second;
    int s2 = r[1].first * r[1].second;
    int s3 = r[2].first * r[2].second;
    int s4 = r[3].first * r[3].second;

    if (s1 <= s2 && s1 <= s3 && s1 <= s4) {
        std::cout << r[0].first << " " << r[0].second;
    } else if (s2 <= s3 && s2 <= s4) {
        std::cout << r[1].first << " " << r[1].second;
    } else if (s3 <= s4) {
        std::cout << r[2].first << " " << r[2].second;
    } else {
        std::cout << r[3].first << " " << r[3].second;
    }
}