#include <iostream>
#include <set>

int main() {
    std::set<std::string> unique_words;
    std::string word;

    while(std::cin >> word) {
        unique_words.insert(word);
    }

    std::cout << unique_words.size();
}
