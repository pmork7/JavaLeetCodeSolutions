public class Solution {
    public static int findZero(int[] nums) {
        return nums.length - (nums[nums.length - 1] + 1);
    }

    public static int search(int[] nums, int target) {
        System.out.println(findZero(nums));
        return 0;
    }
    
    public static void main(String[] args) {
      int[] nums = {4,5,6,7,0,1,2};
      search(nums, 1);
    }
}