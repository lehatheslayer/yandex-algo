#include <iostream>
#include <set>
#include <vector>
#include <algorithm>
#include <unordered_set>
#include <map>

int main() {
    std::string word;
    std::map<std::string, int> map;

    while (std::cin >> word) {
        map[word]++;
    }

    std::string result;
    int max = -1;
    for (const auto& it : map) {
        if (max < it.second) {
            max = it.second;
            result = it.first;
        }
    }

    std::cout << result;
}
