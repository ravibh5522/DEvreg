#include <iostream>
#include <vector>
#include <stack>
#include <string>

using namespace std;

vector<string> recover_main_list(int n, vector<string>& names, vector<string>& operations) {
    stack<string> stack;
    vector<string> result;

    for (const string& op : operations) {
        if (op == "PUSH") stack.push(names.front()), names.erase(names.begin());
        else if (!stack.empty()) result.push_back(stack.top()), stack.pop();
    }

    return result;
}

int main() {
    int n;
    cin >> n;

    vector<string> names(n), operations(2 * n);
    for (int i = 0; i < n; cin >> names[i++]);
    for (int i = 0; i < 2 * n; cin >> operations[i++]);

    vector<string> recovered_list = recover_main_list(n, names, operations);
    for (const string& name : recovered_list) cout << name << " ";

    return 0;
}
