#include <cstdlib>
#include <iostream>
#include <map>

using std::cout;
using std::cin;
using std::endl;
using std::map;

int main()
{
    int n;
    cin >> n;

    int x, y;

    map<int, int> xs;
    map<int, int> ys;

    int cnt = 0;

    bool checked = false;

    for(int i = 0; i < n; i++)
    {
        cin >> x >> y;
        
        if(xs.find(x) != xs.end())
        {
            checked = true;
            cnt += xs[x];
            xs[x]++;
        }
        else
        {
            xs[x] = 1;
        }
        if(!checked)
        {
            if(ys.find(y) != ys.end())
            {
                cnt += ys[y];
                ys[y]++;
            }
            else
            {
                ys[y] = 1;
            }
        }
        checked = false;
    }

    cout << cnt << endl;

    return EXIT_SUCCESS;
}