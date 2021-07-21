#include <iostream>
#include <set>

int main() {
    int x, y, z;
    std::cin >> x >> y >> z;
    int n;
    std::cin >> n;

    std::set<int> unique_digits_to_add;
    while (n > 0) {
        int tmp = n % 10;
        if (x != tmp && y != tmp && z != tmp) {
            unique_digits_to_add.insert(tmp);
        }

        n /= 10;
    }

    std::cout << unique_digits_to_add.size();
}
