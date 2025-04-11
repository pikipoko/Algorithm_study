#include <iostream>
#include <map>
using namespace std;

int main() {
    int n;
    cin >> n;

    map<int, int> x_count;
    map<int, int> y_count;

    for (int i = 0; i < n; ++i) {
        int x, y;
        cin >> x >> y;
        x_count[x]++;
        y_count[y]++;
    }

    int ans = 0;
    for (auto &p : x_count) {
        if (p.second >= 2) ans++;
    }
    for (auto &p : y_count) {
        if (p.second >= 2) ans++;
    }

    cout << ans << endl;
    return 0;
}
