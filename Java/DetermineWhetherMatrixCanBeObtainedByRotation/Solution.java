import java.util.*;

public class Solution {
   public static void rotateImage(int[][] matrix) {
      for (int first = 0, last = matrix.length - 1; first < last; first++, last--) {
         int[] temp = matrix[first];
         matrix[first] = matrix[last];
         matrix[last] = temp;
      }
      
      for (int i = 0; i < matrix.length; i++) {
         for (int j = i + 1; j < matrix[0].length; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
         }
      }
   }
   
   public static boolean findRotation(int[][] matrix, int[][] target) {
      for (int i = 0; i < 4; i++) {
         if (Arrays.deepEquals(matrix, target)) {
            return true;
         }
         rotateImage(matrix);
      }
      return false;
   }
   
   public static void main(String[] args) {
      int[][] a = {{1,2},{3,4}};
      int[][] b = {{1,2},{3,4}};
      int[][] c = {{3,1},{4,2}};
      System.out.println(findRotation(a,c));
   }
}