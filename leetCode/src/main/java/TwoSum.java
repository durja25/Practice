public class TwoSum {

    public static void main(String[] args) {
//        System.out.printf();

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);

    }

    private static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        // if we reach here means we did not find any pair of numbers that add up to target
        // so return empty array.
        return new int[0];
    }
}
