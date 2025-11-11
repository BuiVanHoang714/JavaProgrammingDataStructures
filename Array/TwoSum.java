
public class TwoSum {
    public static void main(String[] args) {
        int[] example = {1,2,3,4};
        // Example: Assign grades based on scores
        System.out.println((twoSum(example, 3).));
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;

                    }
                }
            }
            return result;
        }
    }
}