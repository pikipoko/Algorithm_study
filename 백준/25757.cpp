#include <cstdlib>
#include <iostream>
#include <string>
#include <set>

using std::cin;
using std::cout;
using std::endl;
using std::string;
using std::set;

int main()
{
    int N;
    string game;
    // Y, F, O

    cin >> N >> game;

    set<string> user;

    for(int i = 0; i < N; i++)
    {
        string tmp_user;
        cin >> tmp_user;

        user.insert(tmp_user);
    }

    if(game == "Y") // 2
    {
        cout << user.size() << endl;
    }
    if(game == "F") // 3
    {
        cout << user.size() / 2 << endl;
    }
    if(game == "O") // 4
    {
        cout << user.size() / 3 << endl;
    }

    return EXIT_SUCCESS;
}