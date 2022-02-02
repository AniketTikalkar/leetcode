import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Duplicates {
    public boolean setImplementation(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        return set.size() != nums.length;
    }
    public boolean mapImplementation(int[] nums){
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
           if(!map.containsKey(nums[i])){
               map.put(nums[i],true);
           }
        }
        return map.size() != nums.length;
    }
    public boolean containsDuplicate(int[] nums) {
        //set implementation
        // return setImplementation(nums);
        //map implementation
        return mapImplementation(nums);
        
        
    }
    public static void main(String[] args) {
        /**
         * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
         */
    }
}
