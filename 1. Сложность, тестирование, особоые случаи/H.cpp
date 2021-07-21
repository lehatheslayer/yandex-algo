#include <algorithm>
#include <iostream>

int main() {
    int a, b, n, m;
    std::cin >> a >> b >> n >> m;

    int from = std::max(n + (n - 1) * a, m + (m - 1) * b);
    int to = std::min(n  + (n + 1) * a, m + (m + 1) * b);

    if (from > to) {
        std::cout << -1;
    } else {
        std::cout << from << " " << to;
    }
}