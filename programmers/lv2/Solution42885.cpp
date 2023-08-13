#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

/*
너무 자바 스럽게 푼거 같음
vector 메서드 익히기
*/

int solution(vector<int> people, int limit) {
    int answer = people.size();
    sort(people.begin(), people.end());
    int j = 0;
    int maxtmp = answer;
    for (int i = 0; i < people.size() / 2; i++) {
        j = maxtmp - 1;
        while (true) {
            if (j <= i) {
                return answer;
            }
            if (people[i] + people[j] <= limit) {
                maxtmp = j;
                answer--;
                break;
            }
            j--;
        }
    }
    return answer;
}