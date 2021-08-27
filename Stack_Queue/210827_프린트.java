import java.util.*;

// Score : 100 / 100

class Solution {
  public int solution(int[] priorities, int location) {
      int answer = 0;
      int idx = 0;
      boolean isMoved = false;

      Queue<Integer> front = new LinkedList<>();
      Queue<Integer> back = new LinkedList<>();
      Queue<Integer> temp = new LinkedList<>();

      int value = priorities[location];
      int[] num = new int[9];

      for (int i = 0; i < 9; i++){
        num[i] = 0;
      }

      for (int i = 0; i < priorities.length; i++){
        num[priorities[i] - 1]++;
      }


      for (int i = 0; i < location; i++){
        front.add(priorities[i]);
      }

      for (int i = location + 1; i < priorities.length; i++){
        back.add(priorities[i]);
      }

      boolean isOver = false;
      
      while(!isOver){
        while(!front.isEmpty()){
          int cur = front.poll();
          isMoved = false;
          for (int i = cur; i < 9; i++){
            if (num[i] > 0){
              back.add(cur);
              isMoved = true;
              break;
            }
          }

          if (!isMoved){
            idx++;
            num[cur-1]--;
          }
        }

        isMoved = false;

        for (int i = value; i < 9; i++){
          if (num[i] > 0) {
            temp = front;
            front = back;
            back = temp;
            isMoved = true;
            break;
          }
        }
        if (!isMoved) isOver = true;
      }

      answer = idx + 1;
      return answer;
  }
}