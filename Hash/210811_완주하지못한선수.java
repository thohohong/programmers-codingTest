package Hash;
import java.util.HashMap;

class Solution {
  public String solution(String[] participant, String[] completion) {
      String answer = "";
      
      HashMap<String, Integer> map = new HashMap<>();

      for (int i = 0; i < completion.length; i++){
        if (map.get(completion[i]) == null){
          map.put(completion[i], 1);
        }
        else {
          map.replace(completion[i], map.get(completion[i]) + 1);
        }
      }
      
      for (int i = 0; i < participant.length; i++){
        Integer value = map.get(participant[i]);
        if (value == null || value == 0){
          answer = participant[i];
          return answer;
        }
        else {
          map.replace(participant[i], map.get(participant[i]) - 1);
        }
      }

      return answer;
  }
}