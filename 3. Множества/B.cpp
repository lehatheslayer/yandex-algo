#include <iostream>
#include <set>
#include <sstream>

int main() {
    int num;
    std::set<int> unique_items;
    std::set<int> result;
    std::string nums;

    std::getline(std::cin, nums);
    std::stringstream str(nums);
    while (str >> num) {
        unique_items.insert(num);
    }

    std::getline(std::cin, nums);
    str = std::stringstream(nums);
    while (str >> num) {
        if (!unique_items.insert(num).second) {
            result.insert(num);
        }
    }

    for (auto it : result) {
        std::cout << it << " ";
    }
}
