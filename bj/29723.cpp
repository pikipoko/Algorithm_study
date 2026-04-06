#include <cstdlib>
#include <iostream>
#include <map>
#include <set>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int N, M, K;
    // N : 수강한 과목 총수
    // M : 브실 대학에서 요구하는 과목 수
    // K : 브실대학에서 공개한 과목 수

    cin >> N >> M >> K;

    map<string, int> scores;
    vector<pair<int, int>> left;

    int min_score = 0;
    int max_score = 0;

    for(int i = 0; i < N; i++)
    {
        string subject;
        int score;

        cin >> subject >> score;

        scores[subject] = score;

        bool found = false;
        for (auto& pair : left) {
            if (pair.first == score) {
                pair.second++; 
                found = true;
                break;
            }
        }
        if (!found) {
            left.push_back({score, 1}); 
        }
    }

    for(int i = 0; i < K; i++)
    {
        string subject;

        cin >> subject;

        min_score += scores[subject];
        max_score += scores[subject];

        for (auto& pair : left) {
            if (pair.first == scores[subject]) {
                pair.second--; 
                break;
            }
        }
        scores.erase(subject);
    }

    int cnt = 0;
    int tot = M - K;
    
    // min
    sort(left.begin(), left.end());
    for(const auto& pair:left)
    {
        if(cnt >= tot)
        {
            break;
        }
        if(cnt + pair.second > tot)
        {
            min_score += (tot - cnt) * pair.first;
            cnt += tot - cnt;
            break;
        }

        cnt += pair.second;
        min_score += pair.first * pair.second;
    }

    // max
    cnt = 0;
    sort(left.begin(), left.end(), greater<>());
    for(const auto& pair:left)
    {
        if(cnt >= tot)
        {
            break;
        }
        if(cnt + pair.second > tot)
        {
            max_score += (tot - cnt) * pair.first;
            cnt += tot - cnt;
            break;
        }

        cnt += pair.second;
        max_score += pair.first * pair.second;
    }
    cout << min_score << " " << max_score << endl;

    return EXIT_SUCCESS;
}