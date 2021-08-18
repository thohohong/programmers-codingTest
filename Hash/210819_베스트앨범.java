import java.util.*;
import java.util.Map.Entry;

class Pair implements Comparable<Pair>{
  int playNum;
  int uniqueNum;

  public Pair(int playNum, int uniqueNum){
    this.playNum = playNum;
    this.uniqueNum = uniqueNum;
  }

  public int compareTo(Pair a){
    if (this.playNum > a.playNum){
      return -1;
    }
    else if (this.playNum == a.playNum){
      if (this.uniqueNum < a.uniqueNum){
        return -1;
      }
      else {
        return 1;
      }
    }
    else {
      return 1;
    }
  }
}

class Solution {
  public int[] solution(String[] genres, int[] plays) {
      int[] answer = {};
      HashMap<String, HashSet<Pair>> map = new HashMap<>();
      for (int i = 0; i < genres.length; i++){
        HashSet<Pair> value = map.get(genres[i]);
        if (value == null){
          value = new HashSet<>();
          map.put(genres[i], value);
        }
        Pair newPair = new Pair(plays[i], i);
        value.add(newPair);
        map.replace(genres[i], value);
      }
      

      HashMap<String, List<Pair>> valueSortedMap = new HashMap<>();
      HashMap<String, Integer> playNumMap = new HashMap<>();
      
      for (String genre : map.keySet()){
        List<Pair> newValue = new ArrayList<>(map.get(genre));
        Collections.sort(newValue);
        valueSortedMap.put(genre, newValue);

        int sum = 0;
        for (int i = 0; i < newValue.size(); i++){
          sum += newValue.get(i).playNum;
        }
        playNumMap.put(genre, sum);
      }

      List<Entry<String, Integer>> sortedPlayNumList = new ArrayList<>(playNumMap.entrySet());
      
      Collections.sort(sortedPlayNumList, new Comparator<Entry<String, Integer>>(){
        @Override
        public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
          // TODO Auto-generated method stub
          return o2.getValue().compareTo(o1.getValue());
        }
      });

      System.out.println(sortedPlayNumList.get(0));

      List<Integer> answerList = new ArrayList<>();
      for (int i = 0; i < sortedPlayNumList.size(); i++){
        String genre = sortedPlayNumList.get(i).getKey();
        
        answerList.add(valueSortedMap.get(genre).get(0).uniqueNum);
        if (valueSortedMap.get(genre).size() > 1){
          answerList.add(valueSortedMap.get(genre).get(1).uniqueNum);
        }
      }

      answer = new int[answerList.size()];
      int idx = 0;
      for (Integer i : answerList){
        answer[idx++] = i;
      }

      return answer;
  }
}

