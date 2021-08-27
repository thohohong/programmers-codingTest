import java.util.*;

// Score : 100 / 100

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int count = 0;
        Queue<Integer> time = new LinkedList<>();    //value = time
        Queue<Integer> entering = new LinkedList<>();//value = weight
        Queue<Integer> wait = new LinkedList<>();    //value = weight
        
        int cur_time = 0;
        int cur_weight = 0;
        int cur_length = 0;
        
        for (int i= 0; i < truck_weights.length; i++){
            wait.add(truck_weights[i]);
        }
        
        boolean isFull = false;        
        while(!wait.isEmpty() || !entering.isEmpty()){
            cur_time++;
            if (!entering.isEmpty()){
                
                int front_truck = entering.peek();
                int front_truck_time = time.peek();
                
                if (isFull){
                    int left_length = bridge_length - (cur_time - front_truck_time);
                    cur_time += left_length;
                }
                if (cur_time - front_truck_time == bridge_length){ //when first truck outed
                    cur_weight -= front_truck;
                    cur_length--;
                    entering.poll();
                    time.poll();
                    isFull = false;
                }
            }
            if (!wait.isEmpty()){
                
                int cur_truck = wait.peek();
                if (cur_length + 1 > bridge_length || cur_weight + cur_truck > weight) {
                    isFull = true;
                    continue;
                } else { //when bridge has slot
                    time.add(cur_time);
                    entering.add(cur_truck);
                    wait.poll();
                    cur_weight += cur_truck;
                }
            }
        
        }
        answer = cur_time;
        return answer;
    }
}