#include <iostream>
#include <set>

int main() {
    int n;
    std::cin >> n;

    int x, y;
    std::set<int> unique_x_coords;

    for (int i = 0; i < n; i++) {
        std::cin >> x >> y;
        unique_x_coords.insert(x);
    }

    std::cout << unique_x_coords.size();
}
