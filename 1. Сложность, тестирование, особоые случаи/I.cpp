#include <algorithm>
#include <iostream>
#include <vector>

int main() {
    std::vector<int> brick(3);
    std::vector<int> hole(2);
    std::cin >> brick[0] >> brick[1] >> brick[2] >> hole[0] >> hole[1];

    std::sort(brick.begin(), brick.end());
    std::sort(hole.begin(), hole.end());

    if (brick[0] <= hole[0] && brick[1] <= hole[1]) {
        std::cout << "YES";
    } else {
        std::cout << "NO";
    }
}