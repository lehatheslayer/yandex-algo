#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    int n;
    std::cin >> n;
    std::vector<int> req_powers;
    int req_power;
    for (int i = 0; i < n; i++) {
        std::cin >> req_power;
        req_powers.push_back(req_power);
    }

    int m;
    std::cin >> m;
    std::vector<std::pair<int, int>> conditioners;
    int power, cost;
    conditioners.reserve(m);
    for (int i = 0; i < m; i++) {
        std::cin >> power >> cost;
        conditioners.emplace_back(power, cost);
    }
    std::sort(conditioners.begin(), conditioners.end(), [](std::pair<int, int> &l, std::pair<int, int> &r) -> bool
        { return l.second < r.second; });

    int result = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (conditioners[j].first >= req_powers[i]) {
                result += conditioners[j].second;
                break;
            }
        }
    }

    std::cout << result;
}