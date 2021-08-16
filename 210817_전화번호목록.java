import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// Score : 91.7 / 100.0


class Solution {
  public boolean solution(String[] phone_book) {
      boolean answer = true;
      HashMap<Integer, List<String>> map = new HashMap<>();

      for (int i = 0; i < 10; i++){
        List<String> newList = new ArrayList<>();
        map.put(i, newList);
      }

      for (int i = 0; i < phone_book.length; i++){
        int key = phone_book[i].charAt(0) - '0';
        List<String> array = map.get(key);

        for(int j = 0; j < array.size(); j++){
          int curLength = phone_book[i].length();
          int compareLength = array.get(j).length();

          if (compareLength > curLength){
            if(phone_book[i].equals(array.get(j).substring(0, curLength))){
              answer = false;
              return answer;
            }
          }
          else {
            if(array.get(j).equals(phone_book[i].substring(0, compareLength))){
              answer = false;
              return answer;
            }
          }
        }
        array.add(phone_book[i]);
        map.replace(phone_book[i].charAt(0) - '0', array);
      }
      
      return answer;
  }
}