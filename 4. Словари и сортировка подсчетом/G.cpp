#include <iostream>
#include <set>
#include <vector>
#include <map>

int main() {
    std::map<std::string, long> accounts;
    std::string operation;

    while (std::cin >> operation) {
        std::string arg1, arg2;
        long arg3;

        if (operation == "DEPOSIT") {
            std::cin >> arg1 >> arg3;

            accounts[arg1] += arg3;
        } else if (operation == "WITHDRAW") {
            std::cin >> arg1 >> arg3;

            accounts[arg1] -= arg3;
        } else if (operation == "BALANCE") {
            std::cin >> arg1;

            if (accounts.find(arg1) == accounts.end()) {
                std::cout << "ERROR\n";
            } else {
                std::cout << accounts[arg1] << "\n";
            }
        } else if (operation == "TRANSFER") {
            std::cin >> arg1 >> arg2 >> arg3;

            accounts[arg1] -= arg3;
            accounts[arg2] += arg3;
        } else if (operation == "INCOME") {
            std::cin >> arg3;

            for (auto &it : accounts) {
                if (it.second > 0) {
                    it.second += it.second * arg3 / 100;
                }
            }
        }
    }
}
