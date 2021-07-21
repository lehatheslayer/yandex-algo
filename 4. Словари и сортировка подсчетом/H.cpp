#include <iostream>
#include <set>
#include <map>

int main() {
    int g, s;
    std::string w, seq;
    std::cin >> g >> s >> w >> seq;

    std::map<char, int> w_counter;
    for (char ch : w) {
        w_counter[ch]++;
    }

    std::map<char, int> seq_counter;
    for (int i = 0; i < g - 1; i++) {
        seq_counter[seq[i]]++;
    }

    char tmp;
    int result = 0;
    for (int i = g - 1; i < s; i++) {
        seq_counter[seq[i]]++;
        if (seq_counter == w_counter) {
            result++;
        }

        tmp = seq[i - g + 1];
        seq_counter[tmp]--;
        if (seq_counter[tmp] == 0) {
            seq_counter.erase(tmp);
        }
    }

    std::cout << result;
}
