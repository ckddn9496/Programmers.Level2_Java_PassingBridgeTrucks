import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6}; // return 8
		
//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck_weights = {10}; // return 101
		
//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10}; // return 110
		
		System.out.println(new Solution().solution(bridge_length, weight, truck_weights));
	}

}
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totweight = 0;
        int idx = 0;
        Queue<Integer> truckList = new LinkedList<Integer>();
        Queue<Integer> timer = new LinkedList<Integer>();
        
        while (idx < truck_weights.length) {
        	answer++;
        	if (!timer.isEmpty() && timer.peek() == answer) {
        		timer.poll();
        		totweight -= truckList.poll();
        	}
        	if (totweight + truck_weights[idx] > weight)
        		answer = timer.peek() - 1;
        	else {
        		totweight+= truck_weights[idx];
        		truckList.add(truck_weights[idx]);
        		timer.add(answer+bridge_length);
        		idx++;
        	}
        }
        while (!timer.isEmpty())
        	answer = timer.poll();
        	
        	
        
        return answer;
    }
}