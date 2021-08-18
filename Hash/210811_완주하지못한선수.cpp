#include <string>
#include <vector>
#include <iostream>
#include <hash_map>

using namespace std;


int hash_key(string data){
    return data[0] - 'a';
}


string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    vector<string> hashMap[26];
    
    // save value in hashmap, O(N)    
    for (int i = 0; i < completion.size(); i++) {
        string cur = completion[i];
        int key = hash_key(cur);
        hashMap[key].push_back(cur);
    }

    // find and remove arrived player, O(N * N)
    for (int i = 0; i < participant.size(); i++) {
        int same_flag = 0;
        string cur = participant[i];
        
        int key = hash_key(cur);
        for (int j = 0; j < hashMap[key].size(); j++){
            if (cur.compare(hashMap[key][j]) == 0){ // 일치하는 게 있다면
                hashMap[key].erase(hashMap[key].begin() + j);
                same_flag = 1;
                break;
            }
        }
        if (!same_flag) {
            answer = cur;
            return answer;
        }
    }
	
   return answer;
}