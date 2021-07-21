#include <algorithm>
#include <iostream>

int main() {
    double a, b, c, d, e, f;
    std::cin >> a >> b >> c >> d >> e >> f;

    if (a * d - b * c == 0) {
        if (a == 0 && c == 0) {
            if (b == 0 && d == 0) {
                if (e == 0 && f == 0) {
                    std::cout << 5;
                    return 0;
                }

                std::cout << 0;
                return 0;
            }

            if (e * d != f * b) {
                std::cout << 0;
                return 0;
            } else {
                if (b != 0) {
                    std::cout << 4 << " " << e / b;
                } else {
                    std::cout << 4 << " " << f / d;
                }

                return 0;
            }
        }

        if (b == 0 && d == 0) {
            if (e * c != f * a) {
                std::cout << 0;
                return 0;
            } else {
                if (a != 0) {
                    std::cout << 3 << " " << e / a;
                } else {
                    std::cout << 3 << " " << f / c;
                }

                return 0;
            }
        }

        if (a != 0) {
            double k = c / a;
            c = 0;
            d -= k * b;
            f -= k * e;

            if (c == 0 && d == 0 && f == 0) {
                std::cout << 1 << " " << -a / b << " " << e / b;
                return 0;
            }
        } else {
            double k = a / c;
            a = 0;
            b -= k * d;
            e -= k * f;

            if (a == 0 && b == 0 && e == 0) {
                std::cout << 1 << " " << -c / d << " " << f / d;
                return 0;
            }
        }

        std::cout << 0;
    } else {
        double x;
        double y;
        if (d != 0) {
            x = (e - b * f / d) / (a - b * c / d);
            y = (f - c * x) / d;
        } else {
            x = (f - d * e / b) / (c - d * a / b);
            y = (e - a * x) / b;
        }

        std::cout << 2 << " " << x << " " << y;
    }
}