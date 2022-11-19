import java.util.*;
import java.math.*;

public class Solution {
   public static List<Integer> primeSieve(int n) {
      if (n > 0) {
         List<Integer> numbers = new LinkedList<>();
         List<Integer> primes = new LinkedList<>();
         for (int i = 2; i <= n; i++) {
            numbers.add(i);
         }
         while (!numbers.isEmpty()) {
            int front = numbers.remove(0);
            primes.add(front);
            Iterator<Integer> iter = numbers.iterator();
            while (iter.hasNext()) {
               int current = iter.next();
               if (current % front == 0) {
                  iter.remove();
               }
            }
         }
         return primes;
      } else {
         List<Integer> numbers = new LinkedList<>();
         List<Integer> primes = new LinkedList<>();
         for (int i = -2; i >= n; i--) {
            numbers.add(i);
         }
         while (!numbers.isEmpty()) {
            int front = numbers.remove(0);
            primes.add(front);
            Iterator<Integer> iter = numbers.iterator();
            while (iter.hasNext()) {
               int current = iter.next();
               if (current % front == 0) {
                  iter.remove();
               }
            }
         }
         return primes;      
      }
   }
   
   public static SortedSet<Integer> findFactors(int n) {
      SortedSet<Integer> factors = new TreeSet<>();
      factors.add(1);
      factors.add(n);
      for (int i = 2; i <= n; i++) {
         if (n % i == 0) {
            factors.add(i);
            factors.add(n / i);
         }
      }
      return factors;
   }
   
   public static boolean isUgly(int n) {
      int twosCount = 0;
      int temp = n;
      while (temp % 2 == 0) {
         temp /= 2;
         twosCount++;
      }
      int threesCount = 0;
      temp = n;
      while (temp % 3 == 0) {
         temp /= 3;
         threesCount++;
      }
      temp = n;
      int fivesCount = 0;
      while (temp % 5 == 0) {
         temp /= 5;
         fivesCount++;
      }
      return ((int) Math.pow(2, twosCount) * (int) Math.pow(3, threesCount) * (int) Math.pow(5, fivesCount)) == n;
   }
   
   public static void main(String[] args) {
      System.out.println(isUgly(14));
   }  
}