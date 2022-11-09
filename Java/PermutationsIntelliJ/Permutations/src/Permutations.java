import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
                List<Integer> rightSide = numbers.subList(i + 1, numbers.size());
                ArrayList<Integer> combinedList = new ArrayList<>();
                combinedList.addAll(leftSide);
                combinedList.addAll(rightSide);
                ArrayList<Integer> combinedListCopy = new ArrayList<>();
                combinedListCopy = (ArrayList<Integer>) combinedList.clone();
                System.out.println(combinedListCopy);
                generatePermutations((ArrayList<Integer>)combinedListCopy, answer, result);
                combinedList.clear();
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> numbers = IntStream.of(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> holder = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations((ArrayList<Integer>)numbers, holder, result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);
    }
}
