package algorithm;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int result = 0;
        Map<Integer, Integer> preSumMap = new HashMap<Integer, Integer>();
        preSumMap.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	if (preSumMap.containsKey(sum - k)) {
        		result += preSumMap.get(sum - k);
        	}
        	preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}
