#include <iostream>
#include <set>
#include <map>

int main() {
    std::string genome1;
    std::string genome2;

    std::cin >> genome1 >> genome2;

    std::map<std::string, int> map;

    for (int i = 0; i < genome1.length() - 1; i++) {
        std::string pair = {genome1[i], genome1[i + 1]};
        map[pair]++;
    }

    long long result = 0;
    for (int i = 0; i < genome2.length() - 1; i++) {
        std::string pair = {genome2[i], genome2[i + 1]};
        result += map[pair];
        map[pair] = 0;
//        if (map[pair] > 0) {
//            std::cout << pair << " " << map[pair] << "\n";
//        }
    }

    std::cout << result;
}
