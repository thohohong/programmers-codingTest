import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        //'의상의 종류 : 해당 종류의 갯수'로 해시맵에 저장
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++){
            Integer value = map.get(clothes[i][1]);
            if (value != null) {
                map.replace(clothes[i][1], ++value);
            }
            else {
                map.put(clothes[i][1], 1);
            }
        }
        
        answer = 1;
        for (String i : map.keySet()){
            answer *= map.get(i) + 1;
        }
        answer -= 1;
        return answer;
    }
}