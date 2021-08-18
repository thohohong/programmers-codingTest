import java.util.*;

// Score : 100 / 100

class Solution {
  public boolean solution(String[] phone_book) {
      boolean answer = true;
      
      HashSet<String> set = new HashSet<>();

      // HashSet에 전화번호들을 저장
      for (int i = 0; i < phone_book.length; i++){
        set.add(phone_book[i]);
      }

      // HashSet을 순서대로 정렬해서 저장할 List 생성
      List<String> sorted = new ArrayList<>(set);

      // 정렬
      Collections.sort(sorted);

      // 문자열들을 순서대로 2개씩 비교
      for (int i = 0; i < phone_book.length - 1; i++){
        String cur = sorted.get(i);
        String compare = sorted.get(i + 1);
        if (cur.length() < compare.length()){
          if (cur.equals(compare.substring(0, cur.length()))){
            return false;
          }
        }
      }

      return answer;
  }
}