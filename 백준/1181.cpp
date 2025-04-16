#include <cstdlib>
#include <iostream>
#include <string>
#include <set>

using std::cout;
using std::cin;
using std::endl;
using std::string;
using std::set;
using std::pair;

int main()
{
    int N;
    cin >> N;

    set<pair<int, string>> words;

    for(int i = 0; i < N; i++)
    {
        string word;
        cin >> word;

        words.insert({word.size(), word});
    }

    for(const auto& w : words)
    {
        cout << w.second << endl;
    }

    return EXIT_SUCCESS;
}