#include <iostream>
#include <set>
#include <vector>
#include <algorithm>
#include <unordered_set>
#include <map>

int main() {
    int n;
    std::cin >> n;
    std::map<int, int> limits;
    int limit;

    for (int i = 1; i <= n; i++) {
        std::cin >> limit;
        limits[i] = limit;
    }

    std::map<int, int> clicks;
    int k;
    std::cin >> k;

    int click_number;
    for (int i = 0; i < k; i++) {
        std::cin >> click_number;
        clicks[click_number]++;
    }

    for (int i = 1; i <= n; i++) {
        if (clicks[i] > limits[i]) {
            std::cout << "YES\n";
        } else {
            std::cout << "NO\n";
        }
    }
}
