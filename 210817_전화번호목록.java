import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// Score : 91.7 / 100.0


class Solution {
  public boolean solution(String[] phone_book) {
      boolean answer = true;
      HashMap<Integer, List<String>> map = new HashMap<>();

      // 번호는 무조건 0~9 중 하나의 값을 가진다.
      // 제일 첫번째 자리를 Key 값으로 가지는 문자열들을 ArrayList로 저장
      for (int i = 0; i < 10; i++){
        List<String> newList = new ArrayList<>();
        map.put(i, newList);
      }

      for (int i = 0; i < phone_book.length; i++){
        int key = phone_book[i].charAt(0) - '0';
        List<String> array = map.get(key);

        // 지금 비교하는 문자열을 저장된 문자열들과 비교.
        for(int j = 0; j < array.size(); j++){
          int curLength = phone_book[i].length();
          int compareLength = array.get(j).length();

          // 비교하려는 문자열이 현재 문자열보다 길다면,
          // 비교 문자열이 접두사라고 가정하고 비교
          if (compareLength > curLength){
            if(phone_book[i].equals(array.get(j).substring(0, curLength))){
              answer = false;
              return answer;
            }
          }
          // 현재 문자열이 비교하려는 문자열보다 길다면,
          // 현재 문자열이 접두사라고 가정하고 비교
          else {
            if(array.get(j).equals(phone_book[i].substring(0, compareLength))){
              answer = false;
              return answer;
            }
          }
        }
        // return하지 않고 빠져나온다면 현재 문자열에선 접두사가 존재하지 않음
        // array에 지금 문자열을 추가
        array.add(phone_book[i]);
        map.replace(phone_book[i].charAt(0) - '0', array);
      }
      
      return answer;
  }
}