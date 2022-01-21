  public class TwoSum{
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        // Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i] + nums[j]) == target){
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        return answer;
    }
      public static void main(String args[]){
        //   int[] ans = twoSum(nums, target)
      }
  }
