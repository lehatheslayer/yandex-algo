#include <iostream>
#include <set>
#include <map>

std::string toLowerCase(std::string word) {
    for (char &ch : word) {
        ch = tolower(ch);
    }

    return word;
}

bool moreThenOneStress(std::string word) {
    int stress_count = 0;
    for (char ch : word) {
        if (isupper(ch)) {
            stress_count++;
        }
    }

    return stress_count > 1;
}

int main() {
    int n;
    std::cin >> n;

    std::string word;
    std::map<std::string, std::set<std::string>> dictionary;
    for (int i = 0; i < n; i++) {
        std::cin >> word;
        std::string lower_case_word = toLowerCase(word);

        dictionary[lower_case_word].insert(word);
    }

    int result = 0;
    while (std::cin >> word) {

        std::string lower_case_word = toLowerCase(word);
        if (lower_case_word == word) {
            result++;
            continue;
        }

        if (moreThenOneStress(word)) {
            result++;
            continue;
        }

        if (dictionary.find(lower_case_word) != dictionary.end()
        && dictionary[lower_case_word].find(word) == dictionary[lower_case_word].end()) {
            result++;
            continue;
        }
    }
    
    std::cout << result;
}
