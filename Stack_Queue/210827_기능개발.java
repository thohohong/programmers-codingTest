import java.util.*;

// Score : 100 / 100

class Solution {
  public int[] solution(int[] progresses, int[] speeds) {
      int[] answer = {};
      List<Integer> answer_ = new ArrayList<>();
      int day = 0;
      int num = 0;
      
      Queue<Integer> q_pro = new LinkedList<>();
      Queue<Integer> q_spe = new LinkedList<>();

      for (int i = 0; i < progresses.length; i++){
        q_pro.add(progresses[i]);
        q_spe.add(speeds[i]);
      }

      while(!q_pro.isEmpty()) {
        int cur_pro = q_pro.poll();
        int cur_spe = q_spe.poll();
        int plus_day = 0;

        cur_pro += day * cur_spe;

        if (cur_pro < 100){
          if (num != 0){
            answer_.add(num);
            num = 0;
          }
          plus_day = (100 - cur_pro) / cur_spe;
          if (cur_pro % cur_spe > 0) {
            plus_day++;
          } 
          day += plus_day;
        }
        num++;
      }

      if (num != 0){
        answer_.add(num);
      }

      answer = new int[answer_.size()];
      int idx = 0;
      for (Integer i : answer_){
        answer[idx++] = i;
      }

      return answer;      
  }
}