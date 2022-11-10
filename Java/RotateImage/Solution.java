import java.util.*;

public class Solution {
   public static void drawGrid(int n) {
      System.out.println("--- ".repeat(n));
         for (int i = 0; i < n; i++) {
            System.out.print("| | ".repeat(n));
            System.out.println();
         }
         System.out.println("--- ".repeat(n));
   }
   
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

   public static void main(String[] args) {
      //drawGrid(5);
      int[][] numbers = {{1,2},{3,4}};
      rotateImage(numbers);
      System.out.println(Arrays.deepToString(numbers));
   }
}