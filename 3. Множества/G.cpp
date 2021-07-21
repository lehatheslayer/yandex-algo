#include <iostream>
#include <set>

int main() {
    int n;
    std::cin >> n;

    int front, back;
    std::set<std::pair<int, int>> sentences;

    for (int i = n - 1; i >= 0; i--) {
        std::cin >> front >> back;
        if (front >= 0 && back >= 0 && front + back + 1 == n && sentences.find(std::make_pair(front, back)) == sentences.end()) {
            sentences.insert(std::make_pair(front, back));
        }
    }

    std::cout << sentences.size();
}
