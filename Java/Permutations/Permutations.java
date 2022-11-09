import java.util.*;
import java.util.stream.Collectors;
import java.util.stream;

public class Permutations {
   public static void generatePermutations(ArrayList<Integer> numbers, ArrayList<Integer> answer, List<List<Integer>> result) {
      if (numbers.size() == 0) {
         ArrayList<Integer> answerCopy = (ArrayList<Integer>) answer.clone(); 
         result.add(answerCopy);
         answer.clear();
      } else {
         for (int i = 0; i < numbers.size(); i++) {
            answer.add(numbers.get(i));
            List<Integer> leftSide = numbers.subList(0, i);
            List<Integer> rightSide = numbers.subList(i, numbers.size());
            List<Integer> combinedList = new ArrayList<Integer>();
            combinedList.addAll(leftSide);
            combinedList.addAll(rightSide);
            generatePermutations((ArrayList<Integer>)combinedList, answer, result);
         }
      }
   }

   public static List<List<Integer>> permute(int[] nums) {
      List<Integer> numbers = IntStream.of(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
      System.out.println(numbers);
      ArrayList<Integer> holder = new ArrayList<Integer>();
      List<List<Integer>> result = new ArrayList<>();
      generatePermutations((ArrayList<Integer>)numbers, holder, result);
      return result;
   }
   
   public static void main(String[] args) {
      int[] nums = {1,2,3};
      List<List<Integer>> result = permute(nums);
      System.out.println(result.toString());
   }
}