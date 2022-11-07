import java.util.*;
import java.math.*;

public class Solution {
    public static int findZero(int[] nums) {
        return nums[nums.length - 1];
    }

    public static int search(int[] nums, int target) {
        int offset = findZero(nums);
        System.out.println(offset);
        int result = modifiedBinarySearch(nums, target, offset);
        return result;
    }
    
    /*public static int modulo(int n, int m) {
      if (n % m > 0) {
         return n % m;
      }
      return 
    }*/
    
    public static int modifiedBinarySearch(int[] nums, int target, int offset) {
      int min = 0;
      int max = nums.length - 1;      
      while (min <= max) {
         int mid = (max + min) / 2;
         int searchIndex = Math.floorMod((mid - offset), (nums.length));
         if (target > nums[searchIndex]) {
            min = mid + 1;
         } else if (target == nums[searchIndex]) {
            return searchIndex;
         } else if (target < nums[searchIndex]) {
            max = mid - 1;
         }
      }
      return -1;
    }
    
    public static void main(String[] args) {
      int[] nums = {4,5,6,7,8,9,10,0,1,2,3};
      System.out.println(Arrays.toString(nums));
      System.out.println(search(nums, 10));
    }
}