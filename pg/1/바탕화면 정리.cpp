#include <string>
#include <vector>
#include <iostream>
#include <cstdlib>

using namespace std;

vector<int> solution(vector<string> wallpaper) {
    vector<int> answer {(int)wallpaper.size(), (int)wallpaper[0].size(), 0, 0};
    // min i, min j, max i, max j
    
    for(int i = 0; i < wallpaper.size(); i++)
    {
        for(int j = 0; j < wallpaper[i].size(); j++)
        {
            if(wallpaper[i][j] == '#')
            {
                if(i < answer[0])
                    answer[0] = i;
                if(i > answer[2])
                    answer[2] = i;
                if(j < answer[1])
                    answer[1] = j;
                if(j > answer[3])
                    answer[3] = j;
            }
        }
    }
    answer[2]++;
    answer[3]++;
    return answer;
}