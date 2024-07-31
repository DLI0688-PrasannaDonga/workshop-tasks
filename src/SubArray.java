import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class SubArray{
    public static List<int[]> subarraysWithGivenSum(int nums[], int target) {
        ArrayList<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (map.containsKey(currentSum - target)) {
                for (int startIdx : map.get(currentSum - target)) {
                    result.add(new int[]{startIdx + 1, i});
                }
            }

            if (!map.containsKey(currentSum)) {
                map.put(currentSum, new ArrayList<>());
            }
            map.get(currentSum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter array length");
        int n= sc.nextInt();
        int[] nums=new int[n];
        System.out.println("Enter array Elements");
        for (int i=0;i<nums.length;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println("Enter target :");
        int target=sc.nextInt();
        List<int[]> subarrays = subarraysWithGivenSum(nums, target);

        for (int[] sub : subarrays) {
            System.out.println("index " + sub[0] + " to " + sub[1]);
        }
    }
}

