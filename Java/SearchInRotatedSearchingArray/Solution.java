import java.util.*;
import java.math.*;

public class Solution {
    /* Find offset by pulling the last element from the array. */
    public static int findOffset(int[] nums) {
        return nums[nums.length - 1];
    }
    
    /* Helper method to call findOffset() and binary search methods and return result */
    public static int search(int[] nums, int target) {
        int offset = findOffset(nums);
        int result = modifiedBinarySearch(nums, target, offset);
        return result;
    }
    
    /* A modified binary search that uses the rotation offset to search the correct indices */
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
      int[] nums = {4,5,6,7,0,1,2};
      System.out.println(search(nums, 0));
    }
}