#include <iostream>
#include <cmath>

int main() {
    int n;
    double f_prev;
    std::cin >> n >> f_prev;
    double from = 30.0, to = 4000.0;

    for (int i = 0; i < n - 1; i++) {
        double f_curr;
        std::string pos;
        std::cin >> f_curr >> pos;

        if (std::abs(f_curr - f_prev) < std::pow(10, -6)) {
            continue;
        }

        if (pos == "closer") {
            if (f_curr > f_prev) {
                from = std::max(from, (f_prev + f_curr) / 2);
            } else {
                to = std::min(to, (f_prev + f_curr) / 2);
            }
        } else {
            if (f_curr < f_prev) {
                from = std::max(from, (f_prev + f_curr) / 2);
            } else {
                to = std::min(to, (f_prev + f_curr) / 2);
            }
        }

        f_prev = f_curr;
    }

    std::cout << std::fixed << from << " " << to;
}
