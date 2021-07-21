#include <iostream>
#include <set>

int main() {
    int n, m;
    std::cin >> n >> m;

    std::set<int> anya;
    std::set<int> borya;
    std::set<int> intersection;

    for (int i = 0; i < n; i++) {
        int num;
        std::cin >> num;
        anya.insert(num);
    }

    for (int i = 0; i < m; i++) {
        int num;
        std::cin >> num;

        if (!anya.insert(num).second) {
            intersection.insert(num);
        } else {
            borya.insert(num);
        }

        anya.erase(num);
    }

    std::cout << intersection.size() << "\n";
    for (auto num : intersection) {
        std::cout << num << " ";
    }

    std::cout << "\n" << anya.size() << "\n";
    for (auto num : anya) {
        std::cout << num << " ";
    }

    std::cout << "\n" << borya.size() << "\n";
    for (auto num : borya) {
        std::cout << num << " ";
    }
}
