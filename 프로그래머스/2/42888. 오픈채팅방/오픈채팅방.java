import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>(); 
        int count = 0;  //change의 경우 카운트 해준다.
        
        for(int i = 0; i < record.length; i++){
            String[] arr = record[i].split(" ");
            
            if(arr[0].equals("Leave")){ 
                continue;
            } else if(arr[0].equals("Enter")){ 
                map.put(arr[1], arr[2]);
            } else {                           
                map.put(arr[1], arr[2]);
                count++;
            }
        }
        
        String[] answer = new String[record.length - count];
        int index = 0;
        
        for(int i = 0; i < record.length; i++){
            String[] arr = record[i].split(" ");
            String nickname = map.get(arr[1]);
            
            if(arr[0].equals("Enter")){                   
                answer[index++] = nickname + "님이 들어왔습니다.";
            } else if(arr[0].equals("Leave")){          
                answer[index++] = nickname + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}