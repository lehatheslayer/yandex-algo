#include <iostream>
#include <set>
#include <map>
#include <vector>
#include <cmath>

int main() {
    int n, k;
    std::cin >> n >> k;

    std::map<int, int> tmp;
    tmp[0] = 0;
    std::vector<int> prefix(n + 1);
    prefix[0] = 0;
    for (int i = 1; i <= n; i++) {
        std::cin >> prefix[i];
        prefix[i] += prefix[i - 1];
        tmp[prefix[i]] = prefix[i];
    }

    int result = 0;
    for (int i = 0; i <= n; i++) {
        if (tmp.find(prefix[i] - k) != tmp.end()) {
            result++;
        }
    }

    std::cout << result;
}
