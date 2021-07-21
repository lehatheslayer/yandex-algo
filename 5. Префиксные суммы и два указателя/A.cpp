#include <iostream>
#include <set>
#include <map>
#include <vector>
#include <cmath>

int main() {
    int n;
    std::cin >> n;

    int shirt_color;
    std::vector<int> shirts;
    for (int i = 0; i < n; i++) {
        std::cin >> shirt_color;
        shirts.push_back(shirt_color);
    }

    int m;
    std::cin >> m;

    int pants_color;
    std::vector<int> pants;
    for (int i = 0; i < m; i++) {
        std::cin >> pants_color;
        pants.push_back(pants_color);
    }

    int shirt_idx = 0, pants_idx = 0;
    int diff = abs(shirts[0] - pants[0]);
    int i = 0, j = 0;
    while (i < n && j < m) {
        if (shirts[i] == pants[j]) {
            shirt_idx = i;
            pants_idx = j;
            break;
        }

        if (abs(shirts[i] - pants[j]) < diff) {
            diff = abs(shirts[i] - pants[j]);
            shirt_idx = i;
            pants_idx = j;
        }

        if (shirts[i] < pants[j]) {
            i++;
        } else {
            j++;
        }
    }

    shirt_color = shirts[shirt_idx];
    pants_color = pants[pants_idx];
    std::cout << shirt_color << " " << pants_color;
}
