#include <iostream>
#include <vector>

using namespace std;
/*
너무 푸는 시간이 오래 걸렸음
vector 익히기
*/
int solution(int n, vector<int>& lost, vector<int>& reserve) {
    vector<int> people(n, 0);
    int answer = n;

    for (int l : lost)
        people[l - 1]--;
    for (int r : reserve)
        people[r - 1]++;

    for (int i = 0; i < people.size(); i++) {
        if (people[i] == -1) {
            if (i - 1 >= 0 && people[i - 1] == 1) {
                people[i]++;
                people[i - 1]--;
            }
            else if (i + 1 < people.size() && people[i + 1] == 1) {
                people[i]++;
                people[i + 1]--;
            }
            else {
                answer--;
            }
        }
    }
    return answer;
}