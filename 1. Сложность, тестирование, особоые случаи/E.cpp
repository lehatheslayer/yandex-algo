#include <algorithm>
#include <iostream>
#include <vector>

std::vector<int> flats_on_floor(int m, int k, int p, int n) {
//    if (p == 1 && n == 1) {
//        return std::vector<int>();
//    }

    int fof1 = k / (m * (p - 1) + n);
    int fof2 = (k - 1) / (m * (p - 1) + n - 1);

    std::vector<int> possible_fof;
    for (int i = fof1; i <= fof2; i++) {
        if (i != 0 && (m * (p - 1) + n - 1) * i + (k - 1) % i == k - 1) {
            possible_fof.push_back(i);
        }
    }

    return possible_fof;
}

int main() {
    int k1, m, k2, p2, n2;
    std::cin >> k1 >> m >> k2 >> p2 >> n2;

    if (n2 < 0 || n2 > m) {
        std::cout << -1 << " " << -1;
        return 0;
    }

    std::vector<int> possible_fof;
    if (p2 == 1 && n2 == 1) {
        if (k1 <= k2) {
            std::cout << 1 << " " << 1;
            return 0;
        } else {
            for (int i = k2; i <= k1; i++) {
                possible_fof.push_back(i);
            }
        }
    } else {
        possible_fof = flats_on_floor(m, k2, p2, n2);
    }

    std::pair<int, int> result = std::make_pair(-1, -1);
    for (int fof : possible_fof) {
        int idx = ((k1 - 1 - (k1 - 1) % fof) / fof) + 1;
        int n1 = idx % m;
        int p1 = ((idx - n1) / m) + 1;

        if (n1 == 0) {
            n1 = m;
            p1--;
        }

        if (result.first == -1 && result.second == -1) {
            result = std::make_pair(p1, n1);
        } else {
            if (p1 != result.first) {
                result.first = 0;
            }

            if (n1 != result.second) {
                result.second = 0;
            }
        }
    }

    std::cout << result.first << " " << result.second;
}