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
        if (map.find(word) != map.end()) {
            std::cout << map[word] << " ";
            map[word]++;
        } else {
            std::cout << 0 << " ";
            map[word] = 1;
        }
    }
}
