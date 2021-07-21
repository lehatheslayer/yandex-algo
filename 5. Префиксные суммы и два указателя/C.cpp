#include <iostream>
#include <set>
#include <map>
#include <vector>
#include <cmath>

int main() {
    int n;
    std::cin >> n;

    int x, y;
    std::vector<int> heights;
    for (int i = 0; i < n; i++) {
        std::cin >> x >> y;
        heights.push_back(y);
    }

    std::vector<int> lr(n);
    int prev = heights[0], curr;
    for (int i = 1; i < n; i++) {
        curr = heights[i];
        lr[i] = lr[i - 1] + std::max(0, curr - prev);
        prev = curr;
    }

    std::vector<int> rl(n);
    prev = heights[n - 1];
    for (int i = n - 2; i >= 0; i--) {
        curr = heights[i];
        rl[i] = rl[i + 1] + std::max(0, curr - prev);
        prev = curr;
    }

    int m;
    std::cin >> m;

    int s, f, result = 0;
    for (int i = 0; i < m; i++) {
        std::cin >> s >> f;

        result = s < f ? lr[f - 1] - lr[s - 1] : rl[f - 1] - rl[s - 1];
        std::cout << result << "\n";
    }
}
