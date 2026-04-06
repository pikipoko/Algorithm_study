#include <cstdlib>
#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;

bool compare(const pair<string, int>& a, const pair<string, int>& b) {
    if (a.second != b.second)
        return a.second > b.second;  // int 기준 내림차순
    else
        return a.first < b.first;    // string 기준 오름차순
}

int main()
{
    int n; // 학생 수
    cin >> n;
    cin.ignore();

    string line;
    getline(cin, line);

    istringstream iss(line);
    vector<pair<string, int>> students;

    string student;
    while(iss >> student)
    {
        students.push_back({student, 0});
    }

    for(int i = 0; i < n; i++)
    {
        string aLikeB = "";
        string b = "";
        getline(cin, aLikeB);
        istringstream iss(aLikeB);

        while(iss >> b)
        {
            for (auto& pair : students) {
                if (pair.first == b) {
                    pair.second++; 
                    break;
                }
            }
        }
    }
    sort(students.begin(), students.end(), compare);
    for (auto& pair : students) {
        cout << pair.first << " " << pair.second << endl;
    }

    return EXIT_SUCCESS;
}