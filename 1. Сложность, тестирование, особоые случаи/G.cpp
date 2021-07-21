#include <algorithm>
#include <iostream>

int main() {
    int n, k, m;
    std::cin >> n >> k >> m;

    if (n < k || k < m) {
        std::cout << 0;
        return 0;
    }

    int result = 0;
    int billet = 0;
    int details_from_one_billet = k / m;
    int remainder_from_one_billet = k % m;
    while (true) {
        if (n < k) {
            break;
        }

        billet = n / k;
        n = n - billet * k + remainder_from_one_billet * billet;
        result += details_from_one_billet * billet;
    }

    std::cout << result;
}