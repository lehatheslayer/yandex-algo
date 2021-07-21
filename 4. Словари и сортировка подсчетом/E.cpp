#include <iostream>
#include <set>
#include <vector>
#include <algorithm>
#include <unordered_set>
#include <map>

int main() {
    std::map<long, long> map;
    int n;
    std::cin >> n;

    long w, h;
    for (int i = 0; i < n; i++) {
        std::cin >> w >> h;
        if (map[w] < h) {
            map[w] = h;
        }
    }

    long result = 0;
    for (const auto &it : map) {
        result += it.second;
    }

    std::cout << result;
}
