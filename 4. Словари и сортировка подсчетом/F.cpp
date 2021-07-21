#include <iostream>
#include <set>
#include <vector>
#include <algorithm>
#include <unordered_set>
#include <map>

int main() {
    std::map<std::string, std::map<std::string, long>> info;
    std::string customer, product;
    long count;

    while(std::cin >> customer) {
        std::cin >> product >> count;
        info[customer][product] += count;
    }

    for (auto const &it1 : info) {
        std::cout << it1.first << ":\n";
        for (auto const &it2 : it1.second) {
            std::cout << it2.first << " " << it2.second << "\n";
        }
    }
}
