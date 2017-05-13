package algorithm;

import java.util.HashMap;
import java.util.Map;

public class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
    	if (k == 0) {
    		return false;
    	}
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	sum = sum % k;
        	Integer pre = map.get(sum);
        	if (pre != null) {
        		if (i - pre > 1) {
        			return true;
        		}
        	} else {
        		map.put(sum, i);
        	}
        }
        return true;
    }
}
